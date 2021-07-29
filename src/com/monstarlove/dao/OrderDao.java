package com.monstarlove.dao;

import com.monstarlove.database.Database;
import com.monstarlove.entities.Order;
import com.monstarlove.pages.OrderPage;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class OrderDao {

    Scanner scanner = new Scanner(System.in);
    ProductDao prodao = new ProductDao();
    CustomerDao custdao = new CustomerDao();
    Transaction transaction = null;

    public void addOrder() {
        this.prodao.displayAll();
        System.out.println("You are about to order a product.");
        System.out.println("\nSelect product ID: ");
        int prodId = scanner.nextInt();
        this.custdao.displayAll();
        System.out.println("\nSelect Customer ID: ");
        int custId = scanner.nextInt();

        Order order = new Order();
        order.setCustomerId(custId);
        order.setProductId(prodId);
        order.setStatus("Processing");
        order.setTotal(1000);  // total is temporary

        try {
            Session session = HibernateUtils.buildSession();
            assert session != null;
            transaction = session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
            System.out.println("\n\n Successfully added an order!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        OrderPage.showSwitch();
    }
}
