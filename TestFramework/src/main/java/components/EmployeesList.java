package components;

import Pages.Navigation;
import Pages.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EmployeesList {
    private WebElement nestedElement;

    public EmployeesList(WebElement element) {
        nestedElement = element;
    }

    public Employee searchEmploee(String name) {

        List<WebElement> list = nestedElement.findElements(By.tagName("li"));
        Employee searchedemployee = null;
        for (int i = 0; i < list.size(); i++) {

            String employeeName = list.get(i).getText();
            if (employeeName.contains(name)) {
                searchedemployee = new Employee(list.get(i));

            }

        }
        return searchedemployee;
    }
}

