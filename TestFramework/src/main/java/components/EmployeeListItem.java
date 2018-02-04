package components;

import Pages.Navigation;
import org.openqa.selenium.WebElement;

public class EmployeeListItem {

    private WebElement nestedElement;

    public EmployeeListItem(WebElement element){
        nestedElement = element;
    }
    public void click(){
        nestedElement.click();
        Navigation.waitAngularLoaded();
    }

    public boolean isSelected(){
        boolean isSelected = nestedElement.getAttribute("class").contains("active");
        return isSelected;
    }



}
