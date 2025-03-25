package web;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BaseTest;
import pageObjects.ChallengePage;
import pageObjects.LoginPage;

public class WebTest extends BaseTest {

    @Test
    public void testCreateChallenge() {
        driver.get("https://ctflearn.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@gmail.com", "password123");

        ChallengePage challengePage = new ChallengePage(driver);
        challengePage.createChallenge("Test Challenge", "This is a sample challenge.");

        // Verify Challenge Created
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Test Challenge"));

        System.out.println("Challenge Created Successfully!");
    }
}
