package com.selenium.addressbook.tests;


import com.selenium.addressbook.model.ContactData;
import com.selenium.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                ("src/test/resources/contacts.csv"));
        String line = reader.readLine();
        while(line != null) {
            String [] split = line.split(";");
            list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1])
                    .withMobilePhone(split[2]).withEmail(split[3]).withGroup(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        List<ContactData> before = app.contact().getContactList();
        app.contact().goToContactPage();
        //File photo = new File("src/test/resources/Decart.jpg");
        app.contact().create(contact);
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
