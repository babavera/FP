package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyPage extends HomePage
{
    private final static By BUY_DIGITAL_ISSUE = By.xpath("//a[@class='cta-btn cta-btn--outline cta-btn--red purchase-link']");

    public BuyPage(WebDriver driver) {
        super(driver);;
    }

    public DigitalStorePage clickOnBuyDigitalIssue() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(BUY_DIGITAL_ISSUE)).click();
        return new DigitalStorePage(driver);
    }
}