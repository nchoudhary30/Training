package com.fareye.training.model;

import com.fareye.training.util.HashPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter @Setter @NoArgsConstructor
public class User {

    @NotNull
    int id;
//    @NotNull(message = "Firstname must not be null")
    private String firstname;
    private String lastname;
    private String avatar_url;
//    @NotNull(message = "Email must not be null") @Email(message = "must be a well-formed email address")
    private String email;
    private String role;
//    @NotNull(message = "Password must not be null")
    private String password;
//    Date created, modified=new Date();
//    boolean active, verified;

//    public void setPassword(String password){
//        this.password = HashPassword.hash(password);
////        this.password = password;
//    }


}
