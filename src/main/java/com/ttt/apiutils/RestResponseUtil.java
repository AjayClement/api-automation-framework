package com.ttt.apiutils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public final class RestResponseUtil {
    private RestResponseUtil(){

    }
    @SuppressWarnings("unchecked")
    public static <T> T getResposeBody(Class<T> responseModelClass, Response response) {
        try {
          return (T) response.getBody().as(responseModelClass.getDeclaredConstructor()
                   .getClass());
        } catch (Exception e) {
            throw new RuntimeException("Unable to map response with class: "+responseModelClass.getName()
                    ,e);
        }
    }
    public static int getResponseStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static String getResponseContent(Response response) {
        return response.getBody().asString();
    }

    public static String getResponseValueWithPath(Response response,String path) {
        return response.path(path);
    }

    public static boolean isResponseSuccessful(Response response) {
        int statusCode = getResponseStatusCode(response);
        return statusCode>=200
              && statusCode<=299;
    }

    public static String getResponseStatusDescription(Response response) {
        return response.getStatusLine();
    }

    public static void validateSchema(Response response, String schemaName){
       response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaName));
    }

}
