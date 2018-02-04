import Pages.EmployeeDetailsPage;
import Pages.EmployeesListPage;
import Pages.LoginPage;
import org.junit.Test;

public class CreateTest {

    @Test
    public void testCreate() {
        LoginPage page = new LoginPage();
        page.login("Luke", "Skywalker");
        EmployeesListPage list = new EmployeesListPage();
        list.getCreateButton().click();
        EmployeeDetailsPage employee = new EmployeeDetailsPage();
        employee.setFirstName("Mary");
        employee.setLastName("123");
        employee.setStartDate("2017-02-10");
        employee.setEmail("Lev@mail.com");
        employee.getAddbutton().click();
        list.getEmployee("Mary").click();
        list.getEditButton().click();
        employee.getBackbutton().doubleClick();
    }
    @Test
    public void testCreate2() {
        LoginPage page = new LoginPage();
        page.login("Luke", "Skywalker");
        EmployeesListPage list = new EmployeesListPage();
        list.getEmployee("Mary").click();
        list.getEditButton().click();
        EmployeeDetailsPage employee = new EmployeeDetailsPage();
        employee.getBackbutton().doubleClick();
    }
}
