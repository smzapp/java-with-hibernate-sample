package com.monstarlove;


import com.monstarlove.database.Database;
import com.monstarlove.entities.Customer;

public class Main {
    public static void main(String[] args) {
//        Database db = new Database(
//            new Customer("Sam", "sam@another", "09123")
//        );
//        db.insert();
        Database db = new Database(new Customer());
        db.delete(5);
    }
}
