package com.ttt.apiutils;

import com.ttt.datamanager.ConfigPropertyManager;
import com.ttt.enums.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public final class RestTokenUtil {

    private RestTokenUtil(){

    }

    private static final String CLIENT_ID_REF = "client_id";
    private static final String CLIENT_SECRET_REF = "client_secret";
    private static final String GRANT_TYPE_REF = "grant_type";

    public static String getAccessToken(Apps applicationName, ApiRoutes apiRoutes){
        Map<String,String> formParams = getAppFormParams(applicationName);
        Response response = RestRequestUtil.doHttpRequestWithNoBody(RequestType.POST,formParams,apiRoutes,applicationName);
        RestResponseUtil.getResponseValueWithPath(response,"expires_in");
       return RestResponseUtil.getResponseValueWithPath(response,"access_token");
    }

    private static Map<String,String> getAppFormParams(Apps appName){
        Map<String, String> formParams = new HashMap<>();
        switch (appName){
            case SPOTIFY:
                formParams.putAll(getAppClientCredentials(appName));
                formParams.put(GRANT_TYPE_REF, getAppGrantType(appName));
                formParams.put("refresh_token"
                        ,ConfigPropertyManager.getConfigProperty(ConfigPropertyKeys.SPOTIFY_REFRESH_TOKEN));
                break;
            case DONUTS:
                break;

        }
        return formParams;
    }

    private static Map<String,String> getAppClientCredentials(Apps appName){
        Map<String,String> credentialsMap =  new HashMap<>();
        switch (appName){
            case SPOTIFY:
               credentialsMap.put(CLIENT_ID_REF, ConfigPropertyManager
                       .getConfigProperty(ConfigPropertyKeys.SPOTIFY_CLIENT_ID));
               credentialsMap.put(CLIENT_SECRET_REF, ConfigPropertyManager
                       .getConfigProperty(ConfigPropertyKeys.SPOTIFY_CLIENT_SECRET));
               break;
            case DONUTS:
               break;

        }
        return credentialsMap;
    }

    private static String getAppGrantType(Apps appName){
        String grantType="";
        if (Objects.requireNonNull(appName) == Apps.SPOTIFY) {
            grantType = "refresh_token";
        }
        return grantType;
    }


}
