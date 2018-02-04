package components;

import Pages.Navigation;
import Pages.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button {
    private WebElement nestedElement;

    public Button(WebElement element){
        nestedElement = element;
    }

    public void click(){
        Wait.createNew().until(ExpectedConditions.elementToBeClickable(nestedElement));
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }
    public void doubleClick(){
        Wait.createNew().until(ExpectedConditions.elementToBeClickable(nestedElement));
        nestedElement.click();
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }
}
