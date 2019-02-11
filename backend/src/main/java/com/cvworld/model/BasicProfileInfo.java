package com.cvworld.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public abstract class BasicProfileInfo extends BasicInfo{
   // private String middleName;
  //  private String familyName;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String phoneNumber;
    //private String email;
    private String linkedIn;
    private String github;
    private String objective;

 public Date getBirthDate() {
  return birthDate;
 }

 public void setBirthDate(Date birthDate) {
  this.birthDate = birthDate;
 }

 public String getPhoneNumber() {
  return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
  this.phoneNumber = phoneNumber;
 }

 public String getLinkedIn() {
  return linkedIn;
 }

 public void setLinkedIn(String linkedIn) {
  this.linkedIn = linkedIn;
 }

 public String getGithub() {
  return github;
 }

 public void setGithub(String github) {
  this.github = github;
 }

 public String getObjective() {
  return objective;
 }

 public void setObjective(String objective) {
  this.objective = objective;
 }
}
