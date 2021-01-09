package com.selenium.addressbook.tests;

import com.selenium.addressbook.model.GroupData;
import com.selenium.addressbook.model.Groups;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2").withHeader("test2").withFooter("test2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(
                group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
    }

}
