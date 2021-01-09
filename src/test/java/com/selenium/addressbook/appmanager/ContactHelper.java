package com.selenium.addressbook.appmanager;

import com.selenium.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public void goToContactPage() {
        driver.findElement(By.linkText("ADD_NEW")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {

        click(By.name("submit"));
    }

        public void initUpdateData() {
        driver.findElement(By.name("update")).click();
    }

    public void selectContact(int index ) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void editContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void gotoHome() {

        driver.findElement(By.linkText("HOME"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("selected[]"));
        for (WebElement element: elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
