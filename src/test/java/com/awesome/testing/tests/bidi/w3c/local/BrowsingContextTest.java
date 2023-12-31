package com.awesome.testing.tests.bidi.w3c.local;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.bidi.browsingcontext.NavigationResult;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowsingContextTest extends LocalFirefoxTest {

    public static final String EXAMPLE_PAGE = "https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html";

    @Test
    void testCreateAWindow() {
        // when
        BrowsingContext browsingContext = new BrowsingContext(driver, WindowType.WINDOW);
        NavigationResult info = browsingContext.navigate(EXAMPLE_PAGE);

        // then
        assertThat(browsingContext.getId()).isNotNull();
        assertThat(browsingContext.getTopLevelContexts()).hasSize(2);
        assertThat(driver.getWindowHandles()).hasSize(2);
        assertThat(info.getUrl()).contains("bidi");
    }

    @Test
    void testCreateATab() {
        // when
        BrowsingContext browsingContext = new BrowsingContext(driver, WindowType.TAB);
        NavigationResult info = browsingContext.navigate(EXAMPLE_PAGE);

        // then
        assertThat(browsingContext.getId()).isNotNull();
        assertThat(browsingContext.getTopLevelContexts()).hasSize(2);
        assertThat(driver.getWindowHandles()).hasSize(2);
        assertThat(info.getUrl()).contains("bidi");
    }

}
