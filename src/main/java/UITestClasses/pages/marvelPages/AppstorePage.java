package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppstorePage extends HomePage{

    private final static By TITLE = By.xpath("//title");

    public AppstorePage(WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
         return driver.findElement(TITLE).getText();
    }
    public void closeAppStorePage(){
        driver.close();
    }
}
