package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by user on 7/23/18.
 */
public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private final String BASE_URL = "https://www.wallethub.com/";
    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        getDriver().get(BASE_URL + getPageUrl());
        return page.get();
    }
    public abstract String getPageUrl();

    public T init(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        return page.get();
    }

    public WebElement waitForElement(WebElement element) {
        PageLoadHelper.isLoaded().isElementIsVisible(element);
        return element;
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

