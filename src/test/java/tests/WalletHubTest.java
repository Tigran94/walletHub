package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CompanyPage;
import pages.ReviewPage;
import setup.BaseTest;
import steps.LoginSteps;


/**
 * Created by user on 7/23/18.
 */
public class WalletHubTest extends BaseTest {
    CompanyPage companyPage;
    LoginSteps loginSteps;
    ReviewPage reviewPage;
    SoftAssert softAssert;
    String rgbColor = "rgba(73, 224, 224, 1)";

    @BeforeMethod
    public void init(){
        companyPage = new CompanyPage();
        loginSteps = new LoginSteps();
        reviewPage = new ReviewPage();
    }

    @Test
    public void test() {
        companyPage = companyPage.init();
        companyPage.open();
        if(companyPage.isLoginButtonPresent()){
            loginSteps.login();
            companyPage.open();
        }
        companyPage.hoverOnStars();
        companyPage.hoverOnStar("4");

        companyPage.clickStar("4");
        reviewPage = reviewPage.init();

        reviewPage.selectHealthPolicy();

        reviewPage.hoverOnStar("4");
        softAssert = new SoftAssert();

        softAssert.assertEquals(reviewPage.getStarColor("1"),rgbColor);
        softAssert.assertEquals(reviewPage.getStarColor("2"),rgbColor);
        softAssert.assertEquals(reviewPage.getStarColor("3"),rgbColor);
        softAssert.assertEquals(reviewPage.getStarColor("4"),rgbColor);
        softAssert.assertAll();

        reviewPage.hoverOnStar("5");
        reviewPage.clickStar("5");
        reviewPage.setText();
        reviewPage.clickSubmitButton();

    }
}
