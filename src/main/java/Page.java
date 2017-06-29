package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Roman on 09.06.2017.
 */
public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void waitFor(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementDisplayed(String selector) {
        WebElement el = driver.findElement(By.xpath(selector));
        return el.isDisplayed();
    }

    public String getTextFromElement(String selector) {
        WebElement el = driver.findElement(By.xpath(selector));
        return el.getText();
    }

    public void sendKeysToField(String selector, String text){
        WebElement el = driver.findElement(By.xpath(selector));
        String tx = el.getAttribute("value");
        if(!tx.isEmpty()){
            el.clear();
        }
        el.sendKeys(text);
    }
}
