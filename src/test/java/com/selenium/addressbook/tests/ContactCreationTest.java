package com.selenium.addressbook.tests;


import com.selenium.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().getContactList();
        app.contact().goToContactPage();
        File photo = new File("src/test/resources/Decart.jpg");
        app.contact().fillContactForm(new ContactData().withFirstname("Vasya").withLastname("Sirko")
                .withMobilePhone("380501234567").withEmail("vasyaSirko@gmail.com").withGroup("NEW1")
                .withPhoto(photo),true);
        app.contact().submitContactCreation();
        app.contact().gotoHome();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

//    for debugging before setting file path
//    @Test
//    public void testCurrentDir() {
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/Decart.jpg");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }
}
