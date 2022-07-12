package com.telrun.contacts.tests;

import com.telrun.contacts.models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }



    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver","Kan","12345678987","kan@gm.com","Berlin","goalkiper"});
        list.add(new Object[]{"Oliver","Kan","1234567123","kan+1@gm.com","Berlin","goalkiper"});
        list.add(new Object[]{"Oliver","Kan","1234567321","kan+2@gm.com","Berlin","goalkiper"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addContactPositiveTestFromDataProvider(String name, String sName, String phone,
                                                       String email, String address, String des) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(new Contact().setName(name)
                .setSureName(sName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(des));
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSureName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addNewContactFromCSV")
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().click(By.xpath("//a[contains(text(),'ADD')]"));
        app.getContact().fillContactForm(contact);
        app.getContact().clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @AfterMethod(enabled = false)
    public void postCondition() {
        app.getContact().removeContact();
    }

}
