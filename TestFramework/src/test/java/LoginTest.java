import Pages.LoginPage;
import Pages.Navigation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    private static final String EMPLOYEES_PAGE_CHECKPOINT = "http://cafetownsend-angular-rails.herokuapp.com/login";

    @Test
    public void testLogin() throws InterruptedException {
        LoginPage page = LoginPage.open();
        page.EnterUsername("Luke");
        page.EnterPassword("Skywalker");
        page.GetLoginButton().click();
        Assert.assertTrue("Was not able to login to application", page.isUserLoggedIn());
    }
    @Test
    public void testLoqout()  {
        LoginPage page = LoginPage.open();
        page.EnterUsername("Luke");
        page.EnterPassword("Skywalker");
        page.GetLoginButton().click();
        page.getLoginHeader().GetLogoutButton().click();
        Assert.assertFalse("Was not able to logout from application", page.isUserLoggedIn());
    }

    @Test
    public void testFailedLogin() throws InterruptedException {
        LoginPage page = LoginPage.open();
        page.EnterUsername("Luke");
        page.EnterPassword("123");
        page.GetLoginButton().click();
        Assert.assertTrue("Invalid username or password was accepted", page.getLoginHeader().checkLoggedGreetingsIsNotDisplayed());
    }

    @Test
    public void testFailedLoginWithEmptyData() throws InterruptedException {
        LoginPage page = LoginPage.open();
        page.EnterUsername("");
        page.EnterPassword("");
        page.GetLoginButton().click();
        Assert.assertTrue("Invalid username or password!", page.getLoginHeader().checkLoggedGreetingsIsNotDisplayed());
    }

    @Test
    public void testUnloggedUserCantSeeEmployeesList(){
        LoginPage page = LoginPage.open();
        page.openEmployeeListByUrl();

        Assert.assertTrue("Unlogged user is navigated to Employees list", EMPLOYEES_PAGE_CHECKPOINT.equals(Navigation.getDriver().getCurrentUrl()));

    }
    @After
    public void cleanUpDriver() {
        Navigation.quitDriver();
    }

}