package com.cvworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private int skillId;
    private String name;
    @ManyToOne
    private BasicProfileInfo basicInfo;
    private int level;

}
