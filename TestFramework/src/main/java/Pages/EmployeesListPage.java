package Pages;

import components.Button;
import components.EmployeeListItem;
import components.EmployeesList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeesListPage {
    private static final By CREATE_BUTTON_LOCATOR = By.id("bAdd");
    private static final By EDIT_BUTTON_LOCATOR = By.id("bEdit");
    private static final By DELETE_BUTTON_LOCATOR = By.id("bDelete");
    private static final By EMPLOYEELIST_BUTTON_LOCATOR = By.id("employee-list");

    public Button getCreateButton() {
        WebElement element = Navigation.getDriver().findElement(CREATE_BUTTON_LOCATOR);
        return new Button(element);
    }

    public Button getEditButton() {
        WebElement element = Navigation.getDriver().findElement(EDIT_BUTTON_LOCATOR);
        return new Button(element);
    }

    public Button getDeleteButton() {
        WebElement element = Navigation.getDriver().findElement(DELETE_BUTTON_LOCATOR);
        return new Button(element);
    }

    public EmployeeListItem getEmployee(String name) {
        EmployeeListItem employee = getListOfEmployees().searchEmployee(name);
        return employee;
    }


    public EmployeesList getListOfEmployees() {
        WebElement employeelist = Navigation.getDriver().findElement(EMPLOYEELIST_BUTTON_LOCATOR);
        EmployeesList list = new EmployeesList(employeelist);
        return list;
    }

    public boolean isEmployeeFound(String name){
        boolean isEmployeeFound = getListOfEmployees().checkIsEmployeeFound(name);
        return  isEmployeeFound;
    }
}
