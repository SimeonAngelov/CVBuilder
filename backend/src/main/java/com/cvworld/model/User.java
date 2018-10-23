package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User  extends BasicProfileInfo{
    @ManyToOne
    private FieldOfWork fieldOfWork;
    //TODO regdate
}
