package com.selenium.addressbook.tests;

import com.selenium.addressbook.model.GroupData;
import com.selenium.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData()
                    .withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testModificationGroup() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withName("NEW1").withHeader("NEW2").withFooter("NEW3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}
