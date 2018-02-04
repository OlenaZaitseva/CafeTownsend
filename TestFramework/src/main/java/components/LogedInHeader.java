package components;

import Pages.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogedInHeader {
    private static final By LOGOUT_BUTTON_LOCATOR = By.className("main-button");

    private WebElement nestedElement;

    public LogedInHeader(WebElement element){
        nestedElement = element;
    }

    public boolean checkLoggedGreetingsIsNotDisplayed(){
        boolean hideHeader = nestedElement.getAttribute("class").contains("hide-header");
        return hideHeader;


    }
    public Button GetLogoutButton() {
        WebElement element = nestedElement.findElement(LOGOUT_BUTTON_LOCATOR);
        return new Button(element);
    }
}
