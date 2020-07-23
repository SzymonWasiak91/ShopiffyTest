package Pages;

import Helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_ContactUs {
    @FindBy(xpath = "//input[@name='contact[name]']")
    private WebElement inputNameContactUs;
    @FindBy(id= "ContactFormEmail")
    private WebElement inpuEmailContactUs;
    @FindBy(id="ContactFormPhone")
    private  WebElement inputPhoneNumber;
    @FindBy(id="ContactFormMessage")
    private  WebElement inputMessage;
    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendButton;

   private Waits waits;
   private WebDriver driver;

    public Page_ContactUs(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.waits = new Waits(driver);
    }
    public void checkAndFillFormulage(String name, String email, String message, String phoneNumber){
        waits.FluentWait(inputNameContactUs);
        inputNameContactUs.click();
        inputNameContactUs.sendKeys(name);
        inpuEmailContactUs.click();
        inpuEmailContactUs.sendKeys(email);
        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys(phoneNumber);
        inputMessage.click();
        inputMessage.sendKeys(message);
        waits.FluentWait(sendButton);
        sendButton.click();

    }










}
