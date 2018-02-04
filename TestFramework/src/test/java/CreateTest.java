import Pages.EmployeeDetailsPage;
import Pages.EmployeesListPage;
import Pages.LoginPage;
import Pages.Navigation;
import components.EmployeeListItem;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateTest {

    public void createNewEmployee(String firstName, String lastName, String date, String email) {
        EmployeesListPage listPage = new EmployeesListPage();
        listPage.getCreateButton().click();

        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName(firstName);
        detailsPage.setLastName(lastName);
        detailsPage.setStartDate(date);
        detailsPage.setEmail(email);
        detailsPage.getAddbutton().click();
    }

    @Test
    public void testUserIsCreated() {
        String userName = RandomStringUtils.randomAlphabetic(10);

        createNewEmployee(userName, "x", "2012-12-12", "123@mail.com");

        EmployeesListPage listPage = new EmployeesListPage();
        EmployeeListItem foundEmployee = listPage.getEmployee(userName);
        foundEmployee.click();

        Assert.assertTrue("User was not created", foundEmployee.isSelected());
    }

    @Test
    public void testEmployeeIsNotCreatedWithEmptyFields() {
        EmployeesListPage listPage = new EmployeesListPage();
        String userName = RandomStringUtils.randomAlphabetic(10);
        listPage.getCreateButton().click();

        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName("");
        detailsPage.setLastName("");
        detailsPage.setStartDate("");
        detailsPage.setEmail("");
        detailsPage.getAddbutton().click();
        Assert.assertTrue("EmployeeListItem was created with invalid data", detailsPage.isDataInvalid(detailsPage.getEmployeeFirstName()));
    }

    @Test
    public void testCancelEpmloyeeCreation() {
        EmployeesListPage listPage = new EmployeesListPage();

        String userName = RandomStringUtils.randomAlphabetic(10);
        listPage.getCreateButton().click();

        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName(userName);
        detailsPage.setLastName("123");
        detailsPage.setStartDate("2017-02-10");
        detailsPage.setEmail("Lev@mail.com");
        detailsPage.getCancelbutton().click();
        Assert.assertFalse("EmployeeListItem was created with invalid data", listPage.isEmployeeFound(userName));
    }

    @Test
    public void testEpmloyeeIsNotCreatedWithInvalidStartDate() {
        String userName = RandomStringUtils.randomAlphabetic(10);

        EmployeesListPage listPage = new EmployeesListPage();
        listPage.getCreateButton().click();

        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName(userName);
        detailsPage.setLastName("123");
        detailsPage.setStartDate("abc");
        detailsPage.setEmail("Lev@mail.com");
        detailsPage.getAddbutton().click();
        String message = Navigation.getDriver().switchTo().alert().getText();
        Navigation.getDriver().switchTo().alert().accept();

        Assert.assertTrue("No alert with error message when invalid date set",message.contains("Error"));
    }

    @Test
    public void testEpmloyeeIsNotCreatedWithInvalidEmail() {
        String userName = RandomStringUtils.randomAlphabetic(10);

        EmployeesListPage listPage = new EmployeesListPage();
        listPage.getCreateButton().click();

        EmployeeDetailsPage detailsPage = new EmployeeDetailsPage();
        detailsPage.setFirstName(userName);
        detailsPage.setLastName("123");
        detailsPage.setStartDate("2021-12-12");
        detailsPage.setEmail("@#$");
        detailsPage.getAddbutton().click();

        Assert.assertTrue("Employee was created with invalid data", detailsPage.isDataInvalid(detailsPage.getEmployeeEmail()));
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

