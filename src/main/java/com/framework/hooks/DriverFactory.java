package com.framework.hooks;

import com.framework.Logger.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    private static final Logger logger = Log.getLogger(DriverFactory.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void initializeDriver() {
        String browserName = System.getProperty("browser", "chrome").toLowerCase();
        String headless = System.getProperty("headless", "true").toLowerCase();

        WebDriver driverInstance = switch (browserName) {

            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                options.setAcceptInsecureCerts(true);

                // Required for new Chrome versions
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-features=OptimizationHints,PrefetchPrivacyChanges,OptimizationGuideModelDownloading");
                options.addArguments("--disable-background-networking");
                options.addArguments("--disable-renderer-backgrounding");

// Your exact profile (correct path)
                options.addArguments("user-data-dir=C:/Users/softsuave/AppData/Local/Google/Chrome/User Data");
                options.addArguments("profile-directory=Profile17_Auto");

// Window
                options.addArguments("--window-size=1920,1080");

// Must NOT use incognito/headless
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");

                yield new ChromeDriver(options);
            }

            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if ("true".equals(headless)) {
                    options.addArguments("--headless");
                }
                yield new FirefoxDriver(options);
            }

            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if ("true".equals(headless)) {
                    options.addArguments("--headless");
                }
                yield new EdgeDriver(options);
            }

            case "safari" -> new SafariDriver();

            default -> {
                throw new RuntimeException("Unsupported browser: " + browserName);
            }
        };

        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
