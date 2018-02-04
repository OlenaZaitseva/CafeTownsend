package Pages;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static WebDriverWait createNew(){
        return new WebDriverWait(Navigation.getDriver(), Navigation.DEFAULT_TIMEOUT);
    }
}
