package com.kc;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kc.dto.Order;
import com.kc.exception.OrderException;
import com.kc.service.OrderBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazonaws.services.s3.AmazonS3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class MyXMLApplicationClient {
    private static final Logger logger = LoggerFactory.getLogger(MyXMLApplicationClient.class);


    @Autowired
    private OrderBO orderBO;

    public void processRequests() throws OrderException {
        logger.info("In Client Application..");
        logger.debug("In Client Application..");

        placeOrder();

    }

    private void placeOrder() throws OrderException {

        System.out.println("in process "+orderBO);
        Order order=new Order(11,0);
        logger.info("In Client placeing order..{}",order.getId());
        logger.debug("In Client placeing order..{}",order.getId());
        this.orderBO.placeOrder(order);



    }
    public void uploadToS3()  {
        String bucketName     = "kc-s3bucket123";
        String keyName        = "a";
        String uploadFileName = "C:\\Users\\keshav\\Downloads\\a.jpg";
        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());

        logger.info("fetch list of s3 bukets");
        for (Bucket bucket : s3client.listBuckets()) {
            System.out.println(" - " + bucket.getName());
        }


        //String uploadFileName = "C:\\Users\\keshav\\Downloads\\a.jpg";

        logger.info("file to file FileInputStream..");
        logger.info("file to file FileInputStream using core java..");
        //using core
        FileInputStream fi=null;
        try {
            fi=new FileInputStream(uploadFileName);

        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }

        //using common io apache labrary
        // InputStream targetStream = FileUtils.openInputStream(uploadFileName);

        // using guava
        // InputStream targetStream = FileUtils.openInputStream(uploadFileName);

        logger.info("Setting metadata ");
        ObjectMetadata meta=new ObjectMetadata();
        meta.setContentLength(10);
        meta.setContentLanguage("hindi");
        meta.addUserMetadata("name","something");
        meta.addUserMetadata("color","value of some key");

        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(uploadFileName);
            s3client.putObject(new PutObjectRequest(
                    bucketName, keyName, file));
            s3client.putObject(bucketName,keyName,fi,meta);

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
        logger.info("file uploaded to s3 ");
    }

}