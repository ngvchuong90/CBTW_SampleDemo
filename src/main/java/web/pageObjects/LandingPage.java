package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

public class LandingPage extends BasePage{
    private WebDriver driver;
    private final By loginBtn = By.xpath("//nav[@id='navbar']//a[@class='nav-link' and text()='Login']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage open(){
        driver.get(ConfigReader.get("baseUrl"));
        waitForPageLoad(driver);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        driver.findElement(loginBtn).click();
        waitForPageLoad(driver);
        return new LoginPage(driver);
    }
}
