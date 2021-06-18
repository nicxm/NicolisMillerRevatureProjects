package com.nicolis.test;
import java.util.ArrayList;
import com.nicolis.model.Item;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        
        items.add(new Item(1, "This is item 1"));
        items.add(new Item(2, "This is item 2"));
        items.add(new Item(3, "This is item 3"));
        items.add(new Item(4, "This is item 4"));
        items.add(new Item(5, "This is item 5"));

        System.out.println(items.get(2));

       Item removed = items.remove(items.size()-1);
       System.out.println(removed);
    }
}