package mobile;

import mobile.pageObjects.MobileLandingPage;
import org.testng.annotations.Test;

public class ComputeTwoValues extends MobileBaseTestConfig {

    @Test
    public void testComputeSum2Value() {
        MobileLandingPage mobileLandingPage = new MobileLandingPage(driver);

        mobileLandingPage.inputValueToIntegerA(1)
                .inputValueToIntegerB(2)
                .clickOnComputeSumButton()
                .verifySumValue(3);
    }
}
