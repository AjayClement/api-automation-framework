package com.ttt.stepdefenitions;

import com.ttt.apiutils.ApiTestContext;
import com.ttt.services.DonutsService;

public class DonutsServicesSteps {

    private final ApiTestContext apiTestContext;
    private final DonutsService donutsService;
    public DonutsServicesSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        donutsService = new DonutsService(apiTestContext);
    }
}
