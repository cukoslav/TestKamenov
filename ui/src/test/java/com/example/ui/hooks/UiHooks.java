package com.example.ui.hooks;

import com.example.ui.drivers.PlaywrightPageProvider;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class UiHooks {

    public Page page;

    @Value("${ui.baseUrl}")
    private String baseUrl;

    private final PlaywrightPageProvider pageProvider;

    @Before(value = "@ui", order = 1)
    public void preparePlaywrightInstance() {
        page = pageProvider.getPage();
        page.navigate(baseUrl);
        page.waitForLoadState();
    }

    @After(value = "@ui")
    public void closeBrowser() {
        pageProvider.closeBrowser();
    }
}