package com.cvworld.model;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public abstract class BasicProfileInfo extends BasicInfo{
    private String middleName;
    private String familyName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String linkedIn;
    private String github;
    private String objective;

}
