package com.ttt.services;

import com.ttt.apiutils.ApiTestContext;

public class DonutsService {

    private final ApiTestContext apiTestContext;
    private final String appName;
    private final String baseUrl;
    public DonutsService(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        appName = apiTestContext.getApiAppManager().getCurrentAppSerivice();
        baseUrl = apiTestContext.getApiAppManager().getAppBaseUri();
    }
}
