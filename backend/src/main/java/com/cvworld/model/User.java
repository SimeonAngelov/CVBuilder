package com.cvworld.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User  extends BasicProfileInfo{
//    @ManyToOne
//

@Id
        @GeneratedValue
    int id;
        @NotNull
    @NotEmpty
    private String first_Name;

    private String role;

        @NotNull
        @NotEmpty
        private String lastName;

        @NotNull
        @Size(min=2, max=30)
        @NotEmpty
        private String password;

        private String matchingPassword;
        @NotNull
        @Email
        @NotEmpty
        @Column(unique = true)
       private   String email;



//    public FieldOfWork getFieldOfWork() {
//        return fieldOfWork;
//    }
//
//    public void setFieldOfWork(FieldOfWork fieldOfWork) {
//        this.fieldOfWork = fieldOfWork;
//    }

    public Integer  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String firstName) {
        this.first_Name = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    //TODO regdate

}
