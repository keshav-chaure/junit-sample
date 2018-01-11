package com.kc.rest;


import com.kc.dto.Employee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmplyoeeRest {
    @RequestMapping(value="/addEmployee", method= RequestMethod.POST)
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.add("1", "uno");
        //http://localhost:8080/spring-utility/person/1
       // headers.setLocation(ucb.path("/addEmployee/}").buildAndExpand(person.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
