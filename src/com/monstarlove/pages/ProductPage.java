package com.monstarlove.pages;

import com.monstarlove.Main;
import com.monstarlove.dao.ProductDao;

import java.util.Scanner;

public class ProductPage {

    public ProductPage() {
        super();
        showSwitch();
    }

    public static void showSwitch()
    {
        Scanner scanner = new Scanner(System.in);
        ProductDao prod = new ProductDao();
        boolean gotoMain = false;
        showOptions();
        System.out.println("\n\nEnter your choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                prod.addProduct();
                break;
            case 2:
                prod.displayAll();
                break;
            case 3:
                Main.chooseAction();
                gotoMain = true;
                break;
        }
        if (!gotoMain)
           ProductPage.showSwitch();
    }

    public static void showOptions()
    {
        System.out.println("\n----------- Product Page -----------");
        System.out.println("1 - Add product");
        System.out.println("2 - List all products");
        System.out.println("3 - Back to Pages");
    }
}
