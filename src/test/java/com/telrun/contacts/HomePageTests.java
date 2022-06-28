package com.telrun.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        System.out.println("Site opened!!!");
        //verify to displayed Home Component form
//        isComponentFormPresent();
//        System.out.println("Component Form: " + isComponentFormPresent());

      //  isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
    }

}
