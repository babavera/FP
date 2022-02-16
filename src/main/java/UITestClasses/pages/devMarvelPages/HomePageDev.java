package UITestClasses.pages.devMarvelPages;

import UITestClasses.pages.marvelPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageDev {

    private final static By INTERACTIVE_DOCUMENTATION = By.xpath("//a[text()='Interactive Documentation']");
    private final static By SIGN_IN = By.xpath("//div//a[contains(text(),'Sign In')]");
    private final static By  VIDEO = By.xpath("//a[@id='mvl-flyout-button-0' and text()='Videos']/..");
    private final static By  GET_STARTED = By.xpath("//a[@class='cta-btn cta-btn--red cta-btn--solid']");
    private final static By  DEVELOPER_PORTAL = By.xpath("//li/a[text()='Developer Portal']");

    public final WebDriver driver;

    public HomePageDev(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnSignIn(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(SIGN_IN)).click();
        return new LoginPage(driver);
    }

    public IDocumentationPage clickOnInteractiveDocumentation(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(INTERACTIVE_DOCUMENTATION)).click();
        return new IDocumentationPage(driver);
    }
    public WebElement findeGetStarted(){
        return driver.findElement(GET_STARTED);
    }
    public WebElement findeVideo(){
        return driver.findElement(VIDEO);
    }
    public WebElement findeDeveloperPortal(){
        return driver.findElement(DEVELOPER_PORTAL);
    }

}
