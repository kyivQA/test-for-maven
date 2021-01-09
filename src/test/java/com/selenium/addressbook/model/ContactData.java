package com.selenium.addressbook.model;

import java.util.Objects;

public class ContactData {

    private final String firstname;
    private final String lastname;
    private final String phoneMobile;
    private final String email;
    private final String group;

    public ContactData(String firstname, String lastname, String phone_mobile,
                       String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneMobile = phone_mobile;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(phoneMobile, that.phoneMobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, phoneMobile);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
