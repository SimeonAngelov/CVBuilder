package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FieldOfWork {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
