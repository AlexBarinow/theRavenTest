package com.alex.spring.boot.theraventest.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created")
    private long created;

    @Column(name = "updated")
    private long Updated;


    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private boolean is_active;


    public Customer() {
    }

    public Customer(long created, long updated, String name,
                    String email, String phone, boolean is_active) {
        this.created = created;
        Updated = updated;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.is_active = is_active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return Updated;
    }

    public void setUpdated(long updated) {
        Updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String full_name) {
        this.name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
