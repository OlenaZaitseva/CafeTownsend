package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeesList {
    private WebElement nestedElement;
    private static final By LIST_ITEM_LOCATOR = By.tagName("li");;

    public EmployeesList(WebElement element) {
        nestedElement = element;
    }

    public EmployeeListItem searchEmployee(String name) {
        List<WebElement> list = nestedElement.findElements(LIST_ITEM_LOCATOR);
        EmployeeListItem matchingEmployee = null;
        for (int i = 0; i < list.size(); i++) {
            String employeeName = list.get(i).getText();
            if (employeeName.contains(name)) {
                matchingEmployee = new EmployeeListItem(list.get(i));
                break;
            }
        }
        return matchingEmployee;
    }

    public boolean checkIsEmployeeFound(String name) {
        boolean employeeFound = false;
        List<WebElement> list = nestedElement.findElements(LIST_ITEM_LOCATOR);
        for (int i = 0; i < list.size(); i++) {
            String employeeName = list.get(i).getText();
            if (employeeName.contains(name)) {
                employeeFound = true;
                break;
            }
        }
        return employeeFound;
    }
}

