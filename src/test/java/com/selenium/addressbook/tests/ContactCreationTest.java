package com.selenium.addressbook.tests;


import com.selenium.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test(enabled = false)
    public void testContactCreation() {
        List<ContactData> before = app.contact().getContactList();
        //int before = app.getContactHelper().getContactCount();
        app.contact().goToContactPage();
        app.contact().fillContactForm(new ContactData("Vasya", "Sirko",
                "380501234567", "vasyaSirko@gmail.com", "NEW1"), true);
        app.contact().submitContactCreation();
        app.contact().gotoHome();
        List<ContactData> after = app.contact().getContactList();
        //int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
