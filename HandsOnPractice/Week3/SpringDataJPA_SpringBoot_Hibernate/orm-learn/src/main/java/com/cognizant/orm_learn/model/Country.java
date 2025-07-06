package com.cognizant.orm_learn.model;

import jakarta.persistence.*; // ✅ NEW Jakarta namespace

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
}
