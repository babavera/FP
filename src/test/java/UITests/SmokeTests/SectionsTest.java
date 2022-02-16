package UITests.SmokeTests;

import UITestClasses.pages.devMarvelPages.HomePageDev;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SectionsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://developer.marvel.com///");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }


    @Test
    public void testCatalog1OnHomePege (){
      HomePageDev homePage = new HomePageDev(driver);
      Assertions.assertAll(
              () -> Assertions.assertTrue(homePage.findeGetStarted().isEnabled()),
              () -> Assertions.assertTrue(homePage.findeGetStarted().isDisplayed()),
              () -> Assertions.assertTrue(homePage.findeVideo().isEnabled()),
              () -> Assertions.assertTrue(homePage.findeVideo().isDisplayed()),
              () -> Assertions.assertTrue(homePage.findeDeveloperPortal().isEnabled()),
              () -> Assertions.assertTrue(homePage.findeDeveloperPortal().isDisplayed())
      );
    }


}
