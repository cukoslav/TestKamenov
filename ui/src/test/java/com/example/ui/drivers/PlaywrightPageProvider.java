package com.example.ui.drivers;

import com.microsoft.playwright.*;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class PlaywrightPageProvider {

    @Value("${ui.headless}")
    private boolean isHeadless;

    @Value(("${ui.timeout.default}"))
    private int defaultTimeout;

    private Page page;
    private Browser browser;
    private Playwright playwright;

    public Page getPage() {
        if (page == null) {
            initBrowser();
        }
        return page;
    }

    private void initBrowser() {
        playwright = Playwright.create();
        playwright.selectors().setTestIdAttribute("data-test");
        browser = launchBrowser(playwright);
        page = browser.newPage();
    }

    private Browser launchBrowser(Playwright playwright) {
        return playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(isHeadless)
                        .setTimeout(defaultTimeout)
        );
    }

    public void closeBrowser() {
        if (page != null) {
            page.close();
            page = null;
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}