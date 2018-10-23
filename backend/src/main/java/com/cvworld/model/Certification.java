package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certification {
    @Id
    @GeneratedValue
    private int certificationId;
    private String name;
    private String level;
    @ManyToOne
    private BasicInfo basicInfo;
}
