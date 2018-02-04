import Pages.EmployeeDetailsPage;
import Pages.EmployeesListPage;
import Pages.LoginPage;
import Pages.Navigation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditTest {

    private CreateTest createTestSteps = new CreateTest();

    @Test
    public void testEditEmployeeDetailsWithValidData() {
        String userFirsName = RandomStringUtils.randomAlphabetic(10);
        String userLastName = RandomStringUtils.randomAlphabetic(10);
        String newEmail = userLastName+"@mail.com";
        String newStartDate = "2010-03-07";
        String newFirstName = "Edited";
        String newLastName = "Edited";

        createTestSteps.createNewEmployee(userFirsName, userLastName, "2012-12-12", "123@mail.com");

        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userLastName).click();
        employeelist.getEditButton().click();

        EmployeeDetailsPage employeedetails = new EmployeeDetailsPage();
        employeedetails.getEmployeeEmail().clear();
        employeedetails.getEmployeeStartDate().clear();
        employeedetails.setFirstName(newFirstName);
        employeedetails.setLastName(newLastName);
        employeedetails.setStartDate(newStartDate);
        employeedetails.setEmail(newEmail);
        employeedetails.getUpdatebutton().click();
        employeelist.getEmployee(userLastName).click();
        employeelist.getEditButton().click();

        Assert.assertTrue("FirstName was not updated", employeedetails.getEmployeeFirstName().getAttribute("value").contains("Edited"));
        Assert.assertTrue("LastName was not updated", employeedetails.getEmployeeLastName().getAttribute("value").contains("Edited"));
        Assert.assertTrue("StartDate was not updated", employeedetails.getEmployeeStartDate().getAttribute("value").contains(newStartDate));
        Assert.assertTrue("Email was not updated", employeedetails.getEmployeeEmail().getAttribute("value").contains(newEmail));
    }

    @Test
    public void testEditEmployeeDetailsCancel() {
        String userFirsName = RandomStringUtils.randomAlphabetic(10);
        String userLastName = RandomStringUtils.randomAlphabetic(10);
        String newEmail = userLastName+"@mail.com";
        String newStartDate = "2010-03-07";

        createTestSteps.createNewEmployee(userFirsName, userLastName, "2012-12-12", "123@mail.com");
        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userFirsName).click();
        employeelist.getEditButton().click();

        EmployeeDetailsPage employeedetails = new EmployeeDetailsPage();
        employeedetails.getEmployeeEmail().clear();
        employeedetails.setFirstName("CancelEdit");
        employeedetails.setLastName("CancelEdit");
        employeedetails.getEmployeeStartDate().clear();
        employeedetails.setStartDate(newStartDate);
        employeedetails.setEmail(newEmail);
        employeedetails.getBackbutton().click();
        employeelist.getEmployee(userFirsName).click();
        employeelist.getEditButton().click();

        Assert.assertFalse("FirstName was not updated", employeedetails.getEmployeeFirstName().getAttribute("value").contains("CancelEdit"));
        Assert.assertFalse("LastName was not updated", employeedetails.getEmployeeLastName().getAttribute("value").contains("CancelEdit"));
        Assert.assertFalse("StartDate was not updated", employeedetails.getEmployeeStartDate().getAttribute("value").contains("2000-02-13"));
        Assert.assertFalse("Email was not updated", employeedetails.getEmployeeEmail().getAttribute("value").contains("cancel@mail.com"));
    }

    @Test
    public void testEditEmployeeDetailsWithInvalidData() {
        String userName = RandomStringUtils.randomAlphabetic(10);
        String newEmail = "!@#$";
        String newStartDate = "abc";

        createTestSteps.createNewEmployee(userName, "x", "2012-12-12", "123@mail.com");

        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userName).click();
        employeelist.getEditButton().click();

        EmployeeDetailsPage employeedetails = new EmployeeDetailsPage();
        employeedetails.getEmployeeEmail().clear();
        employeedetails.getEmployeeFirstName().clear();
        employeedetails.getEmployeeStartDate().clear();
        employeedetails.setStartDate(newStartDate);
        employeedetails.setEmail(newEmail);
        employeedetails.getUpdatebutton().click();

        Assert.assertTrue("EmployeeListItem was updated with invalid data", employeedetails.isDataInvalid(employeedetails.getEmployeeEmail()));
        Assert.assertTrue("EmployeeListItem was updated with invalid data", employeedetails.isDataInvalid(employeedetails.getEmployeeFirstName()));
        Assert.assertTrue("EmployeeListItem was updated with invalid data", employeedetails.isDataInvalid(employeedetails.getEmployeeStartDate()));
    }

    @Before
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Luke", "Skywalker");
    }

    @After
    public void cleanUpDriver() {
        Navigation.quitDriver();
    }
}