package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
        classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {

//    @Test
//    void TwoPlusTwo() {
//        UserController userController = new UserController();
//        assertEquals(8, userController.add(3,5));
//    }

    @Test
    void addUserTest(){
        User user=new User();
        RestTemplate restTemplate = new RestTemplate();
        user.setId(3124);
        user.setFirstname("Nikhil");
        user.setLastname("Choudhary");
        user.setPassword("password");
        User u= restTemplate.postForObject("http://localhost:8081/user",user, User.class);
        assertEquals(user.getFirstname(), u.getFirstname());
    }

    @Test
    void getUserTest(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/user", HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
//        assertEquals(response.getStatusCode().toString(), "************************************");
    }

    @Test
    void deleteUserTest(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/user/"+123, HttpMethod.DELETE, entity, String.class);

        System.out.println(response.getBody());
    }

    @Test
    void updateUserTest(){
        RestTemplate restTemplate=new RestTemplate();

        User user=new User();
        user.setFirstname("Ganesh");

        HttpEntity<User> entity = new HttpEntity<>(user);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/user/"+123, HttpMethod.PUT, entity, String.class);

        System.out.println(response.getBody());
    }


}
