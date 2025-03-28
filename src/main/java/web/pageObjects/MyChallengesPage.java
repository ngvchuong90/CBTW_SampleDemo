package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyChallengesPage extends BasePage{
    private WebDriver driver;
    private By lblCardTitleByValue(String title){
        return By.xpath("//div[contains(@class, 'card-header')]/span[text()='" + title +"']");
    };

    public MyChallengesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCardTitleIsDisplayed(String title){
        Assert.assertTrue(driver.findElement(lblCardTitleByValue(title)).isDisplayed(), "Card title is not displayed");
    }
}

