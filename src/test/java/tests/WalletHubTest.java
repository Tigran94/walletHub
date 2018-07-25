package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CompanyPage;
import pages.ProfilePage;
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
    ProfilePage profilePage;

    SoftAssert softAssert;
    String rgbColor = "rgba(73, 224, 224, 1)";

    @BeforeMethod
    public void init(){
        companyPage = new CompanyPage();
        loginSteps = new LoginSteps();
        reviewPage = new ReviewPage();
        profilePage = new ProfilePage();
    }

    @Test
    public void test() throws InterruptedException {
        companyPage = companyPage.init();
        companyPage.open();
        if(companyPage.isLoginButtonPresent()){
            loginSteps.login();
            companyPage.open();
        }
        companyPage.hoverOnStars();
        companyPage.hoverOnStar("4");

        Assert.assertEquals(companyPage.getActiveStarsCount(),4,"Stars doesn't lit up");


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
        String randomText = reviewPage.setText();
        reviewPage.clickSubmitButton();

        companyPage.hoverOnWalletHubDropDown();
        companyPage.clickProfile();

        profilePage = profilePage.init();
        softAssert.assertTrue(profilePage.isContentVisible(),"Content is not visible in activity feed");
        softAssert.assertEquals(randomText,profilePage.getActivityText(),"Activity content text is missmatched");
        softAssert.assertEquals(profilePage.getReviewerName(),profilePage.userName,"Wrong reviewer name");

        softAssert.assertAll();

        profilePage.clickReviews();

        softAssert.assertTrue(profilePage.isReviewVisible(),"Review is not visible in review feed");
        softAssert.assertEquals(randomText,profilePage.getReviewText(),"Reviews content text is missmatched");

        softAssert.assertAll();
    }
}
