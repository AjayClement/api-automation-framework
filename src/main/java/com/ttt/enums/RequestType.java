package com.ttt.enums;

public enum RequestType {

    GET(200),
    POST(201),
    PUT(204),
    PATCH(204),
    DELETE(204);

    int statusCode;
    RequestType(){

    }

    RequestType(int statusCode){
        this.statusCode =statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
