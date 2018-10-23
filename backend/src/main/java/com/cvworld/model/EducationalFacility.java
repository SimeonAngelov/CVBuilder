package com.cvworld.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public abstract class EducationalFacility extends BasicInfo{
    private String description;
    private Date startDate;
    private Date endDate;
    private String website;
    private String spetialization;
}
