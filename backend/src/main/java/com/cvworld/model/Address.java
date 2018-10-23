package com.cvworld.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int addressId;
    @OneToOne(mappedBy = "address")
    private BasicInfo basicInfo;
    private String city;
    private String streeNumber;
    @ManyToOne
    private Country country;
}
