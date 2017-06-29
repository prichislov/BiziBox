package test.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class UrbanerTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void UrbanerTest() {
        wd.get("https://www.urbanr.com/");
        wd.findElement(By.cssSelector("a.mouse.clickable")).click();
        wd.findElement(By.linkText("Apply Online")).click();
        wd.findElement(By.cssSelector("button.butt.butt-white")).click();
        wd.findElement(By.name("signupFirstName")).click();
        wd.findElement(By.name("signupFirstName")).clear();
        wd.findElement(By.name("signupFirstName")).sendKeys("urbanrTest");
        wd.findElement(By.name("signupLastName")).click();
        wd.findElement(By.name("signupLastName")).clear();
        wd.findElement(By.name("signupLastName")).sendKeys("urbanrTest");
        wd.findElement(By.name("signupEmail")).click();
        wd.findElement(By.name("signupEmail")).clear();
        wd.findElement(By.name("signupEmail")).sendKeys("urbanr@yopmail.com");
        wd.findElement(By.id("signupPassword")).click();
        wd.findElement(By.id("signupPassword")).clear();
        wd.findElement(By.id("signupPassword")).sendKeys("12345678");
        wd.findElement(By.name("signupReEnterPassword")).click();
        wd.findElement(By.name("signupReEnterPassword")).clear();
        wd.findElement(By.name("signupReEnterPassword")).sendKeys("12345678");
        if (!wd.findElement(By.id("i-agree-signup")).isSelected()) {
            wd.findElement(By.id("i-agree-signup")).click();
        }
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
