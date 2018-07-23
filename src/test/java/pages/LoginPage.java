package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.getDriver;


/**
 * Created by user on 7/23/18.
 */
public class LoginPage extends BasePage<LoginPage>{

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement email;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='button']//span/..")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='btns']/button")
    private WebElement continueToWalletHubButton;

    public LoginPage(){
        super(getDriver());
    }
    public LoginPage open() {
        return new LoginPage().openPage(LoginPage.class);
    }
    public LoginPage init() {
        return new LoginPage().init(LoginPage.class);
    }

    @Override
    public String getPageUrl() {
        return "/join/login";
    }

    public void setEmail(String email){
        PageLoadHelper.isLoaded().isElementIsVisible(this.email);
        this.email.sendKeys(email);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickContinueToWalletHubButton(){
        PageLoadHelper.isLoaded().isElementIsVisible(continueToWalletHubButton);
        continueToWalletHubButton.click();
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        PageLoadHelper.isLoaded().waitForPageLoaded();
    }
}
