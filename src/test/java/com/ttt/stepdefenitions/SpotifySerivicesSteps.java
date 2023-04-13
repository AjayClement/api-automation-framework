package com.ttt.stepdefenitions;

import com.ttt.apiutils.ApiTestContext;
import com.ttt.apiutils.ResponseStore;
import com.ttt.services.SpotifyService;
import org.testng.asserts.SoftAssert;

public class SpotifySerivicesSteps {

    private final ApiTestContext apiTestContext;
    private final SpotifyService spotifyService;
    private final SoftAssert softAssert;

    public SpotifySerivicesSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        spotifyService = new SpotifyService(apiTestContext);
        softAssert = new SoftAssert();
    }
}
