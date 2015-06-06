package com.example.home.labproject1;

/**
 * Created by home on 6/6/2015.
 */
public class StudentModel {

    String name,address,institution,email,phone;
    int id;

    public StudentModel(String name, String email, String phone, String address, String institution) {
        this.phone = phone;
        this.email = email;
        this.institution = institution;
        this.address = address;
        this.name = name;
    }


    public StudentModel() {
    }

    public StudentModel(String name, String address, String institution, String email, String phone, int id) {
        this.name = name;
        this.address = address;
        this.institution = institution;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
