package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CV extends BasicProfileInfo{
    @ManyToOne
    private User user;

    //TODO lastedit
}
