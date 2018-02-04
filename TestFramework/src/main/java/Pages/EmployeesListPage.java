package Pages;

import components.Button;
import components.Employee;
import components.EmployeesList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeesListPage{
    private static final By CREATE_BUTTON_LOCATOR = By.id("bAdd");
    private static final By EDIT_BUTTON_LOCATOR = By.id("bEdit");
    private static final By DELETE_BUTTON_LOCATOR = By.id("bDelete");
    private static final By EMPLOYEELIST_BUTTON_LOCATOR = By.id("employee-list");

    public Button getCreateButton(){
    WebElement element = Navigation.getDriver().findElement(CREATE_BUTTON_LOCATOR);
    return new Button(element);
}
    public Button getEditButton(){
        WebElement element = Navigation.getDriver().findElement(EDIT_BUTTON_LOCATOR);
        return new Button(element);
    }

    public Button getDeleteButton(){
        WebElement element = Navigation.getDriver().findElement(DELETE_BUTTON_LOCATOR);
        return new Button(element);
    }

public Employee getEmployee(String name){
        WebElement employeelist = Navigation.getDriver().findElement(EMPLOYEELIST_BUTTON_LOCATOR);
        EmployeesList list = new EmployeesList(employeelist);
        Employee employee = list.searchEmploee(name);
        return employee;
}

}
