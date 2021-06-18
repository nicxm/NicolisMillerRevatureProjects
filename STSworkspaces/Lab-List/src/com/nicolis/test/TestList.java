package com.nicolis.test;
import com.nicolis.datastructures.List;

public class TestList {

    public static void main(String[] args) {
        List list = new List();
        list.set(0, "Apple");

        System.out.println(list.get(0));
   
        int index = list.add("Banana");

        System.out.println(index);
        System.out.println(list.get(index));

        list.add("Canteloupe");
        list.add("Dragonfruit");
        list.add("Elderberry");
        list.add("Fig");
        list.add("Grape");
        list.add("Honeyberry");
        list.add("Jujube");

        String value = list.remove();
        System.out.println(value);

        value = list.remove();
        System.out.println(value);
    }
}