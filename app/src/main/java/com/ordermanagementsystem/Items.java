package com.ordermanagementsystem;

public class Items {
    private int id;
    private String itemName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Items(int id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }
}
