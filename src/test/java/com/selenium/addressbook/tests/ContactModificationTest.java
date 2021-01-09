package com.selenium.addressbook.tests;

import com.selenium.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (! app.contact().isThereAContact()) {
            app.contact().goToContactPage();
            app.contact().fillContactForm(new ContactData("Vasya", "Sirko",
                    "380501234567", "vasyaSirko@gmail.com", "NEW1"), true);
            app.contact().submitContactCreation();
        }
    }

    @Test(enabled = false)
    public void modifyContact() {
        int before = app.contact().getContactCount();
        app.contact().gotoHome();
        app.contact().editContact();
        app.contact().fillContactForm(new ContactData(
                "VasyaNEW", "SirkoNEW", "380670987653",
                "new_sirko@mail.com", null), false);
        app.contact().initUpdateData();
        int after = app.contact().getContactCount();
        Assert.assertEquals(after, before);


    }
}
