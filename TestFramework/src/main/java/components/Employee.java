package components;

import Pages.Navigation;
import Pages.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Employee {
    private WebElement nestedElement;
    public Employee (WebElement element){
        nestedElement = element;
    }
    public void click(){
        //Wait.createNew().until(ExpectedConditions.elementToBeClickable(nestedElement));
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }

}
