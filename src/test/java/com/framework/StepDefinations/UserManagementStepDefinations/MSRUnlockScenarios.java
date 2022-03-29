package com.framework.StepDefinations.UserManagementStepDefinations;

import static io.restassured.RestAssured.given;

import com.framework.API.APIResources;
import com.framework.API.ResourceBuilder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MSRUnlockScenarios extends ResourceBuilder{
    
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    static String accessToken;
    
    @Given("^Get Salsforce accesstoken api is given$")
    public void get_salsforce_accesstoken_api_is_given() throws Throwable {
        response=given()
               .auth()
               .basic("o4kibkn9f90fe1ji3jvmobe49", "brc3lmu9m2v4hr8fbnppmpc7gsdrpq5g0arordj3uaa6l65kgpe")
               .header("Content-Type","application/x-www-form-urlencoded")
               .header("Accept", "*/*")
               .when()
               .formParam("grant_type","client_credentials")
               .post("https://sitvcmmemberpool.auth.us-east-2.amazoncognito.com/oauth2/token")
               .then().log().all().extract().response();
        System.out.println(response.asString());
    }

    @And("^Fetch Access token$")
    public void fetch_access_token() throws Throwable {
        System.out.println("Access Token "+getJsonPath(response, "access_token"));
        accessToken  = getJsonPath(response, "access_token");
    }
    @When("^pass \"([^\"]*)\" and \"([^\"]*)\" in body$")
    public void pass_something_and_something_in_body(String onlineid, String updatedby) throws Throwable {
        System.out.println("Onlineid"+onlineid);
        System.out.println("UpdatedBy"+updatedby);
        System.out.println(accessToken);
        res=given().spec(requestSpecification())
               .header("x-api-key","gq2BA7h7VA7tuqkEtiWP57ILRY0COdUr7qgoARW0")
               .header("Authorization",accessToken)
               .body("{\r\n\"onlineId\" : \""+onlineid+"\",\r\n   \"updatedBy\" : \""+updatedby+"\"\r\n}");
    }
    @And("^call \"([^\"]*)\" with post method in \"([^\"]*)\"$")
    public void call_something_with_post_method_in_something(String endPoint,String env) throws Throwable {
        APIResources resourceAPI=APIResources.valueOf(endPoint);
        System.out.println(resourceAPI.getResource());
        resspec =new ResponseSpecBuilder().build();
        response =res.when().post(resourceAPI.getResource());
    }

    
    @Then("^Verify Response code as \"([^\"]*)\"$")
    public void verify_response_code_as_something(String strArg1) throws Throwable {
        System.out.println(response.asString());
    }
    
}
