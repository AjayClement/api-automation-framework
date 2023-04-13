package com.ttt.enums;

public enum Apps {

    SPOTIFY("spotify","https://api.spotify.com"),
    DONUTS("donuts","http://localhost:3000");

    private final String appName;
    private final String baseUrl;
    Apps(String appName, String baseUrl){
        this.appName = appName;
        this.baseUrl = baseUrl;
    }

    public String getAppName(){
        return appName;
    }
    public String getBaseUrl(){
        return baseUrl;
    }

    public Apps[] getApps(){
        return Apps.values();
    }

}
