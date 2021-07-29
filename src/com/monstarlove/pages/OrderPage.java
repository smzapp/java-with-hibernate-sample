package com.monstarlove.pages;

import com.monstarlove.Main;
import com.monstarlove.dao.CustomerDao;
import com.monstarlove.dao.OrderDao;

import java.util.Scanner;

public class OrderPage {

    public OrderPage() {
        super();
        showSwitch();
    }

    public static void showSwitch()
    {
        Scanner scanner = new Scanner(System.in);
        OrderDao order = new OrderDao();
        showOptions();
        boolean gotoMain = false;
        System.out.println("\n\nEnter your choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                order.addOrder();
                break;
            case 2:
                order.updateStatus();
                break;
            case 3:
                order.deleteOrder();
                break;
            case 4:
                order.displayAll();
                break;
            case 5:
                order.searchByStatus();
                break;
            case 6:
                Main.chooseAction();
                gotoMain = true;
                break;
        }
        if (!gotoMain)
            OrderPage.showSwitch();
    }
    public static void showOptions()
    {
        System.out.println("\n----------- Order Page -----------");
        System.out.println("1 - Order a product");
        System.out.println("2 - Update Order status");
        System.out.println("3 - Delete an Order");
        System.out.println("4 - View orders");
        System.out.println("5 - Search Order by Status");
        System.out.println("6 - Go Back to Pages");
    }
}
