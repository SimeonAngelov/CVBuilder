package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hobby {
    @Id
    @GeneratedValue
    private int hobbyID;
    private String name;
    @ManyToOne
    private BasicProfileInfo basicInfo;
}
