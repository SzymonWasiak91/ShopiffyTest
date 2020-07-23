package Tests;

import Helpers.DriverFactory;
import Helpers.DriverType;
import Helpers.Waits;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected ExtentReports reports;

    @BeforeTest
    public void setUpReporter() {
        this.reporter = new ExtentHtmlReporter("Shopfy.html");
        this.reports = new ExtentReports();
        reports.attachReporter(reporter);
    }


    @BeforeMethod
    public void setUP() throws IOException {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(DriverType.OPERA);


    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After test");
        driver.quit();
        DriverFactory.resetDriver();
    }
    @AfterTest
    public void tearDownReport(){
        reporter.flush();
        reports.flush();
    }
    MediaEntityModelProvider getScreenShot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(Waits.takeScreeanShot(driver)).build();
    }
}
