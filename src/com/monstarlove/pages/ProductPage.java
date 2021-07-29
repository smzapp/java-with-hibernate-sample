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
        showOptions();
        System.out.println("\n\nEnter your choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                prod.addProduct();
                showSwitch();
                break;
            case 2:
                prod.displayAll();
                showSwitch();
                break;
            case 3:
                Main.chooseAction();
                break;
        }
    }

    public static void showOptions()
    {
        System.out.println("\n----------- Product Page -----------");
        System.out.println("1 - Add product");
        System.out.println("2 - List all products");
        System.out.println("3 - Back to Pages");
    }
}