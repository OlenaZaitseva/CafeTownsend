import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginTest.class,
        CreateTest.class,
        EditTest.class,
        DeleteTest.class
})
public class CafeTownsendTestSuite {
}
