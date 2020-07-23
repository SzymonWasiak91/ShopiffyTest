package Pages;

import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Page_1 {
    @FindBy(xpath = "//div[@class=\'collection-grid-item\']")
    private List<WebElement> lowerCategoriesList;
    @FindBy(xpath = "//div[@class='product__title text-center']")
    private List<WebElement> higherCategoriesList;
    @FindBy(xpath = "//a[@class='site-nav__link']")
    private List<WebElement> leftMenuList;
    @FindBy(xpath = "//span[text()='Facebook']")
    private WebElement fbIcon;
    @FindBy(xpath = "//span[text()='Twitter']")
    private WebElement twitterIcon;
    @FindBy(xpath = "//span[text()='Pinterest']")
    private WebElement pinterestIcon;
    @FindBy(xpath = "//span[text()='Instagram']")
    private WebElement instagramIcon;
    @FindBy(xpath = "//span[text()='Snapchat']")
    private WebElement snapchatIcon;
    @FindBy(xpath = "//span[text()='Vimeo']")
    private WebElement vimeoIcon;
    @FindBy(xpath = "//h2[text()='Featured collection']")
    private WebElement firstHeadin;
    @FindBy(xpath = "//h2[text()='Allow your style to match your ambition!']")
    private WebElement secendHeading;
    @FindBy(id = "HeaderLogo")
    private WebElement simpleLogo;
    @FindBy(xpath = "//a[text()='Contact us']")
    private WebElement contactUsButton;
    @FindBy(xpath = "//a[@title='Shopify Shirts on Facebook']")
    private WebElement facebookButton;
    @FindBy(xpath = "//i[@class='fb_logo img sp_Vgu5hh_52BR sx_445ecd']")
    private WebElement fbBanre;
    @FindBy(xpath = "//a[@title='Shopify Shirts on Twitter']")
    private WebElement twitterButton;
    @FindBy(xpath = "//a[@title='Shopify Shirts on Pinterest']")
    private WebElement pinterestButton;
    @FindBy(xpath = "//a[@title='Shopify Shirts on Instagram']")
    private WebElement instagramButton;
    @FindBy(xpath = "//a[@title='Shopify Shirts on Snapchat']")
    private WebElement snapchatButton;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement chexkBoxNotRobot;
    @FindBy(xpath = "//a[@class='css-4rbku5 css-18t94o4 css-1dbjc4n r-1niwhzg r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1loqt21 r-1w2pmg r-1vuscfd r-53xb7h r-mk0yit r-o7ynqc r-6416eg r-lrvibr']")
    private WebElement twitterElement;


    private Robot robot;
    private Waits waits;
    private WebDriver driver;

    public Page_1(WebDriver driver) throws AWTException {
        PageFactory.initElements(driver, this);
        this.waits = new Waits(driver);
        this.driver = driver;
        this.robot = new Robot();

    }

    public List<String> checkLowerCategoriesList() {
        System.out.println("#########################################################################################");
        waits.listFluentWait(lowerCategoriesList);
        System.out.println("Liczba elementów dolnych kategorii =  " + lowerCategoriesList.size());
        List<String> checkLowerCategoriesString = new ArrayList<>();
        for (WebElement element1 : lowerCategoriesList) {
            System.out.println(element1.getText());
            checkLowerCategoriesString.add(element1.getText());
        }
        return checkLowerCategoriesString;
    }

    public List<String> checkHigherCategoriesList() {
        System.out.println("#########################################################################################");
        waits.listFluentWait(higherCategoriesList);
        System.out.println("Liczba elementów w dziale górnych kategorii = " + higherCategoriesList.size());
        List<String> checkHigherListString = new ArrayList<>();
        for (WebElement element2 : higherCategoriesList) {
            System.out.println(element2.getText());
            checkHigherListString.add(element2.getText());

        }
        return checkHigherListString;
    }

    public List<String> getLeftMenu() {
        System.out.println("#####################################################################################");
        System.out.println("Liczba elementów bocznego menu =  " + leftMenuList.size());
        waits.listFluentWait(leftMenuList);
        List<String> leftMenuString = new ArrayList<>();
        for (WebElement element3 : leftMenuList) {
            System.out.println(element3.getText());
            leftMenuString.add(element3.getText());
        }
        return leftMenuString;
    }

    public void checkSocialMediaFirstPage() {
        System.out.println("#####################################################################################");
        waits.Explicitwait(fbIcon);
        System.out.println("Czy button FB jest widoczny = " + fbIcon.isEnabled());
        waits.Explicitwait(twitterIcon);
        System.out.println("Czy button Twitter jest widoczny = " + twitterIcon.isEnabled());
        waits.Explicitwait(pinterestIcon);
        System.out.println("Czy button Pinterest jest widoczny = " + pinterestIcon.isEnabled());
        waits.Explicitwait(instagramIcon);
        System.out.println("Czy button Instagram jest widoczny = " + instagramIcon.isEnabled());
        waits.Explicitwait(snapchatIcon);
        System.out.println("Czy button Snapchat jest widoczny = " + snapchatIcon.isEnabled());
        waits.Explicitwait(vimeoIcon);
        System.out.println("Czy button Vimeo jest widoczny = " + vimeoIcon.isEnabled());
    }

    public String excheckFirstHeading() {
        System.out.println("#####################################################################################");
        System.out.println("Sprawdzenie 1 nagłówka");
        waits.FluentWait(firstHeadin);
        String expectedFirstHeadlig = firstHeadin.getText();
        System.out.println(firstHeadin.getText());
        return expectedFirstHeadlig;

    }

    public String checkSecendHeading() {
        System.out.println("#####################################################################################");
        System.out.println("Sprawdzenie 2 nagłówka");
        waits.Explicitwait(secendHeading);
        System.out.println(secendHeading.getText());
        String nemeOfSecendHeading = secendHeading.getText();
        return nemeOfSecendHeading;
    }

    public void checkSimpleLogo() {
        waits.Explicitwait(simpleLogo);
        System.out.println("#####################################################################################");
        System.out.println("Sprawdzenie wyświetlenia logo Simple = " + simpleLogo.isEnabled());
    }

    public void pressButtonDown() {
        waits.Explicitwait(simpleLogo);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    }
    public void pressButtonUP() {
        robot.keyPress(KeyEvent.VK_PAGE_UP);
    }

    public void clickContacUsButton() {
        waits.FluentWait(contactUsButton);
        contactUsButton.click();
    }

    public String getHomePageTitle() {
        System.out.println("#########################################################################################");
        waits.FluentWait(simpleLogo);
        System.out.println(driver.getTitle());
        String homePageTitle = driver.getTitle();
        return homePageTitle;
    }

    public void clickFbButton() {
        facebookButton.click();

    }
    public String checkFbTitle(){
        System.out.println("Sprawdzenie poprawności tytułów na stronie głównej oraz FB ");
        System.out.println(driver.getTitle());
        String fbTitle = driver.getTitle();
        return fbTitle;
    }
    public void clckTwitterButton() {
        twitterButton.click();

    }
    public String checkTwitterTittle(){
        waits.Explicitwait(twitterElement);
        System.out.println("Sprawdzenie poprawności tytułów na stronie głównej oraz Twitter ");
        System.out.println(driver.getTitle());
        String twitterTitle = driver.getTitle();
        return twitterTitle;
    }
    public void clckPinterestButton() {
        pinterestButton.click();

    }
    public String checkPinterestTittle(){
        System.out.println("Sprawdzenie poprawności tytułów na stronie głównej oraz Pinterest ");
        System.out.println(driver.getTitle());
        String pinterestTitle = driver.getTitle();
        return pinterestTitle;
    }
    public void clckInstagramButton() {
        instagramButton.click();

    }
    public String checkInstagramTittle(){
        System.out.println("Sprawdzenie poprawności tytułów na stronie głównej oraz Instagram ");
        System.out.println(driver.getTitle());
        String instagramtTitle = driver.getTitle();
        return instagramtTitle;
    }
    public void clckSmapchatButton() {
        snapchatButton.click();

    }
    public String checkSnapchatTittle(){
        System.out.println("Sprawdzenie poprawności tytułów na stronie głównej oraz Snapchacie ");
        System.out.println(driver.getTitle());
        String snapchatTitle = driver.getTitle();
        return snapchatTitle;
    }
    public void checkCheckBox(){
       // waits.Explicitwait(chexkBoxNotRobot);
        chexkBoxNotRobot.click();
    }

}



