package Pages;

import components.Button;
import components.LogedInHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private static final String LOGIN_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/login";
    private static final String EMPLOYEES_PAGE_URL = "http://cafetownsend-angular-rails.herokuapp.com/employees";
    private static final String LOGIN_PAGE_CHECKPOINT = "CafeTownsend-AngularJS-Rails";


    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("button.main-button");

    private static final By USERNAME_LOCATOR = By.cssSelector("form#login-form label:nth-child(3) > input");
    private static final By PASSWORD_LOCATOR = By.cssSelector("form#login-form label:nth-child(4) > input");
    private static final By HEADER_LOCATOR = By.className("header-container");

    public LoginPage() {
        Navigation.waitAngularLoaded();
    }

    public static LoginPage open() {
        Navigation.goTo(LOGIN_PAGE_URL);

        assert LOGIN_PAGE_CHECKPOINT.equals(Navigation.getDriver().getTitle()) : "Cannot open Login Page";
        return new LoginPage();
    }
    public LoginPage openEmployeeListByUrl() {
        Navigation.goTo(EMPLOYEES_PAGE_URL);
        return new LoginPage();
    }

    public Button GetLoginButton() {
        WebElement element = Navigation.getDriver().findElement(LOGIN_BUTTON_LOCATOR);
        return new Button(element);
    }


    public void EnterUsername(String username) {
        WebElement element = Navigation.getDriver().findElement(USERNAME_LOCATOR);
        element.sendKeys(username);

    }

    public void EnterPassword(String password) {
        WebElement element = Navigation.getDriver().findElement(PASSWORD_LOCATOR);
        element.sendKeys(password);

    }

    public void login (String username,String password) {
        LoginPage page = LoginPage.open();
        page.EnterUsername(username);
        page.EnterPassword(password);
        page.GetLoginButton().click();

    }

    public boolean isUserLoggedIn(){
       boolean headerHidenDisplayed = getLoginHeader().checkLoggedGreetingsIsNotDisplayed();
       return !headerHidenDisplayed;
    }

    public LogedInHeader getLoginHeader(){
        WebElement element = Navigation.getDriver().findElement(HEADER_LOCATOR);
        return new LogedInHeader(element);
    }

}
