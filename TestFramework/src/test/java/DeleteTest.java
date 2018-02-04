import Pages.EmployeeDetailsPage;
import Pages.EmployeesListPage;
import Pages.LoginPage;
import Pages.Navigation;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;

public class DeleteTest {
    private CreateTest createTestSteps = new CreateTest();

    @Test
    public void testDeleteEmployee() {
        String userName = RandomStringUtils.randomAlphabetic(10);
        createTestSteps.createNewEmployee(userName, "test", "2012-12-12", "123@mail.com");
        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userName).click();
        employeelist.getDeleteButton().click();

        Navigation.getDriver().switchTo()
                .alert()
                .accept();
        Navigation.waitAngularLoaded();

        //Test is failing due to the error in application. There is a bug
        Assert.assertFalse("Employee was not deleted", employeelist.isEmployeeFound(userName));
    }

    @Test
    public void testDeleteEmployeeViaEditPage() {
        String userName = RandomStringUtils.randomAlphabetic(10);

        createTestSteps.createNewEmployee(userName, "test", "2012-12-12", "123@mail.com");

        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userName).click();
        employeelist.getEditButton().click();
        EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage();
        employeeDetailsPage.getDeletebutton().click();

        Navigation.getDriver().switchTo()
                .alert()
                .accept();
        Navigation.waitAngularLoaded();

        Assert.assertFalse("EmployeeListItem was not deleted", employeelist.isEmployeeFound(userName));
    }

    @Test
    public void testCancelDeleteEmployee() {
        String userName = RandomStringUtils.randomAlphabetic(10);

        createTestSteps.createNewEmployee(userName, "test", "2012-12-12", "123@mail.com");

        EmployeesListPage employeelist = new EmployeesListPage();
        employeelist.getEmployee(userName).click();
        employeelist.getEditButton().click();
        EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage();
        employeeDetailsPage.getDeletebutton().click();

        Navigation.getDriver().switchTo().alert().dismiss();
        Navigation.waitAngularLoaded();
        employeeDetailsPage.getBackbutton().click();
        Assert.assertTrue("EmployeeListItem was not deleted", employeelist.isEmployeeFound(userName));
    }

    @After
    public void cleanUpDriver() {
        Navigation.quitDriver();
    }

    @Before
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Luke", "Skywalker");
    }
}
