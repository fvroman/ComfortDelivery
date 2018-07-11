package com.comfortdelivery.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "village")
    private String village;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer",
               cascade = {CascadeType.ALL})
    private List<Order> orders;

    public Customer() {
        this.setAddress("Введите Адрес");
        this.setEmail("Введите e-mail");
        this.setFullName("Ваше ФИО");
        this.setPhoneNumber("Ваш номер телефона");
        this.setVillage("chunoyar");
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
