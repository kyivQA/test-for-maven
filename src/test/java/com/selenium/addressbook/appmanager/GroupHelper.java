package com.selenium.addressbook.appmanager;

import com.selenium.addressbook.model.GroupData;
import com.selenium.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);

    }

    public void returnToGroupPage() {

        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {

        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {

        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {

        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {

        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initEditGroup() {
        click(By.name("edit"));
    }

    public void initUpdateData() {
        driver.findElement(By.name("update")).click();
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initEditGroup();
        fillGroupForm(group);
        initUpdateData();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return driver.findElements(By.className("group")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

}
