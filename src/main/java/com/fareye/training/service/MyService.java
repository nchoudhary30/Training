package com.fareye.training.service;

import com.fareye.training.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private Item item;

    public void printItem(){
        System.out.println(item.to_string());
    }
}
