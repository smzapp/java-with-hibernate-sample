package com.monstarlove.pages;

import java.util.Scanner;

public class ProductPage {

    public ProductPage() {
        super();
        showSwitch();
    }

    public static void showSwitch()
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            showOptions();
            int input = scanner.nextInt();
            switch (input) {
                case 1:

            }
        }
    }

    public static void showOptions()
    {
        System.out.println("1 - Add product");
        System.out.println("2 - List all products");
        System.out.println("3 - Back to Pages");
    }
}
