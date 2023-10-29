package com.webautomation.apiTestDemo;

import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

public class RestAssuredDemo {

//    Returns a validatable response that's lets you validate the response. Usage example:
//
//    given().
//    param("firstName", "John").
//    param("lastName", "Doe").
//    when().
//    get("/greet").
//    then().
//    body("greeting", equalTo("John Doe"));

    String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    //        @Test
    public void getResponseBody() {

//        RestAssured.baseURI=base_url+"/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
        RestAssured.given()
                .when()
                .get(url)
                .then()
                .log()
                .all();
        System.out.println("Deprecated");
    }


    //    @Test
    public void getResponseBodyByUsingQueryParam() {
        RestAssured.baseURI = "http://demo.guru99.com/V4/sinkministatement.php";
        RestAssured
                .given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get(RestAssured.baseURI)
                .then()
                .log()
                .body();
    }

    //    @Test
    public void getResponseStatus() {
        int statusCode = RestAssured
                .given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when()
                .get("http://demo.guru99.com/V4/sinkministatement.php")
                .getStatusCode();
        System.out.println(statusCode);

   /*     Below script is Assertion Validation
        hamcrest-all dependency required to validate the assertion part
*/
        RestAssured
                .given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);

        int visibleStatusCode = RestAssured
                .when()
                .get("https://www.visible.com/shop/smartphones/google-pixel-8?sku=GA04803-US")
                .getStatusCode();

        System.out.println("visibleStatusCode -->  " + visibleStatusCode);

    }

    public void getResponseHeaders() {
//        Please note that ‘given().when()’ is skipped here, and the code line starts from get(), this is because there is no precondition or verification made here to hit the request and get a response. In such cases, it’s optional to use the same.

        System.out.println(RestAssured
                .get(url)
                .then()
                .extract()
                .headers());

        System.out.println(RestAssured
                .get("https://www.visible.com/shop/smartphones/google-pixel-8?sku=GA04803-US")
                .then()
                .extract()
                .headers());
    }

    public void getResponseTime() {
        System.out.println(RestAssured
                .get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    public void getResponseContentType() {
        String contentType = RestAssured
                .get(url)
                .then()
                .extract()
                .contentType();

        System.out.println(contentType);
    }

    public void getSpecificPartOfResponseBody() {
        String names = RestAssured.when().get("https://dummy.restapiexample.com/api/v1/employees").then().extract().path("data.employee_name").toString();
        System.out.println(names);


//below script not working
//        String ErrorMsg = RestAssured
//                .when()
//                .get(url)
//                .then()
//                .extract()
//                .path("result:.message.ErrorMsg:").toString();

//        for (String el : amounts) {
//            System.out.println(ErrorMsg);
//        }
    }

    public void getResponse() {
        RestAssured
                .get("https://www.visible.com/shop/smartphones/google-pixel-8?sku=GA04803-US")
                .then()
                .log()
                .body();
    }
}

