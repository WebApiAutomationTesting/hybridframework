package com.visible.apiTestDemo;

import org.testng.annotations.Test;

public class Execution extends RestAssuredDemo{

    @Test
    public void executeTestmethod(){
//        getResponseBody();
//        getResponseBodyByUsingQueryParam();
//        getResponseStatus();
//        getResponseHeaders();
//        getResponseTime();
//        getResponseContentType();
//        getSpecificPartOfResponseBody();
        getResponse();
    }
}
