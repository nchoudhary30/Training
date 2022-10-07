package com.fareye.training.model;

import com.fareye.training.util.HashPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class User {
    @NotNull
    private String firstname;
    private String lastname;
    @NotNull
    private String email;
    private String role;
    @NotNull
    private String password;
    Date created, modified=new Date();
    boolean active, verified;

    public void setPassword(String password){
        this.password = HashPassword.hash(password);
    }


}
