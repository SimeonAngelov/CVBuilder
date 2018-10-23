package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Experience {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private BasicProfileInfo basicProfileInfo;
    private String company;
    private String position;
    private String responsibilities;
    private Date startingAt;
    private Date endingAt;
}
