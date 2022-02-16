package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DigitalStorePage extends HomePage{

    private final static By GOOGLE_PLAY = By.xpath("//img[@data-entity-uuid='e8a815e6-3935-41b0-8921-cc9248b878e5']");
    private final static By APP_STORE = By.xpath("//img[@data-entity-uuid='b7cc693b-ee9a-4597-9a44-0cbe4a084651']");

    public DigitalStorePage(WebDriver driver) {
        super(driver);
    }

    public AppstorePage clickOnAppStore(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(APP_STORE)).click();
        return new AppstorePage(driver);
    }
    public GooglePlayPage clickOnGooglePlay(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(GOOGLE_PLAY)).click();
        return new GooglePlayPage(driver);
    }

}
