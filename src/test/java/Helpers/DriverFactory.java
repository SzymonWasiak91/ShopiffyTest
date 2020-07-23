package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;

import java.io.File;
import java.io.IOException;

public class DriverFactory {
    public static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws IOException {
        if(driverInstance == null){
            getSpecificDriver(driverType);
            driverInstance.manage().window().maximize();
        }

        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws IOException {
        switch (driverType){
            case OPERA:
                File operaFile = new File("src/main/resources/drivers/operadriver.exe");
                OperaDriverService operaDriverService = new OperaDriverService.Builder()
                        .usingDriverExecutable(operaFile)
                        .usingAnyFreePort().build();
                driverInstance = new OperaDriver(operaDriverService);

            break;
            case CHROME:
                File chromeFile = new File("src/main/resources/drivers/chromedriver.exe");
                ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeFile)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeDriverService);
            break;
            default:
                System.out.println("Not have drivers with prefer type");

        }

    }
    public static void resetDriver(){
        driverInstance = null;
    }

}
