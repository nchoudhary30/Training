package com.fareye.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class PropertyController {
    List<String> keys = new ArrayList<>();

    @Autowired
    private Environment env;

    @GetMapping("/property")
    public List<String> print(){
        if(keys.size()==0)
        readFile();
        List<String> prop= new ArrayList<>();
        for(String k:keys){
            prop.add(k + " : " + env.getProperty(k));
        }

        return prop;
    }

//    @GetMapping("/property")
    public void readFile(){
        File file = new File("src/main/resources/application.properties");
        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(sc.hasNextLine()){
            String str=sc.nextLine();
            String[] arr = str.split("=");
            keys.add(arr[0]);
//            System.out.println(str);
        }
    }


}
