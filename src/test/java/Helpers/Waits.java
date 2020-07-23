package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;

public class Waits {
private WebDriver driver;

public Waits(WebDriver driver){
    this.driver = driver;
}

    public  void Explicitwait(WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L );
        wait.until(ExpectedConditions.visibilityOf(element));
        }

     public void FluentWait(WebElement element){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15));
        fluentWait.pollingEvery(Duration.ofMillis(500));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.ignoring(NullPointerException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));

     } public void listFluentWait(List<WebElement> listWebElement){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15));
        fluentWait.pollingEvery(Duration.ofMillis(500));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(driver1 -> listWebElement.size()>0);

     }
    public static String takeScreeanShot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screneShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/main/resources/screanShot" + LocalTime.now().getNano() + ".png");
        Files.copy(screneShotFile.toPath(),destinationFile.toPath());
        return destinationFile.getAbsolutePath();
    }











}



