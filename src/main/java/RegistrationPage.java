package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Roman on 09.06.2017.
 */
public class RegistrationPage extends Page {

    public final String REG_PAGE_URL = "https://secure.bizibox.biz/#/signup";

    public final String EMPTY_FIELD_ERROR_MESSAGE = "מידע זה הינו מידע חובה";
    public final String CHECKBOX_ERROR_MESSAGE = "* יש לאשר את תנאי השימוש לפני המשך לשלב הבא";


    public final String NAME_SELECTOR = "//div[@class='mainSteps']//form//input[@type='text'][@name='uName']";
    public final String NAME_SUCCESS_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@type='text'][@name='uName']/following-sibling::i/img[@class='sucIcon']";
    public final String NAME_ERROR_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@type='text'][@name='uName']/following-sibling::i/img[@class='errorIcon']";
    public final String NAME_ERROR_SELECTOR = "//div[@class='mainSteps']//form//div[@ng-show='form.uName.$error.required']";

    public final String TELEPHONE_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uTel']";
    public final String TELEPHONE_SUCCESS_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uTel']/following-sibling::i/img[@class='sucIcon']";
    public final String TELEPHONE_ERROR_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uTel']/following-sibling::i/img[@class='errorIcon']";
    public final String TELEPHONE_ERROR_SELECTOR = "//div[@class='mainSteps']//form//div[@ng-show='form.uTel.$error.required']";

    public final String EMAIL_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uEmail']";
    public final String EMAIL_SUCCESS_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uEmail']/following-sibling::i/img[@class='sucIcon']";
    public final String EMAIL_ERROR_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uEmail']/following-sibling::i/img[@class='errorIcon']";
    public final String EMAIL_ERROR_SELECTOR = "//div[@class='mainSteps']//form//span[@ng-show='form.uEmail.$error.required']";

    public final String PASSWORD_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uPass']";
    public final String PASSWORD_SUCCESS_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uPass']/following-sibling::i/img[@class='sucIcon']";
    public final String PASSWORD_ERROR_ICON_SELECTOR = "//div[@class='mainSteps']//form//input[@name='uPass']/following-sibling::i/img[@class='errorIcon']";
    public final String PASSWORD_ERROR_SELECTOR = "//div[@class='mainSteps']//form//div[@ng-show='form.uPass.$error.required']";

    public final String SUBMIT_BUTTON = "//div[@class='mainSteps']//form//input[@type='submit']";
    public final String CHECKBOX = "//div[@class='mainSteps']//form//input[@id='checkbox1']";
    public final String CHECKBOX_ERROR_SELECTOR = "//div[@class='mainSteps']//form//div[@class='checksAppr']/div[@class='alertsAppr']/div";


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSubmitButton() {
        WebElement el = driver.findElement(By.xpath(SUBMIT_BUTTON));
        el.click();
    }


    // Is element displayed

    public boolean isNameErrorMessageDisplayed() {
        return isElementDisplayed(NAME_ERROR_SELECTOR);
    }

    public boolean isTelephoneErrorMessageDisplayed() {
        return isElementDisplayed(TELEPHONE_ERROR_SELECTOR);
    }

    public boolean isEmailErrorMessageDisplayed() {
        return isElementDisplayed(EMAIL_ERROR_SELECTOR);
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return isElementDisplayed(PASSWORD_ERROR_SELECTOR);
    }

    public boolean isCheckboxErrorMessageDisplayed() {
        return isElementDisplayed(CHECKBOX_ERROR_SELECTOR);
    }


    // Get Error messages

    public String getNameErrorMessage() {
        return getTextFromElement(NAME_ERROR_SELECTOR);
    }

    public String getTelephoneErrorMessage() {
       return getTextFromElement(TELEPHONE_ERROR_SELECTOR);
    }

    public String getEmailErrorMessage() {
        return getTextFromElement(EMAIL_ERROR_SELECTOR);
    }

    public String getPasswordErrorMessage() {
        return getTextFromElement(PASSWORD_ERROR_SELECTOR);
    }

    public  String getCheckboxErrorMessage(){
        return getTextFromElement(CHECKBOX_ERROR_SELECTOR);
    }



    // Field fields

    public void fillNameField(String name) {
       sendKeysToField(NAME_SELECTOR, name);
    }

    public void fillTelephone(String tel) {
        sendKeysToField(TELEPHONE_SELECTOR, tel);
    }

    public void fillEmailField(String email) {
        sendKeysToField(EMAIL_SELECTOR, email);
    }

    public void fillPassField(String password) {
        sendKeysToField(PASSWORD_SELECTOR, password);
    }


    // Checkbox actions

    public void uncheckCheckbox() {
        WebElement el = driver.findElement(By.xpath(CHECKBOX));
        if(el.isSelected()) {
            el.click();
        }
    }

    public boolean isNameSuccessIconDisplayed() {
        return isElementDisplayed(NAME_SUCCESS_ICON_SELECTOR);
    }

    public boolean isTelephoneSuccessIconDisplayed() {
        return isElementDisplayed(TELEPHONE_SUCCESS_ICON_SELECTOR);
    }

    public boolean isEmailSuccessIconDisplayed() {
        return isElementDisplayed(EMAIL_SUCCESS_ICON_SELECTOR);
    }

    public boolean isPasswordSuccessIconDisplayed() {
        return isElementDisplayed(PASSWORD_SUCCESS_ICON_SELECTOR);
    }

    public boolean isNameErrorIconDisplayed() {
        return isElementDisplayed(NAME_ERROR_ICON_SELECTOR);
    }

    public boolean isTelephoneErrorIconDisplayed() {
        return isElementDisplayed(TELEPHONE_ERROR_ICON_SELECTOR);
    }

    public boolean isEmailErrorIconDisplayed() {
        return isElementDisplayed(EMAIL_ERROR_ICON_SELECTOR);
    }

    public boolean isPasswordErrorIconDisplayed() {
        return isElementDisplayed(PASSWORD_ERROR_ICON_SELECTOR);
    }
}
