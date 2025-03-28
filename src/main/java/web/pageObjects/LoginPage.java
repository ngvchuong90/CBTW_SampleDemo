package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private By usernameOrEmailTxt = By.xpath("//input[@id='identifier']");
    private By passwordTxt = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(usernameOrEmailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public DashboardPage loginSuccessful(String email, String password) {
        login(email, password);
        waitForPageLoad(driver);
        return new DashboardPage(driver);
    }
}
