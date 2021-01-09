package com.selenium.addressbook.tests;

import com.selenium.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class ContactDeletionTest extends TestBase{

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
    public void testContactDeletion() {
        List<ContactData> before = app.contact().getContactList();
        //int before = app.getContactHelper().getContactCount();
        app.contact().gotoHome();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContact();
        List<ContactData> after = app.contact().getContactList();
        //int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
