package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomSection {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    @ManyToOne
    private CV cv;
}
