package UITestClasses.pages.devMarvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyDeveloperPortalPage extends HomePageDev{

    private final static By USER_ID = By.xpath("//span[text()='Serhey74312470']");
    private final static By API_KEY = By.xpath("//div[@class='apikey'][1]");
    private final static By LOG_OUT = By.xpath("//a[@id='logout']");


    public MyDeveloperPortalPage(WebDriver driver) {
        super(driver);
    }

    public String getUserInformation() {
        return driver.findElement(USER_ID).getText();
    }
    public String getUserPublicKey() {
        return driver.findElement(API_KEY).getText();
    }
    public void clickOnLogOut() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(LOG_OUT)).click();
    }
}
