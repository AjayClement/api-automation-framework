package com.ttt.enums;

public enum ConfigPropertyKeys {

    SPOTIFY_CLIENT_ID("spotify.client.id"),
    SPOTIFY_CLIENT_SECRET("spotify.client.secret"),
    SPOTIFY_REFRESH_TOKEN("spotify.refresh.token"),
    ENVIRONMENT("environment"),
    APP_UNDER_TEST("app.under.test");

    private final String configPropertyKey;
    ConfigPropertyKeys(String configPropertyKey){
        this.configPropertyKey = configPropertyKey;
    }

    public String getConfigPropertyKey(){
        return configPropertyKey;
    }

}
