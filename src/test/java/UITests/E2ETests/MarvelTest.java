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
        homePage.switchToWindow(1);
        String appUrl = "https://apps.apple.com/us/app/marvel-comics/id350027738";
        Assertions.assertEquals(appUrl,appstorePage.getUrl());
        System.out.println();

        appstorePage.switchToWindow(0);
        GooglePlayPage googlePlayPage = digitalStorePage.clickOnGooglePlay();
        homePage.switchToWindow(2);
        String googlePlayUrl = "https://play.google.com/store/apps/details?id=com.marvel.comics&hl=en_US";
        Assertions.assertEquals(googlePlayUrl, googlePlayPage.getUrl());



    }
}
