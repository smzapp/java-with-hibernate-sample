package com.monstarlove;


import com.monstarlove.database.Database;
import com.monstarlove.entities.Customer;
import com.monstarlove.pages.CustomerPage;
import com.monstarlove.pages.OrderPage;
import com.monstarlove.pages.ProductPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Database db = new Database(
//            new Customer("Sam", "sam@another", "09123")
//        );
//        db.insert();

//        Database db = new Database(new Customer());
//        db.delete(5);

//        Database db = new Database(new Customer());
//        List<Object> data = db.find(2);
//        System.out.println("printing...");
//        Iterator itr = data.iterator();
//        while (itr.hasNext()) {
//            Customer obj = (Customer) itr.next();
//            System.out.println(obj);
//        }
//        for(int i=0; i < data.size(); i++) {
//            Object obj = (String) data.get(i);
//            System.out.println(obj);
//        }

//        CategoryDao cat = new CategoryDao();
//        List<Category> category = cat.getResult();
//        for (int i=0; i < category.size(); i++) {
//            System.out.println(category.get(i).getName());
//        }
        chooseAction();
    }

    public static void chooseAction()
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        new OrderPage();
//        new CustomerPage();
//        new ProductPage();
//        options();
//        while (!quit) {
//            System.out.println("Enter your choice: ");
//            int input = scanner.nextInt();
//            switch (input) {
//                case 1:
//                    new ProductPage();
//                    break;
//                case 2:
//                    new CustomerPage();
//                    break;
//                case 4:
//                    quit = true;
//                    break;
//            }
//        }
    }

    public static void options()
    {
        System.out.println("--------- Pages ------");
        System.out.println("1 - Products");
        System.out.println("2 - Orders");
        System.out.println("3 - Customers");
        System.out.println("4 - Quit");
    }
}
