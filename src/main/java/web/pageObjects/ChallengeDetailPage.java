package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChallengeDetailPage extends BasePage{
    private WebDriver driver;
    private By titleTxt = By.xpath("//input[@id='title']");
    private By flagTxt = By.xpath("//input[@id='flag']");
    private By descriptionTxt = By.xpath("//textArea[@id='flask-pagedown-description']");
    private By howtoSolveTxt = By.xpath("//input[@id='howtosolve']");
    private By submitForVerificationBtn = By.xpath("//button[text()='Submit for Verification']");

    public ChallengeDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createChallenge(String titleValue, String flagValue, String descriptionValue, String howToSolveValue) {
        if(titleValue != null && !titleValue.isEmpty()){
            driver.findElement(titleTxt).sendKeys(titleValue);
        }

        if(flagValue != null && !flagValue.isEmpty()){
            driver.findElement(flagTxt).sendKeys(flagValue);
        }

        if(descriptionValue != null && !descriptionValue.isEmpty()){
            driver.findElement(descriptionTxt).sendKeys(descriptionValue);
        }

        if(howToSolveValue != null && !howToSolveValue.isEmpty()){
            driver.findElement(howtoSolveTxt).sendKeys(howToSolveValue);
        }
        driver.findElement(submitForVerificationBtn).click();
        waitForPageLoad(driver);
    }
}

