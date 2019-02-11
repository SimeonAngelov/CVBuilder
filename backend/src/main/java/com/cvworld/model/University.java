package com.cvworld.model;

import javax.persistence.Entity;

@Entity
public class University extends EducationalFacility{
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
