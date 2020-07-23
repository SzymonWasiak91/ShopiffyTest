package Tests;

import Helpers.Waits;
import Pages.Page_1;
import Pages.Page_ContactUs;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Listeners(Helpers.Listeners.class)

public class ShopifyTest extends BaseTest {


    @Test
    public void test_ID1_checkElements() throws AWTException, IOException {
        ExtentTest test = reports.createTest("Check elements on main page");
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        test.info("On mane page", getScreenShot());

        test.info("Check lower list");
        List<String> checkLowerCategoriesList = page_1.checkLowerCategoriesList();
        Assert.assertEquals("Accessories1", checkLowerCategoriesList.get(0));
        Assert.assertEquals("Denim", checkLowerCategoriesList.get(1));
        Assert.assertEquals("Footwear", checkLowerCategoriesList.get(2));
        Assert.assertEquals("Outerwear", checkLowerCategoriesList.get(3));
        Assert.assertEquals("Pants", checkLowerCategoriesList.get(4));
        Assert.assertEquals("Shirts", checkLowerCategoriesList.get(5));
        Assert.assertEquals("T-Shirts", checkLowerCategoriesList.get(6));
        test.info("Check higher list", getScreenShot());
        List<String> checkHigherCategoriesList = page_1.checkHigherCategoriesList();
        Assert.assertEquals("Stealth Bomber Jacket - Fatigue", checkHigherCategoriesList.get(0));
        Assert.assertEquals("Wolfpack Jacket - Black", checkHigherCategoriesList.get(1));
        Assert.assertEquals("Storm Jacket - Olive", checkHigherCategoriesList.get(2));
        Assert.assertEquals("Operator Denim Jacket - Black", checkHigherCategoriesList.get(3));
        Assert.assertEquals("Navigator Parka Jacket - Black", checkHigherCategoriesList.get(4));
        Assert.assertEquals("Gulf Jacket - Olive", checkHigherCategoriesList.get(5));
        Assert.assertEquals("Compound Denim Pullover Jacket - Acid Wash", checkHigherCategoriesList.get(6));
        Assert.assertEquals("Arrow Shacket - Olive", checkHigherCategoriesList.get(7));
        Assert.assertEquals("Arrow Shacket - Indigo", checkHigherCategoriesList.get(8));
        test.info("Check left menu", getScreenShot());
        List<String> getLeftMenu = page_1.getLeftMenu();
        Assert.assertEquals("Home", getLeftMenu.get(0));
        Assert.assertEquals("Accessories", getLeftMenu.get(1));
        Assert.assertEquals("Denim", getLeftMenu.get(2));
        Assert.assertEquals("Footwear", getLeftMenu.get(3));
        Assert.assertEquals("Jeans", getLeftMenu.get(4));
        Assert.assertEquals("Outerwear", getLeftMenu.get(5));
        Assert.assertEquals("Pants", getLeftMenu.get(6));
        Assert.assertEquals("Shirts", getLeftMenu.get(7));
        Assert.assertEquals("T-Shirts", getLeftMenu.get(8));
        Assert.assertEquals("Shorts", getLeftMenu.get(9));
        test.info("Check social media connections", getScreenShot());
        page_1.checkSocialMediaFirstPage();
        String excheckFirstHeading = page_1.excheckFirstHeading();
        Assert.assertEquals("Featured collection", excheckFirstHeading);
        String checkSecendHeading = page_1.checkSecendHeading();
        Assert.assertEquals("Allow your style to match your ambition!", checkSecendHeading);
        test.info("Czy sie udał", getScreenShot());
        test.getStatus();
        page_1.checkSimpleLogo();

    }

