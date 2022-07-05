package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        addContact();
        Assert.assertTrue(isContactCreated("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }

}
