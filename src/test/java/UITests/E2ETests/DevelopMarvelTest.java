package UITests.E2ETests;

import UITestClasses.pages.devMarvelPages.HomePageDev;
import UITestClasses.pages.devMarvelPages.LoginPage;
import UITestClasses.pages.devMarvelPages.MyDeveloperPortalPage;
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
        Assertions.assertEquals("SERHEY", homePageDev.getUserName());
        MyDeveloperPortalPage myDeveloperPortalPage = homePageDev.clickOnMyDevPortal();
        Assertions.assertEquals("Serhey74312470", myDeveloperPortalPage.getUserInformation());
        Assertions.assertEquals("07b0d846cafe9b5b9b8a341ee25876fa", myDeveloperPortalPage.getUserPublicKey());
    }
}
