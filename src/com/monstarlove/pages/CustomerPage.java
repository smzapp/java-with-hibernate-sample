package com.monstarlove.pages;

import com.monstarlove.Main;
import com.monstarlove.dao.CustomerDao;
import com.monstarlove.dao.ProductDao;

import java.util.Scanner;

public class CustomerPage {

    public CustomerPage() {
        super();
        showSwitch();
    }

    public static void showSwitch()
    {
        Scanner scanner = new Scanner(System.in);
        CustomerDao cust = new CustomerDao();
        boolean gotoMain = false;
        showOptions();
        System.out.println("\n\nEnter your choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                cust.addCustomer();
                break;
            case 2:
                cust.update();
                break;
            case 3:
                cust.deleteCustomer();
                break;
            case 4:
                Main.chooseAction();
                gotoMain = true;
                break;
        }
        if (!gotoMain)
            CustomerPage.showSwitch();
    }
    public static void showOptions()
    {
        System.out.println("\n----------- Customer Page -----------");
        System.out.println("1 - Add Customer");
        System.out.println("2 - Update Customer Information");
        System.out.println("3 - Delete Customer");
        System.out.println("4 - Go Back to Pages");
    }
}
