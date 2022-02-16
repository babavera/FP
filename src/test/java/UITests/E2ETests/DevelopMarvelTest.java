package UITests.E2ETests;

import UITestClasses.pages.devMarvelPages.HomePageDev;
import UITestClasses.pages.devMarvelPages.IDocumentationPage;
import UITestClasses.pages.marvelPages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class DevelopMarvelTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://developer.marvel.com//");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testDeveloperMarvelComSite() throws InterruptedException {
        HomePageDev homePageDev = new HomePageDev(driver);
        LoginPage loginPage = homePageDev.clickOnSignIn();
        loginPage.doLogin();
        Thread.sleep(15000);
        IDocumentationPage iDocumentationPage = homePageDev.clickOnInteractiveDocumentation();
        iDocumentationPage.clickOnV1PublicCharacters();
        iDocumentationPage.sendNameOfHero();
        iDocumentationPage.clickOnTryButton();
        Thread.sleep(15000);
        Assertions.assertEquals("200", iDocumentationPage.getResponseCode());
        iDocumentationPage.clickOnSignIn();
        iDocumentationPage.clickOnLogOut();
    }
}
