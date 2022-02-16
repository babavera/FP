package UITestClasses.pages.marvelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePlayPage extends HomePage{

    private final static By TITLE = By.xpath("//title[@id]");

    public GooglePlayPage (WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }

    public void closeGooglePlayPage (){
        driver.close();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

}
