package com.ttt.services;


import com.ttt.apimodels.spotify.Albums;
import com.ttt.apiutils.*;
import com.ttt.apiutils.RestTokenUtil;
import com.ttt.enums.ApiRoutes;
import com.ttt.enums.Apps;
import com.ttt.enums.RequestType;
import com.ttt.enums.ResponseContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public final class SpotifyService {

    private final ResponseStore responseStore;
    private final String appName;
    private final String baseUrl;

    private static final Map<String,String> headers =  new HashMap<>();

    static {
        headers.put("Content-Type", ContentType.JSON.toString());
    }

    public SpotifyService(ApiTestContext apiTestContext){
        appName = apiTestContext.getApiAppManager().getCurrentAppSerivice();
        baseUrl = apiTestContext.getApiAppManager().getAppBaseUri();
        responseStore = apiTestContext.getResponseStore();
    }
    public void getSpotifyNewReleaseItemsList(String country, int limit, int offset){
        String accessToken = RestTokenUtil.getAccessToken(Apps.SPOTIFY, ApiRoutes.SPOTIFY_TOKEN);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("country",country);
        queryParams.put("limit",limit);
        queryParams.put("offset",offset);
        Response response = RestRequestUtil.doHttpRequestWithNoBodyWithOAuth2(RequestType.GET,accessToken,headers,
                                  ApiRoutes.SPOTIFY_NEW_RELEASES,queryParams,Apps.SPOTIFY);
        Albums albums = RestResponseUtil.getResposeBody(Albums.class, response);
        responseStore.setResponseContext(ResponseContext.SPOTIFY_RESPONSE,albums);
    }
    public boolean checkSpotifyListNotEmpty(){
        return !responseStore.getResponseList(ResponseContext.SPOTIFY_RESPONSE).isEmpty();
    }




}
