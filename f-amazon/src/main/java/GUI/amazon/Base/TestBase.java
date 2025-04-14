package GUI.amazon.Base;

import GUI.amazon.Factory.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;

import static GUI.amazon.Base.PageBase.getDriver;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            String testCasesName = result.getMethod().getMethodName();
            File destinationFile = new File("target" + File.separator + "screenShots" + File.separator + testCasesName + ".png");
            takeScreenshot(destinationFile);
            InputStream inputStream = new FileInputStream(destinationFile);
            Allure.addAttachment("screenshot", inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        getDriver().quit();
    }

    public void takeScreenshot(File destinationFile) {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
