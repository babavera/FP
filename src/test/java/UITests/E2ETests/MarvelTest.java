package UITests.E2ETests;


import UITestClasses.pages.marvelPages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MarvelTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://marvel.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCatalogSection() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.clickOnElementSearch();;
        searchPage.sendKeyAndPressEnter();
        searchPage.clickOnComicsChapter();
        BuyPage buyPage = searchPage.clickOnComics();;
        DigitalStorePage digitalStorePage = buyPage.clickOnBuyDigitalIssue();
        AppstorePage appstorePage = digitalStorePage.clickOnAppStore();
        Assertions.assertTrue(appstorePage.getTitle().contains("App"));

        GooglePlayPage googlePlayPage = digitalStorePage.clickOnGooglePlay();
        Assertions.assertTrue(googlePlayPage.getTitle().contains("Google"));

        //String windowHandler = driver.getWindowHandle();

        /*String pageTitle = driver.findElement(TITLE).getText();
        driver.switchTo().window(windowHandler);*/


    }
}
