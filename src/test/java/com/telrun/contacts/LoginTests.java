package com.telrun.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
    }

    @Test
    public void loginUserPositiveTest() {
        //click on Login link
        app.getUser().login();
        //assert the button SignOut
        Assert.assertTrue(app.isSignOutButtonPresent());
    }

}
