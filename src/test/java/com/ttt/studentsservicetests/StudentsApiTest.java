package com.ttt.studentsservicetests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;

public class StudentsApiTest {

@Test
    private void studentsGetTest(){
    RequestSpecification reqSpec = RestAssured.given()
               .log().all()
               .baseUri("http://localhost:3000")
               .pathParam("id",1)
               .accept(ContentType.JSON)
               .when();

      Response res = reqSpec.get("/students/{id}");
      res.then().statusCode(200);
      ResponseBody responseBody = res.body();
      responseBody.prettyPrint();

     Assert.assertTrue(responseBody.jsonPath().get("name").equals("simon"));
    }

@Test
public void studentsPostTest(){

}



}
