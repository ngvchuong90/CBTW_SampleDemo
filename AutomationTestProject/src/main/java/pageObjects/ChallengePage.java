package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChallengePage {
    private WebDriver driver;
    private By createChallengeButton = By.xpath("//button[text()='Create Challenge']");
    private By challengeTitle = By.id("title");
    private By challengeDescription = By.id("description");
    private By saveButton = By.xpath("//button[text()='Save']");

    public ChallengePage(WebDriver driver) {
        this.driver = driver;
    }

    public void createChallenge(String title, String description) {
        driver.findElement(createChallengeButton).click();
        driver.findElement(challengeTitle).sendKeys(title);
        driver.findElement(challengeDescription).sendKeys(description);
        driver.findElement(saveButton).click();
    }
}

