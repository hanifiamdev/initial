package com.hanifiamdev.initial.Entity;


import javax.validation.constraints.Email;

public class Username {

    private String Name;
    private String Address;

    @Email(message = "Invalid Email")
    private String email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
