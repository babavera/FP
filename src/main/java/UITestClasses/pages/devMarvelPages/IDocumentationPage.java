package UITestClasses.pages.devMarvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IDocumentationPage extends HomePageDev {

    private final static By V1_PUBLIC_CHARACTERS = By.xpath("//a[text()='/v1/public/characters']");
    private final static By TRY_IT_NOW_BUTTON = By.xpath("//input[@value='Try it out!'][1]");
    private final static By CODE = By.xpath("//div[@class='block response_code']/pre");
    private final static By NAME = By.xpath("//input[@class='parameter' and @name='name'] ");
    private final static By LOG_OUT = By.xpath("//a[@id='logout']");
    private final static String heroName = "Groot";


    public IDocumentationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnV1PublicCharacters() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(V1_PUBLIC_CHARACTERS)).click();
    }

    public void sendNameOfHero() {
        driver.findElement(NAME).sendKeys(heroName);
    }

    public void clickOnTryButton() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(TRY_IT_NOW_BUTTON)).click();
    }

    public String getResponseCode() {
        return driver.findElement(CODE).getText();
    }

    public void clickOnLogOut() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(LOG_OUT)).click();

    }
}