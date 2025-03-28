package web;

import org.testng.annotations.Test;
import utilities.Utilities;
import web.pageObjects.*;

public class CreateChallenges_Test extends WebBaseTestConfig {
    LandingPage landingPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateChallengePage createChallengePage;
    ChallengeDetailPage challengeDetailPage;
    MyChallengesPage myChallengesPage;
    NavigationBar navigationBar;

    @Test
    public void testCreateChallenge() {
        landingPage = new LandingPage(driver);

        loginPage = landingPage
                .open()
                .clickOnLoginButton();

        dashboardPage = loginPage
                .loginSuccessful("ngvchuong90@gmail.com", "123abc!@#");

        navigationBar = new NavigationBar(driver);

        createChallengePage = (CreateChallengePage) navigationBar
                .clickOnDropdownChallengesArrow()
                .clickOnChallengeMenuOption("Create Challenge");

        String timeStamp = Utilities.generateTimestamp();
        String titleValue = "Title " + timeStamp;
        String flagValue = "CTFlearn{" + timeStamp + "}";
        String descriptionValue = "";
        String howToSolveValue = timeStamp + timeStamp + timeStamp;

        challengeDetailPage = createChallengePage.createChallenge(
                titleValue,
                flagValue,
                descriptionValue,
                howToSolveValue
        );

        myChallengesPage = (MyChallengesPage) navigationBar
                .clickOnDropdownChallengesArrow()
                .clickOnChallengeMenuOption("My Challenges");

        myChallengesPage.verifyCardTitleIsDisplayed(titleValue);
    }
}
