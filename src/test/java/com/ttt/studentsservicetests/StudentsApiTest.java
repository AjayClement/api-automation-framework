package com.ttt.studentsservicetests;


import com.github.javafaker.Faker;
import com.ttt.apimodels.MarksModel;
import com.ttt.apimodels.StudentsModel;
import com.ttt.apimodels.SubjectModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;
import java.util.Arrays;


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

    StudentsModel students = responseBody.as(StudentsModel.class);
    System.out.println(students);
    Assert.assertTrue(students.getName().equals("simon"));
    }

    @Test
    private void studentsPostTest(){
        SubjectModel sem1 = new SubjectModel(99,99,99);
        SubjectModel sem2 =new SubjectModel(88,88,88);
        SubjectModel sem3 = new SubjectModel(77,77,77);

        MarksModel marks =  new MarksModel(sem1,sem2,sem3);
        Faker faker = new Faker();
        StudentsModel studentsModel = new StudentsModel(5,faker.name().firstName()+" "
                +faker.name().lastName(),marks,Arrays.asList("Piano","Programing","Painting"));

          RestAssured.given()
                  .log().all()
                  .baseUri("http://localhost:3000")
                  .body(studentsModel)
                  .when().post("/students")
                  .then().statusCode(201);
    }




}
