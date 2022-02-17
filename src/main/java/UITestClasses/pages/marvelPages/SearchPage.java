package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage {

    private final static By COMICS_CHAPTER = By.xpath("//a[text()='comics']");
    private final static By INPUT_LINE = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    private final static By DEADPOOL_2019_2 = By.xpath("//a[text()='Deadpool (2019) #2']");
    private final static String heroName = "Deadpool";

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
        driver.findElement(COMICS_CHAPTER).click();
    }
    public BuyPage clickOnComics(){
        driver.findElement(DEADPOOL_2019_2).click();
        return new BuyPage(driver);
    }
}
