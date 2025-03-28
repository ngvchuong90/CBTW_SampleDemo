package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage{
    WebDriver driver;
    private By dropdownChallengesMenu = By.xpath("//a[@id='navbarDropdownMenuLink']/following-sibling::a");
    private By dropdownChallengeOptionByName(String optionName){
        return By.xpath("//div[@class='dropdown-menu show']/a[@class='dropdown-item' and text()='" + optionName + "']");
    }

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar clickOnDropdownChallengesArrow() {
        driver.findElement(dropdownChallengesMenu).click();
        return this;
    }

    public Object clickOnChallengeMenuOption(String optionName) {
        if(optionName.equals("Create Challenge")){
            driver.findElement(dropdownChallengeOptionByName(optionName)).click();
            waitForPageLoad(driver);
            return new CreateChallengePage(driver);
        } else if(optionName.equals("My Challenges")){
            driver.findElement(By.xpath("//a[contains(text(),'My') and contains(text(),'Challenges')]")).click();
            waitForPageLoad(driver);
            return new MyChallengesPage(driver);
        }
        return null;
    }
}
