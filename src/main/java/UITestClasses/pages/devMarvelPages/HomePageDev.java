package UITestClasses.pages.devMarvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageDev {

    private final static By SIGN_IN = By.xpath("//div//a[contains(text(),'Sign In')]");
    private final static By VIDEO = By.xpath("//a[@id='mvl-flyout-button-0' and text()='Videos']/..");
    private final static By GET_STARTED = By.xpath("//a[@class='cta-btn cta-btn--red cta-btn--solid']");
    private final static By DEVELOPER_PORTAL = By.xpath("//li/a[text()='Developer Portal']");
    private final static By USER_NAME = By.xpath("//div[@class='user-menu__links'][span[contains(text(),'Serhey')]]");
    private final static By MY_DEVELOPER_PORTAL = By.xpath("//li[a[contains(text(),'My Developer Account')]]");
    private final static By GET_A_KEY = By.xpath("//a[@id='logout']");
    private final static By LOG_OUT = By.xpath("//a[@id='logout']");
    private final static By HERE = By.xpath("//a[@href='https://developer.marvel.com/account']");

    public final WebDriver driver;

    public HomePageDev(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnSignIn() {
        driver.findElement(SIGN_IN).click();
        return new LoginPage(driver);
    }

    public WebElement findeGetStarted() {
        return driver.findElement(GET_STARTED);
    }

    public WebElement findeVideo() {
        return driver.findElement(VIDEO);
    }

    public WebElement findeDeveloperPortal() {
        return driver.findElement(DEVELOPER_PORTAL);
    }

    public String getUserName() {
        return driver.findElement(USER_NAME).getText();
    }

    public MyDeveloperPortalPage clickOnMyDevPortal() {
        if (driver.findElement(MY_DEVELOPER_PORTAL).isDisplayed()) {
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.elementToBeClickable(MY_DEVELOPER_PORTAL)).click();
            return new MyDeveloperPortalPage(driver);
        }
        if (driver.findElement(GET_A_KEY).isDisplayed()) {
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.elementToBeClickable(GET_A_KEY)).click();
            return new MyDeveloperPortalPage(driver);
        } else {
            driver.findElement(HERE).click();
            return new MyDeveloperPortalPage(driver);
        }
    }

    public void clickOnLogOut() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(LOG_OUT)).click();
    }
}