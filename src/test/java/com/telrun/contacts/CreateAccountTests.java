package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void registrationPositiveTest() {
        //click on the link LOGIN
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        //fill registration form
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("jesse+982@mail.ru");
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Jesse_12345");
    }


    //click on the button Registration
    //assert the button Sign out displayed
}
