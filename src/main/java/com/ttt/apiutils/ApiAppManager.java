package com.ttt.apiutils;

import com.ttt.enums.Apps;
import com.ttt.enums.ConfigPropertyKeys;

public class ApiAppManager {
    private final Apps currentAppSerivice;
    private final String appBaseUri;
    protected ApiAppManager(Apps currentAppSerivice, String appBaseUri) {
        this.currentAppSerivice = currentAppSerivice;
        this.appBaseUri = appBaseUri;
    }
    public String getCurrentAppSerivice(){
        return currentAppSerivice.getAppName();
    }
    public String getAppBaseUri(){
        return appBaseUri;
    }

}
