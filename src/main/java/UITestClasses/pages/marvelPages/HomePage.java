package UITestClasses.pages.marvelPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public final WebDriver driver;

    private final static By SEARCH_ICON = By.xpath("//a[@class='search desktopNav__tab']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage clickOnElementSearch() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(SEARCH_ICON)).click();
        return new SearchPage(driver);
    }
    public void switchToWindow(int numberWindow) {
        String handle = driver.getWindowHandles().toArray()[numberWindow]
                .toString();
        driver.switchTo().window(handle);
    }
}
