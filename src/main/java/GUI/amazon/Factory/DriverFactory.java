package GUI.amazon.Factory;

import GUI.amazon.Utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static GUI.amazon.Base.PageBase.getDriver;
import static GUI.amazon.Base.PageBase.setDriver;


@Slf4j
public class DriverFactory {
    public void initializeDriver() {
        String browser = System.getProperty("browser", "chrome").toUpperCase();
        log.info("Initializing WebDriver for browser: " + browser);

        switch (browser) {
            case "EDGE" -> {
                setDriver(new EdgeDriver());
            }
            case "CHROME" -> {
                setDriver(new ChromeDriver());
            }
            case "FIREFOX" -> {
                setDriver(new FirefoxDriver());
            }
            default -> throw new RuntimeException("Browser isn't supported: " + browser);
        }

        if (getDriver() == null) {
            throw new IllegalStateException("WebDriver initialization failed!");
        }

        getDriver().get(ConfigUtils.getInstance().getBaseUrl());
        getDriver().manage().window().maximize();
        log.info("WebDriver initialized successfully!");
    }
}
