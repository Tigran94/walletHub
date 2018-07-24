package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.getDriver;

public class ProfilePage extends BasePage<ProfilePage> {

    public final String userName = System.getProperty("userName");

    @FindBy(css = ".activity.activity-first")
    WebElement reviewFeedContent;

    @FindBy(xpath = "//div[@class='profilenav']/ul/li[3]/a")
    WebElement reviews;

    @FindBy(css = ".review-first")
    WebElement reviewContent;

    private Actions actions;

    public ProfilePage(){
        super(getDriver());
        actions = new Actions(getDriver());
    }

    public ProfilePage init() {
        return new ProfilePage().init(ProfilePage.class);
    }

    public boolean isContentVisible(){
        return reviewFeedContent.isDisplayed();
    }

    public String getActivityText(){
        PageLoadHelper.isLoaded().waitForPageLoaded();
        return reviewFeedContent.findElement(By.cssSelector(".feeddesc")).getText().replace(" ","");
    }

    public String getReviewerName(){
        return reviewFeedContent.findElement(By.cssSelector(".feeddesc.feeddesc-gray")).findElement(By.tagName("a"))
                .getText().replace("@","");
    }


    public void clickReviews(){
        reviews.click();
    }

    public boolean isReviewVisible(){
        return reviewContent.isDisplayed();
    }

    public String getReviewText(){
        return reviewContent.findElement(By.tagName("p")).getText().replace(" ","");
    }

    @Override
    public String getPageUrl() {return "/profile/wallethub_125/";}

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().waitForPageLoaded();
    }
}
