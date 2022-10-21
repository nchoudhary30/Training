package com.fareye.training.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
    private Integer itemCode;
    private String itemName;

    public Item(Integer itemCode, String itemName) {
    }

    public String to_string() {
        return ("itemcode"+ itemCode);
    }
}
