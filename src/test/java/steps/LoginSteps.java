package steps;

import pages.BasePage;
import pages.LoginPage;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by user on 7/23/18.
 */
public class LoginSteps extends BasePage<LoginSteps> {
    private final String EMAIL = System.getProperty("email");
    private final String PASSWORD = System.getProperty("password");
    private LoginPage loginPage;
    public LoginSteps(){
       super(getDriver());
    }
    public void login(){
        loginPage = new LoginPage().open();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        loginPage.clickContinueToWalletHubButton();
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    }

    @Override
    public String getPageUrl() {
        return "";
    }
}
