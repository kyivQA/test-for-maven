package com.selenium.addressbook.appmanager;

import com.selenium.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());

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

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void editContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a"));
        //click(By.cssSelector(String.format("a[href='edit.php?id=%s']", id)));
    }

    private void initContactModificationById(int id) {
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", id)));
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
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }

//    public Set<ContactData> all() {
//        Set<ContactData> contacts = new HashSet<>();
//        List<WebElement> rows = driver.findElements(By.name("entry"));
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
//            String lastname = cells.get(1).getText();
//            String firstname = cells.get(2).getText();
//            String[] phones = cells.get(5).getText().split("\n");
//            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
//                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
//
//            return contacts;
//        }
//
//
//        public ContactData infoFromEditForm (ContactData contact){
//            initContactModificationById(contact.getId);
//            String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
//            String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
//            String home = driver.findElement(By.name("home")).getAttribute("value");
//            String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
//            String work = driver.findElement(By.name("work")).getAttribute("value");
//            driver.navigate().back();
//            return new ContactData().withId(contact.getId())
//                    .withFirstname(firstname).withLastname(lastname).withHomePhone(home)
//                    .withMobilePhone(mobile).withWorkPhone(work);
//        }
    //}
}