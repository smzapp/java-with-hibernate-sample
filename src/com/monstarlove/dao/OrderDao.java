package com.monstarlove.dao;

import com.monstarlove.database.Database;
import com.monstarlove.entities.Customer;
import com.monstarlove.entities.Order;
import com.monstarlove.entities.Product;
import com.monstarlove.pages.OrderPage;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class OrderDao {

    private Scanner scanner = new Scanner(System.in);
    private ProductDao prodao = new ProductDao();
    private CustomerDao custdao = new CustomerDao();
    private Session session;
    private Product product = new Product();
    private Customer customer = new Customer();

    public void addOrder() {
        this.prodao.displayAll();
        System.out.println("You are about to order a product.");
        System.out.println("\nSelect product ID: ");
        int prodId = scanner.nextInt();
        this.custdao.displayAll();
        System.out.println("\nSelect Customer ID: ");
        int custId = scanner.nextInt();

        product.setId(prodId);
        customer.setId(custId);
        
        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setStatus("Processing");
        order.setTotal(1000);  // total is temporary
        Database db = new Database(order);
        db.insert();
        System.out.println("Successfully added an order.");
    }

    public void updateStatus() {
        this.displayAll();
        System.out.println("\n\nEnter Order ID to update: ");
        int input = scanner.nextInt();
        System.out.println("\n---------- Update Order Status --------");
        scanner.nextLine();
        System.out.println("Change Status as: ");
        String status = scanner.nextLine();
        try {
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Order order = session.get(Order.class, input);
            order.setStatus(status);
            session.getTransaction().commit();
            System.out.println("Updated status successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder() {
        this.displayAll();
        System.out.println("\nSelect ORDER ID to delete: ");
        int input = scanner.nextInt();
        Database db = new Database(new Order());
        int result = db.delete(input);
        if (result > 0) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Cannot remove a customer.");
        }
    }


    public void displayAll() {
        List<Order> order = this.getResult();
        System.out.println("----- All Orders ----- ");
        for (int i=0; i < order.size(); i++) {
            System.out.print(order.get(i).getId() + " | ");
            System.out.print(order.get(i).getProduct().getName() + " | ");
            System.out.print(order.get(i).getStatus() + " | ");
            System.out.print(order.get(i).getTotal() + "\n");
        }
    }

    public List<Order> getResult() {
        try {
            String hql = "FROM Order";
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            List<Order> result = query.list();
            this.session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