    @Test
    public void test_ID2_sendMessageWithWrongEmail() throws AWTException, IOException {
        ExtentTest test = reports.createTest("Send wrong message test");
        //driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        test.info("Scroll down on page", MediaEntityBuilder.createScreenCaptureFromPath(Waits.takeScreeanShot(driver)).build());
        page_1.pressButtonDown();
        page_1.pressButtonDown();
        page_1.pressButtonDown();
        test.info("Click button contact us");
        page_1.clickContacUsButton();
        Page_ContactUs page_contactUs = new Page_ContactUs(driver);
        test.info("Send message witch wrong email", getScreenShot());

        page_contactUs.checkAndFillFormulage("Szymon", ",,,///;;;''''[[[]]]",
                "Litwo, Ojczyzno moja! ty jesteś jak zdrowie;\n" +
                        "Ile cię trzeba cenić, ten tylko się dowie,\n" +
                        "Kto cię stracił. Dziś piękność twą w całej ozdobie\n" +
                        "Widzę i opisuję, bo tęsknię po tobie.", "723511077");
    }

    @Test
    public void test_ID3_checkFbButton() throws AWTException {
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        String title1 = page_1.getHomePageTitle();
        Assert.assertEquals("Simple ecommerce theme demo store – Shopify Shirts", title1);
        page_1.clickFbButton();
        String title2 = page_1.checkFbTitle();
        Assert.assertEquals("Shopify - Strona główna | Facebook", title2);
    }

    @Test
    public void test_ID4_checkTwitterButton() throws AWTException {
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        String title1 = page_1.getHomePageTitle();
        Assert.assertEquals("Simple ecommerce theme demo store – Shopify Shirts", title1);
        page_1.clckTwitterButton();
        String title2 = page_1.checkTwitterTittle();
        Assert.assertEquals("Stay Home (@Shopify) / Twitter", title2);
    }

    @Test
    public void test_ID5_checkPinterestButton() throws AWTException, IOException {
        ExtentTest test = reports.createTest("TEst pinterest ");
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        String title1 = page_1.getHomePageTitle();
        test.info("coskskdksdks", getScreenShot());
        Assert.assertEquals("Simple ecommerce theme demo store – Shopify Shirts", title1);
        page_1.clckPinterestButton();
        String title2 = page_1.checkPinterestTittle();
        Assert.assertEquals("Shopify (shopify) na Pintereście1", title2);
    }

    @Test
    public void test_ID6_checkInstagramtButton() throws AWTException {
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        String title1 = page_1.getHomePageTitle();
        Assert.assertEquals("Simple ecommerce theme demo store – Shopify Shirts", title1);
        page_1.clckInstagramButton();
        String title2 = page_1.checkInstagramTittle();
        Assert.assertEquals("Shopify (@shopify) • Zdjęcia i filmy na Instagramie", title2);
    }

    @Test
    public void test_ID7_checkSnapchatButton() throws AWTException {
        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        String title1 = page_1.getHomePageTitle();
        Assert.assertEquals("Simple ecommerce theme demo store – Shopify Shirts", title1);
        page_1.clckSmapchatButton();
        String title2 = page_1.checkSnapchatTittle();
        Assert.assertEquals("Snapchat", title2);
    }

    @Test
    public void test_ID8_sendMessageCorrectly() throws AWTException {

        driver.get("https://simpletheme.myshopify.com");
        Page_1 page_1 = new Page_1(driver);
        page_1.pressButtonDown();
        page_1.pressButtonDown();
        page_1.pressButtonDown();
        page_1.clickContacUsButton();
        Page_ContactUs page_contactUs = new Page_ContactUs(driver);
        page_contactUs.checkAndFillFormulage("Szymon", "szymon@wp.pl",
                "Litwo, Ojczyzno moja! ty jesteś jak zdrowie;\n" +
                        "Ile cię trzeba cenić, ten tylko się dowie,\n" +
                        "Kto cię stracił. Dziś piękność twą w całej ozdobie\n" +
                        "Widzę i opisuję, bo tęsknię po tobie.", "723511077");
        page_1.pressButtonUP();
        page_1.pressButtonUP();
        page_1.pressButtonUP();
        page_1.pressButtonUP();
        //page_1.checkCheckBox();
    }
}

