package com.cvworld.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User  extends BasicProfileInfo{
//    @ManyToOne
//

        int id;
        @NotNull
        @NotEmpty
        private String firstName;

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
        public  String email;


//    public FieldOfWork getFieldOfWork() {
//        return fieldOfWork;
//    }
//
//    public void setFieldOfWork(FieldOfWork fieldOfWork) {
//        this.fieldOfWork = fieldOfWork;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
//TODO regdate
}
