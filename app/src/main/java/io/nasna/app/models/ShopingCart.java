package io.nasna.app.models;

import android.content.Context;

public class ShopingCart {
    private  String itemName;
    private int price,cost;
    private Context context;
    public ShopingCart(String itemName, int price, int cost) {
        this.itemName = itemName;
        this.price = price;
        this.cost = cost;
      //  this.context = context;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
