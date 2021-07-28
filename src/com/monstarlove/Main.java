package com.monstarlove;


import com.monstarlove.database.Database;
import com.monstarlove.entities.Customer;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Database db = new Database(
//            new Customer("Sam", "sam@another", "09123")
//        );
//        db.insert();

//        Database db = new Database(new Customer());
//        db.delete(5);

        Database db = new Database(new Customer());
        List<Object> data = db.find(2);
        System.out.println("printing...");
        Iterator itr = data.iterator();
        while (itr.hasNext()) {
            Customer obj = (Customer) itr.next();
            System.out.println(obj);
        }

//        for(int i=0; i < data.size(); i++) {
//            Object obj = (String) data.get(i);
//            System.out.println(obj);
//        }
    }
}
