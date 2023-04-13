package com.ttt.apiutils;

import com.ttt.datamanager.ConfigPropertyManager;
import com.ttt.enums.Apps;
import com.ttt.enums.ConfigPropertyKeys;
import org.testng.asserts.SoftAssert;

public class ApiTestContext {

    private final ApiAppManager apiAppManager;
    private final ResponseStore responseStore;
    private final SoftAssert softAssert;

    public ApiTestContext() {
        Apps appUnderTest = Apps.valueOf(ConfigPropertyManager.getConfigProperty(
                ConfigPropertyKeys.APP_UNDER_TEST).toUpperCase());
        String baseAppUrl = appUnderTest.getBaseUrl();
        apiAppManager = new ApiAppManager(appUnderTest, baseAppUrl);
        responseStore = new ResponseStore();
        softAssert = new SoftAssert();
    }

    public ApiAppManager getApiAppManager() {
        return apiAppManager;
    }

    public ResponseStore getResponseStore() {
        return responseStore;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }
}
