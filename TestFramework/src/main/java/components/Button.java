package components;

import Pages.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
    private WebElement nestedElement;

    public Button(WebElement element){
        nestedElement = element;
    }

    public void click(){
        new WebDriverWait(Navigation.getDriver(), Navigation.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(nestedElement));
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }
    public void doubleClick(){
        new WebDriverWait(Navigation.getDriver(), Navigation.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(nestedElement));
        nestedElement.click();
        Navigation.waitAngularLoaded();
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }
}
