package com.monstarlove.dao;

import com.monstarlove.database.Database;
import com.monstarlove.entities.Customer;
import com.monstarlove.entities.Product;
import com.monstarlove.pages.CustomerPage;
import com.monstarlove.pages.ProductPage;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class CustomerDao {

    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private String where = "";

    private Session session;

    public CustomerDao() {
        super();
    }

    public void addCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email address:");
        String email = scanner.nextLine();
        System.out.println("Enter contact number");
        String contact = scanner.nextLine();

        Database db = new Database(
                new Customer(name, email, contact)
        );
        db.insert();
        System.out.println("Successfully added!\n");
    }

    public void update() {
        this.displayAll();
        System.out.println("\nEnter customer ID to update: ");
        int input = scanner.nextInt();
        System.out.println("\n---------- Update customer info--------");
        scanner.nextLine();
        System.out.println("Enter new customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email address:");
        String email = scanner.nextLine();
        System.out.println("Enter contact number");
        String contact = scanner.nextLine();
        try {
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Customer mycustomer = session.get(Customer.class, input);
            mycustomer.setEmail(email);
            mycustomer.setName(name);
            mycustomer.setContactNo(contact);
            session.getTransaction().commit();
            this.displayById(input);
            System.out.println("Updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer() {
        this.displayAll();
        System.out.println("\nSelect customer ID to delete: ");
        int input = scanner.nextInt();
        Database db = new Database(new Customer());
        int result = db.delete(input);
        if (result > 0) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("Cannot remove a customer.");
        }
    }


    public void displayById(int id) {
        List<Customer> customer = this.find(id);
        System.out.println("----- Customer Information ----- ");
        System.out.println("ID : " + customer.get(0).getId());
        System.out.println("Name: " + customer.get(0).getName());
        System.out.println("Email: " + customer.get(0).getEmail());
        System.out.println("Contact: " + customer.get(0).getContactNo());
    }

    public List<Customer> find(int id) {
        try {
            String hql = "FROM Customer where id=:id";
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<Customer> result = query.list();
            this.session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayAll() {
        List<Customer> customer = this.getResult();
        System.out.println("----- All Customer ----- ");
        for (int i=0; i < customer.size(); i++) {
            System.out.print(customer.get(i).getId() + " | ");
            System.out.print(customer.get(i).getName() + " | ");
            System.out.print(customer.get(i).getEmail() + " | ");
            System.out.print(customer.get(i).getContactNo() + "\n");
        }
    }

    public List<Customer> getResult() {
        try {
            String hql = "FROM Customer";
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            List<Customer> result = query.list();
            this.session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
