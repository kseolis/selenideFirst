package pages;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;

public class chromeSettings implements WebDriverProvider {
    private static final ChromeOptions CHROME_OPTIONS = new ChromeOptions();

    @SuppressWarnings("deprecation")
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        WebDriverManager.chromedriver().setup();
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        try {
            return new ChromeDriver(capabilities);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChromeDriver error: " + e.getMessage());
            throw e;
        }
    }
    public static ChromeOptions getChromeOptions() {
        CHROME_OPTIONS.addArguments("disable-infobars");
        CHROME_OPTIONS.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        CHROME_OPTIONS.setExperimentalOption("useAutomationExtension", false);
        CHROME_OPTIONS.addArguments("--start-maximized");
        CHROME_OPTIONS.addArguments("--disable-gpu");
        CHROME_OPTIONS.addArguments("--disable-extensions");
        CHROME_OPTIONS.addArguments("--no-sandbox");
        CHROME_OPTIONS.addArguments("--disable-dev-shm-usage");
        CHROME_OPTIONS.addArguments("--allow-file-access-from-files");
        CHROME_OPTIONS.addArguments("--incognito");
        CHROME_OPTIONS.addArguments("--use-fake-ui-for-media-stream");
        CHROME_OPTIONS.addArguments("--use-fake-device-for-media-stream");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--disable-popup-blocking", "true");
        return CHROME_OPTIONS;
    }
}
