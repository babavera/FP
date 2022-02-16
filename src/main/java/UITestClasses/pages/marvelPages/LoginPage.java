package UITestClasses.pages.marvelPages;

import org.openqa.selenium.*;

public class LoginPage extends HomePage{

    private final static By IFRAME = By.xpath("//iframe[@id='disneyid-iframe']");
    private final static By USERNAME_INPUT = By.xpath("//input[contains(@type,'email')]");
    private final static By PASSWORD_INPUT = By.xpath("//input[contains(@type,'password')]");
    private final static By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary btn-submit ng-isolate-scope']");

    private final static String emailAddress = "SerheyVeremeichik@gmail.com";
    private final static String password = "BabaVera81";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin() {
        driver.switchTo().frame(driver.findElement(IFRAME));
        fillLoginData(emailAddress, password);
        submitLoginForm();
        driver.switchTo().defaultContent();
    }
    public void fillLoginData(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);

    }
    public void submitLoginForm() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

}
