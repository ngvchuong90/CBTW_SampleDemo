package mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MobileLandingPage {
    private AppiumDriver driver;

    private By integerATxt = By.xpath("//XCUIElementTypeTextField[@name='IntegerA']");
    private By integerBTxt = By.xpath("//XCUIElementTypeTextField[@name='IntegerB']");
    private By computeSumBtn = By.xpath("//XCUIElementTypeButton[@name='ComputeSumButton']");
    private By answerValueLabel = By.xpath("//XCUIElementTypeStaticText[@name='Answer']");

    public MobileLandingPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public MobileLandingPage inputValueToIntegerA(int value) {
        driver.findElement(integerATxt).clear();
        driver.findElement(integerATxt).sendKeys(String.valueOf(value));
        return this;
    }

    public MobileLandingPage inputValueToIntegerB(int value) {
        driver.findElement(integerBTxt).clear();
        driver.findElement(integerBTxt).sendKeys(String.valueOf(value));
        return this;
    }

    public MobileLandingPage clickOnComputeSumButton() {
        driver.findElement(computeSumBtn).click();
        return this;
    }

    public void verifySumValue(int expectedValue) {
        Assert.assertEquals(Integer.parseInt(driver.findElement(answerValueLabel).getText()), expectedValue, "Sum is not correct");
    }
}
