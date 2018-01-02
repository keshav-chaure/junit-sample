# JUnit and Mokito sample unit test code

##### To read more on logger : https://logback.qos.ch/manual/configuration.html
##### 1. Logback capablity. 
##### 2. Spring dependency.
##### 2. Spring xml and java configuration. 
##### 3. JUnit and Mokito.

###### Argument Capture explained taken form :http://www.javainuse.com/spring/spring-boot-argumentcaptor

Consider a scenario where we are testing a method that depends on a collaborator. This collaborator takes an argument while calling one of its methods. 
Now there can be two scenarios-
1. The argument is passed externally to the method we are testing and then used by the collaborator during its own method call
    method(argument arg)
	{
	 collaborator.callMethod(arg);
	}
	
To test this method we mock the collaborator and then call the method as follows
	method(arg1);
	Mockito.verify(collaborator).callMethod(arg1);
	
So here in the test method we have the arg1 instance and hence can be verified
2. The argument being used by the collaborator to make its own method call is not passed externally and but created inside the method being tested
   
    method()
	{
	 arg=CreateArgumentInternally();
	 collaborator.callMethod(arg);
	}
	
To test this method we mock the collaborator and then call the method as follows
    method();
	
But how do we verify the collaborator was called with which arguments since we don't have the access to the argument as it was created internally inside the method. This where the Mockito ArgumentCaptor comes into picture. Using the ArgumentCaptor we can get the argument instance created internally and used in the collaborator call and thus we can verify it.
	
   Mockito.verify(collaborator).callMethod(captor.capture());
   Argument actual = captor.getValue();  