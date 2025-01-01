package com.spring.springboot.restful_web_services.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

//    This is of versioning of API

    // versioning by path variabel
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob charter");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Carter"));
    }

    //versioning by params
    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParamter(){
        return new PersonV1("Bob charter");
    }

    @GetMapping(path = "/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParamter(){
        return new PersonV2(new Name("Bob","Carter"));
    }

    //versioning by headers
    @GetMapping(path = "/person/header",headers = "X-API_VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Bob charter");
    }

    @GetMapping(path = "/person/header",headers = "X-API_VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Bob","Carter"));
    }

    // versioning By Content Negotiation (Media Type)
    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("Bob charter");
    }

    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("Bob","Carter"));
    }


}
