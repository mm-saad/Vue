package com.vuejs.domain.users;

import com.vuejs.domain.BaseEntity;
import com.vuejs.dto.users.UsersDescription;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by NBE3663 on 27/06/2017.
 */
public class Users extends BaseEntity {

    @NotNull
    @Size (min = 3, max = 20)
    @Pattern(regexp = UsersDescription.Regex.FIRST_NAME + "*")

    String firstName;

    @NotNull
    @Size (min = 3, max = 20)
    @Pattern(regexp = UsersDescription.Regex.LAST_NAME + "*")
    String lastName;

    @NotNull
    @Email
    @Column(unique = true, nullable = false)
    String email;

    @NotNull
    @Column(unique = true, nullable = false)
    String adresse;

    public Users() {
        super();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
