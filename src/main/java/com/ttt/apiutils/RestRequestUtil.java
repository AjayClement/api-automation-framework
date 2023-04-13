package com.ttt.apiutils;


import com.ttt.enums.ApiRoutes;
import com.ttt.enums.Apps;
import com.ttt.enums.RequestType;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import lombok.NonNull;
import java.util.Map;

public final class RestRequestUtil {

    private static Response response;
    private static final int DEFAULT_SUCCESS_CODE = 200;
    private RestRequestUtil(){

    }

    public static Response doHttpRequestWithNoBody(RequestType requestType, Map<String,String> headers, ApiRoutes path, Map<String,String> pathParams,
                                                                  Map<String,String> queryParams, Apps baseUrl){
       RequestSpecification requestSpecification = constructRequestSpecification(headers, null, pathParams, queryParams, null,baseUrl);
       response = sendHttpRequest(requestType,path,requestSpecification);
       try {
           response.then().statusCode(requestType.getStatusCode());
       }catch (Exception e){
           try {
               response.then().statusCode(DEFAULT_SUCCESS_CODE);
           }catch (Exception ex){
               throw new RuntimeException(ex);
           }

       }
       return response;
    }

    public static Response doHttpRequestWithNoBody(RequestType requestType, Map<String,String> headers, Map<String, String> formParams, ApiRoutes path, Map<String,String> pathParams,
                                                   Map<String,Object> queryParams, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, pathParams, formParams, queryParams, baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBody(RequestType requestType, Map<String,String> headers, Map<String, String> formParams,ApiRoutes path, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, null, formParams, null, baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBody(RequestType requestType, Map<String, String> formParams,ApiRoutes path, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, null, null, formParams, null, baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }


    public static Response doHttpRequestWithNoBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret,Map<String,String> headers, ApiRoutes path, Map<String,String> pathParams,
                                                                     Map<String,String> queryParams, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, pathParams, queryParams, null,baseUrl)
                                                    .auth()
                                                    .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret,Map<String,String> headers, ApiRoutes path,
                                                                    Map<String,String> formParams, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, null, formParams, null,baseUrl)
                .auth()
                .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBodyWithOAuth2(RequestType requestType, String token,Map<String,String> headers, ApiRoutes path,
                                                                 Map<String,Object> queryParams,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, null, null, queryParams,baseUrl)
                .auth()
                .oauth2(token);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret, ApiRoutes path,
                                                                Map<String,String> formParams, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, null, null, formParams, null,baseUrl)
                .auth()
                .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }



    public static Response doHttpRequestWithNoBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret,Map<String,String> headers, ApiRoutes path,
                                                                       Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, null, null, null,baseUrl)
                .auth()
                .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret, ApiRoutes path,
                                                                Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, null, null, null, null,baseUrl)
                                                     .auth()
                                                     .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }


    public static Response doHttpRequestWithNoBody(RequestType requestType,Map<String,String> headers, ApiRoutes path,Map<String,String> pathParams,
                                                              Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, null, pathParams, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }



    public static Response doHttpRequestWithNoBody(RequestType requestType,ApiRoutes path,Map<String,String> pathParams,
                                                              Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, null, pathParams, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static Response doHttpRequestWithNoBody(RequestType requestType,ApiRoutes path, Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, null, null, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static <T> Response doHttpRequestWithBody(RequestType requestType,Map<String,String> headers, T requestBody, ApiRoutes path,Map<String,String> pathParams,
                                                                   Map<String,String> formParams,Map<String,Object> queryParams,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, requestBody, pathParams, formParams, queryParams,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }




    public static <T> Response doHttpRequestWithBodyWithBasicAuth(RequestType requestType, String clientId, String clientSecret,Map<String,String> headers, T requestBody, ApiRoutes path,Map<String,String> pathParams,
                                                     Map<String, String> formParams,Map<String,Object> queryParams,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, requestBody, pathParams, formParams, queryParams,baseUrl)
                                                     .auth()
                                                     .basic(clientId,clientSecret);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }


    public static <T> Response doHttpRequestWithBody(RequestType requestType,Map<String,String> headers, T requestBody, ApiRoutes path,Map<String,String> pathParams
                                                                          ,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, requestBody, pathParams, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static <T> Response doHttpRequestWithBody(RequestType requestType,Map<String,String> headers, Map<String, String> formParams, T requestBody, ApiRoutes path,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, requestBody, null, formParams, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static <T> Response doHttpRequestWithBody(RequestType requestType, T requestBody, ApiRoutes path, Map<String, String> formParams,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, requestBody, null, formParams, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static <T> Response doHttpRequestWithBody(RequestType requestType,Map<String,String> headers, T requestBody, ApiRoutes path,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(headers, requestBody, null, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    public static <T> Response doHttpRequestWithBody(RequestType requestType,T requestBody, ApiRoutes path,Apps baseUrl){
        RequestSpecification requestSpecification = constructRequestSpecification(null, requestBody, null, null, null,baseUrl);
        response = sendHttpRequest(requestType,path,requestSpecification);
        try {
            response.then().statusCode(requestType.getStatusCode());
        }catch (Exception e){
            try {
                response.then().statusCode(DEFAULT_SUCCESS_CODE);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return response;
    }

    private static Response sendHttpRequest(@NonNull RequestType requestType, @NonNull ApiRoutes path,@NonNull RequestSpecification request){
             request.log().all();
             try{
                 switch (requestType){
                     case GET -> response = request.get(path.getRoute());
                     case PUT -> response = request.put(path.getRoute());
                     case POST -> response = request.post(path.getRoute());
                     case DELETE -> response = request.delete(path.getRoute());
                     case PATCH -> response = request.patch(path.getRoute());
                     default -> System.out.println("");
                 }
             }catch (Exception e){
                 try {
                     request.proxy("",8080);
                     switch (requestType){
                         case GET -> response = request.get(path.getRoute());
                         case PUT -> response = request.put(path.getRoute());
                         case POST -> response = request.post(path.getRoute());
                         case DELETE -> response = request.delete(path.getRoute());
                         case PATCH -> response = request.patch(path.getRoute());
                         default -> System.out.println("");
                     }
                 }catch (Exception ex){
                     System.out.println("");
                 }
             }
             response.then().log().all();
             return response;
    }

    private static <T> RequestSpecification constructRequestSpecification(Map<String,String> headers,
                                                                          T requestBody, Map<String,String> pathParams, Map<String, String> formParams, Map<String, Object> queryParams, Apps baseUrl){
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .baseUri(baseUrl.getBaseUrl());

        if(headers != null){
            requestSpec.headers(headers);
        }
        if (requestBody != null){
            requestSpec.body(requestBody);
        }
        if(pathParams != null){
            requestSpec.pathParams(pathParams);
        }
        if(formParams != null){
            requestSpec.formParams(formParams);
        }
        if(queryParams != null){
            requestSpec.queryParams(queryParams);
        }
        return requestSpec;
    }


}
