package com.monstarlove.dao;

import com.monstarlove.database.Database;
import com.monstarlove.entities.Product;
import com.monstarlove.pages.ProductPage;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class ProductDao {

    private Scanner scanner = new Scanner(System.in);
    private List<String> productList = Arrays.asList("Guitar", "Piano", "Violin",
                "Drum", "Pedal", "Bass Guitar", "Electric Guitar");
    private Random rand = new Random();

    private Session session;

    public ProductDao() {
        super();
    }

    public void addProduct() {
        String prodName = productList.get(rand.nextInt(productList.size()));
        Double price = 1000.0;
        String description = "This is a test product.";
        System.out.println("This is just a test product!");
        System.out.println("--- Added Product automatically ---- ");
        System.out.println("Product name: " + prodName);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);

        Database db = new Database(
            new Product(prodName, price, description, 1)
        );
        db.insert();
        System.out.println("Successfully added!\n");
        scanner.nextLine();
    }

    public void displayAll() {
        List<Product> product = this.getResult();
        System.out.println("----- All products ----- \n");
        for (int i=0; i < product.size(); i++) {
            System.out.print(product.get(i).getId() + " | ");
            System.out.print(product.get(i).getName() + " | ");
            System.out.print(product.get(i).getPrice() + " | ");
            System.out.print(product.get(i).getDescription() + "\n");
        }
    }

    public List<Product> getResult() {
        try {
            String hql = "FROM Product";
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            List<Product> result = query.list();
            this.session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
