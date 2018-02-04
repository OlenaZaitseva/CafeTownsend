package Pages;

import components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeDetailsPage {
 private static final By FIRSTNAME_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.firstName']");
 private static final By LASTNAME_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.lastName']");
 private static final By STARTDATE_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.startDate']");
 private static final By EMAIL_LOCATOR = By.cssSelector("input[ng-model='selectedEmployee.email']");
 private static final By ADD_BUTTON_LOCATOR = By.cssSelector("button[type='submit']:not(.ng-hide)");
 private static final By CANCEL_BUTTON_LOCATOR = By.className("subButton bCancel");
 private static final By DELETE_BUTTON_LOCATOR = By.xpath("//p[text()='Delete']");
 private static final By UPDATE_BUTTON_LOCATOR = By.cssSelector("//button[text()='Update']");
 private static final By BACK_BUTTON_LOCATOR = By.className("subButton bBack");

public void setFirstName(String firstName){
 WebElement element = Navigation.getDriver().findElement(FIRSTNAME_LOCATOR);
 element.sendKeys(firstName);
}
 public void setLastName(String lastName){
  WebElement element = Navigation.getDriver().findElement(LASTNAME_LOCATOR);
  element.sendKeys(lastName);
 }
 public void setStartDate(String startDate){
  WebElement element = Navigation.getDriver().findElement(STARTDATE_LOCATOR);
  element.sendKeys(startDate);
 }
 public void setEmail(String email){
  WebElement element = Navigation.getDriver().findElement(EMAIL_LOCATOR);
  element.sendKeys(email);
 }

 public Button getAddbutton(){
  WebElement element = Navigation.getDriver().findElement(ADD_BUTTON_LOCATOR);
  return new Button(element);
 }
 public Button getCancelbutton(){
  WebElement element = Navigation.getDriver().findElement(CANCEL_BUTTON_LOCATOR);
  return new Button(element);
 }

 public Button getDeletebutton() {
  WebElement element = Navigation.getDriver().findElement(DELETE_BUTTON_LOCATOR);
  return new Button(element);
 }
 public Button getUpdatebutton() {
  WebElement element = Navigation.getDriver().findElement(UPDATE_BUTTON_LOCATOR);
  return new Button(element);
 }
 public Button getBackbutton() {
  WebElement element = Navigation.getDriver().findElement(BACK_BUTTON_LOCATOR);
  return new Button(element);
 }
}
