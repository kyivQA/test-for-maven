package com.selenium.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {

    private String firstname;
    private String lastname;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String email;
    private String group;
    private File photo;
    //private int id;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


    public ContactData(String firstname, String lastname, String phone_mobile,
                       String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilePhone = phone_mobile;
        this.email = email;
        this.group = group;
    }

    public ContactData() {

    }

//    public ContactData withId(int id) {
//        this.id = id;
//        return this;
//    }

    public String getFirstname() {

        return firstname;
    }

    public String getLastname() {

        return lastname;
    }


    public String getEmail() {

        return email;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, mobilePhone);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneMobile='" + mobilePhone + '\'' +
                '}';
    }

}
