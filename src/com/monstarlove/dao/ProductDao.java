package com.monstarlove.dao;

import com.monstarlove.database.Database;
import com.monstarlove.entities.Category;
import com.monstarlove.entities.Product;
import com.monstarlove.pages.ProductPage;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class ProductDao {

    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private Product product = new Product();
    private Category category = new Category();

    private Session session;

    public ProductDao() {
        super();
    }

    public void addProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Price:");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Short Description: ");
        String description = scanner.nextLine();
        System.out.println("Category ID (default): 1");

        category.setId(1);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        Database db = new Database(product);
        db.insert();

        System.out.println("Successfully added!\n");
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
