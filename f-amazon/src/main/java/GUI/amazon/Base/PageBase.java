package GUI.amazon.Base;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Setter
@Slf4j
public class PageBase {
    public static void setDriver(WebDriver driver) {
        PageBase.driver.set(driver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<FluentWait<WebDriver>> wait = new ThreadLocal<>();
    private static ThreadLocal<JavascriptExecutor> javascriptExecutor = new ThreadLocal<>();

    public PageBase(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null!");
        }
        setDriver(driver);

        wait.set(new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class));

        javascriptExecutor.set((JavascriptExecutor) driver);
    }


    public static FluentWait<WebDriver> getWait() {
        return wait.get();
    }


    public WebElement getElementByLocator(By locator) {
        return getDriver().findElement(locator);
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return javascriptExecutor.get();
    }

    public void jsClick(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].click();", element);
    }

    protected boolean clickElementFallbackToJsClick(WebElement elementToClick) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(elementToClick));
            elementToClick.click();
            return true;
        } catch (ElementClickInterceptedException e) {
            log.warn("Attempt : Element click was intercepted. Using JavaScript click. Exception: ", e);
            jsClick(elementToClick);
            return true;
        } catch (StaleElementReferenceException e) {
            log.warn("Attempt : Element became stale. Retrying. Exception: ", e);
        } catch (TimeoutException e) {
            log.warn("Attempt : Timeout waiting for element to be clickable. Exception: ", e);
        }
        return false;
    }

    protected void scrollAndClick(WebElement element) {
        try {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
            getWait().until(ExpectedConditions.visibilityOf(element));
            getWait().until(ExpectedConditions.elementToBeClickable(element));
            clickElementFallbackToJsClick(element);
        } catch (Exception ignored) {
        }
    }

    protected void scrollIntoView(WebElement element) {
        try {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
            getWait().until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ignored) {
        }
    }

    protected void scrollAndEnterText(WebElement element, String text) {
        try {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception ex) {
            log.info(ex.toString());
        }
    }

    protected void pressOnEsc() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    protected boolean isElementClickable(WebElement locator) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitForElementToBeVisible(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
