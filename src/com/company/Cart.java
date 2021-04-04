package com.company;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> itemList;

    public Cart() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public void updateItemCount(Item item, int newCount) {
        int index = itemList.indexOf(item);
        itemList.get(index).updateCount(newCount);
    }

    public void checkout() {
        itemList.clear();
    }
}
