package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;


import java.util.List;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by user on 7/23/18.
 */
public class CompanyPage extends BasePage<CompanyPage>  {
    private Actions actions;
    @FindBy(css = ".login")
    private WebElement loginButton;

    @FindBy(css = ".wh-rating.rating_4_5")
    private WebElement stars;

    @FindBy(xpath = "//a[@data-menu='m-user']")
    private WebElement navWalletHub;

    @FindBy(id="m-user")
    private  WebElement walletHubDropDown;

    @FindBy(xpath = "//a[text()='Profile']")
    private WebElement profile;

    @FindBy(css = ".hover")
    private List<WebElement> star;



    public CompanyPage() {
        super(getDriver());
        actions =new Actions(getDriver());
    }

    public CompanyPage init() {
        return new CompanyPage().init(CompanyPage.class);
    }

    public CompanyPage open() {
        return new CompanyPage().openPage(CompanyPage.class);
    }

    public boolean isLoginButtonPresent(){
        return loginButton.isDisplayed();
    }

    public void hoverOnStar(String starCount){
        actions.moveToElement(getDriver().findElement(By.xpath("//div[@class='wh-rating-choices-holder']//a[@href='#' and contains(text(),'?')]".replace("?",starCount)))).perform();
    }
    public int getActiveStarsCount() throws InterruptedException {
        return star.size()+1;
    }
    public void clickStar(String starCount){
        getDriver().findElement(By.xpath("//div[@class='wh-rating-choices-holder']//a[@href='#' and contains(text(),'?')]".replace("?",starCount))).click();
    }
    public void hoverOnStars(){
        PageLoadHelper.isLoaded().isElementIsVisible(stars);
        actions.moveToElement(stars).perform();
    }

    public void hoverOnWalletHubDropDown(){
        actions.moveToElement(navWalletHub).perform();
        waitForElement(walletHubDropDown);
    }

    public void clickProfile(){
        profile.click();
        PageLoadHelper.isLoaded().waitForPageLoaded();
    }

    @Override
    public String getPageUrl() {
        return "/profile/test_insurance_company/";
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().waitForPageLoaded();
    }
}
