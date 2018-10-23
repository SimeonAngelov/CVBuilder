package com.cvworld.model;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicInfo {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne//(mappedBy = "basicInfo")
    @JoinColumn(name = "basicInfo_address_id")
    private Address address;
    private String site;
}
