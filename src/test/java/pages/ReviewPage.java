package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by user on 7/23/18.
 */
public class ReviewPage extends BasePage<ReviewPage> {
    private Actions actions;
    @FindBy(css = ".val")
    private WebElement selectYourPolicySelectBox;
    @FindBy(xpath = "//textarea")
    private WebElement textarea;
    @FindBy(css = ".btn.blue")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href='#' and contains(text(),'Health')]")
    private WebElement policyHealth;


    public ReviewPage() {
        super(getDriver());
        actions= new Actions(getDriver());
    }

    public void selectHealthPolicy(){
        PageLoadHelper.isLoaded().isElementIsVisible(selectYourPolicySelectBox);
        selectYourPolicySelectBox.click();
        policyHealth.click();

    }
    public void hoverOnStar(String starCount){
        actions.moveToElement(getDriver().findElement(By.xpath("//span[@id='overallRating']//a[@href='#'][?]".replace("?",starCount)))).perform();
    }
    public void clickStar(String starCount){
        PageLoadHelper.isLoaded().waitForPageLoaded();
       getDriver().findElement(By.xpath("//span[@id='overallRating']//a[@href='#'][?]".replace("?",starCount))).click();
    }
    public String getStarColor(String starCount){
        return getDriver().findElement(By.xpath("//span[@id='overallRating']//a[@href='#'][?]".replace("?",starCount))).getCssValue("color");

    }
    public String randomString(int characterCount){
        return RandomStringUtils.randomAlphabetic(characterCount);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }

    public String setText(){
        textarea.clear();
        String randomText = randomString(60)+" "+randomString(50)+" "+
                randomString(50)+" "+randomString(50)+" "+randomString(10);

        textarea.sendKeys(randomText);
        return randomText.replace(" ","");
    }
    public ReviewPage init() {
        return new ReviewPage().init(ReviewPage.class);
    }

    @Override
    public String getPageUrl() {
        return "";
    }
    @Override
    protected void load() {
    }
    @Override
    protected void isLoaded() throws Error {

    }
}
