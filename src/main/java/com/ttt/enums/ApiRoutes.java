package com.ttt.enums;

public enum ApiRoutes {

    DONUT_ITEMS("/items"),
    SPOTIFY_NEW_RELEASES("/v1/browse/new-releases"),
    SPOTIFY_TOKEN("/api/token");

    private final String route;

    private ApiRoutes(String route){
        this.route = route;
    }

    public String getRoute(){
        return route;
    }


}
