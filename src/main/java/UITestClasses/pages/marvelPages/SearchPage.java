package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private final static By COMICS_CHAPTER = By.xpath("//a[text()='comics']");
    private final static By INPUT_LINE = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    private final static By DEADPOOL_2019_10 = By.xpath("//a[text()='Deadpool (2019) #10']");
    private final static String heroName = "Deadpool";
    private static final By VIDEO_CHAPTER = By.xpath("");
    private static final By CHARACTER_CHAPTER = By.xpath("");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeyAndPressEnter(){
        WebElement element = driver.findElement(INPUT_LINE);
        element.sendKeys(heroName);
        element.sendKeys(Keys.ENTER);
    }
    public void clickOnComicsChapter(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(COMICS_CHAPTER)).click();
    }
    public BuyPage clickOnComics(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(DEADPOOL_2019_10)).click();
        return new BuyPage(driver);
    }
}
