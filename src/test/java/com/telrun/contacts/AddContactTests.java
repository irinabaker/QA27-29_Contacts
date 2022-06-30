package com.telrun.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginLinkPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else {
            login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        type(By.cssSelector("input:nth-child(1)"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        type(By.cssSelector("input:nth-child(3)"), "1234567" + i);
        type(By.cssSelector("input:nth-child(4)"), "adam" + i + "@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "torwart");
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
       Assert.assertTrue(isContactCreated("Karl"));
    }

}
