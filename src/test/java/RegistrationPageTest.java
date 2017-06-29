package test.java;

import main.java.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Roman on 09.06.2017.
 */
public class RegistrationPageTest {

    private RegistrationPage regPage;
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        regPage = new RegistrationPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void openPage(){
        driver.get(regPage.REG_PAGE_URL);
    }

    @Test(groups = {"groupTestForField", "positive"})
    public void positiveNameFieldTest(){
        String value = "Tony Brginsky";
        regPage.fillNameField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isNameSuccessIconDisplayed(), "The valid Name value " + value + " is not accepted!\n");
    }

    @Test(groups = {"groupTestForField", "positive"})
    public void positiveTelephoneFieldTest(){
        String value = "0537567672";
        regPage.fillTelephone(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isTelephoneSuccessIconDisplayed(), "The valid Telephone value " + value + " is not accepted!\n");
    }

    @Test(groups = {"groupTestForField", "positive"})
    public void positiveEmailFieldTest(){
        String value = "testbizi@yop.mail";
        regPage.fillEmailField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isEmailSuccessIconDisplayed(), "The valid Email value " + value + " is not accepted!\n");
    }

    @Test(groups = {"groupTestForField", "positive"})
    public void positivePasswordFieldTest(){
        String value = "oritury4r";
        regPage.fillPassField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isPasswordSuccessIconDisplayed(), "The valid Password value " + value + " is not accepted!\n");
    }

    @Test(groups = {"groupTestForField", "negative"}, dependsOnGroups = {"positive"})
    public void negativeNameFieldTest(){
        String value = "11 11";
        regPage.fillNameField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isNameErrorIconDisplayed(), "The invalid Name value " + value + " is accepted!\n");
    }

    @Test(groups = {"groupTestForField", "negative"}, dependsOnGroups = {"positive"})
    public void negativeTelephoneFieldTest(){
        String value = "0fhgjkffu";
        regPage.fillTelephone(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isTelephoneErrorIconDisplayed(), "The invalid Telephone value " + value + " is accepted!\n");
    }

    @Test(groups = {"groupTestForField", "negative"}, dependsOnGroups = {"positive"})
    public void negativeEmailFieldTest(){
        String value = "teueu.com";
        regPage.fillEmailField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isEmailErrorIconDisplayed(), "The invalid Email value " + value + " is accepted!\n");
    }

    @Test(groups = {"groupTestForField", "negative"}, dependsOnGroups = {"positive"})
    public void negativePasswordFieldTest(){
        String value = "123hdt";
        regPage.fillPassField(value);
        regPage.clickOnSubmitButton();
        Assert.assertTrue(regPage.isPasswordErrorIconDisplayed(), "The invalid Password value " + value + " is accepted!\n");
    }

    @Test
    public void checkMessagesWhenAllFieldsEmpty(){
        regPage.clickOnSubmitButton();
        regPage.waitFor(2000);

        Assert.assertTrue(regPage.isNameErrorMessageDisplayed(), "Name error message element is not found");
        Assert.assertEquals(regPage.getNameErrorMessage(), regPage.EMPTY_FIELD_ERROR_MESSAGE, "Wrong message for Name field");

        Assert.assertTrue(regPage.isTelephoneErrorMessageDisplayed(), "Telephone error message element is not found");
        Assert.assertEquals(regPage.getTelephoneErrorMessage(), regPage.EMPTY_FIELD_ERROR_MESSAGE, "Wrong message for Telephone field");

        Assert.assertTrue(regPage.isEmailErrorMessageDisplayed(), "Email error message element is not found");
        Assert.assertEquals(regPage.getEmailErrorMessage(), regPage.EMPTY_FIELD_ERROR_MESSAGE, "Wrong message for Email field");

        Assert.assertTrue(regPage.isPasswordErrorMessageDisplayed(), "Password error message element is not found");
        Assert.assertEquals(regPage.getPasswordErrorMessage(), regPage.EMPTY_FIELD_ERROR_MESSAGE, "Wrong message for Password field");
    }

    @Test
    public void checkboxErrorMessageTest(){
        regPage.fillNameField("Roza Gofman");
        regPage.fillTelephone("0534565858");
        regPage.fillEmailField("test@yop.mail");
        regPage.fillPassField("oitrye7d6");
        regPage.waitFor(2000);
        regPage.uncheckCheckbox();
        regPage.waitFor(1000);
        regPage.clickOnSubmitButton();
        regPage.waitFor(1000);
        Assert.assertTrue(regPage.isCheckboxErrorMessageDisplayed(), "Checkbox error message element is not found");
        Assert.assertEquals(regPage.getCheckboxErrorMessage(), regPage.CHECKBOX_ERROR_MESSAGE, "Wrong message for Checkbox");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}

