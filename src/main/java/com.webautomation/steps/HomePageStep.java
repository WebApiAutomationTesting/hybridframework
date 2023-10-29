package com.webautomation.steps;

import com.webautomation.drivers.Drivermanager;
import com.webautomation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HomePageStep {
    HomePage homePage = new HomePage(Drivermanager.getDriver());

    @Given("I navigate to landing page {string}")
    public void iNavigateToLandingPage(String endponint) {
        String baseUrl = "https://www.visible.com";
        homePage.navigateTo(baseUrl+endponint);
        RestAssured.baseURI=baseUrl;
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET, endponint);
        System.out.println(response.statusCode());
        System.out.println(response.statusLine());

        System.out.println(homePage.getPageTitle());

    }
}
