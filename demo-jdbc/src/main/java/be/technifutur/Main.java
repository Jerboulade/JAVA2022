package be.technifutur;

import be.technifutur.dao.CustomerDAO;
import be.technifutur.dao.ProductDAO;
import be.technifutur.dao.SupplierDAO;
import be.technifutur.dao.implementation.CustomerDAOImpl;
import be.technifutur.dao.implementation.ProductDAOImpl;
import be.technifutur.dao.implementation.SupplierDAOImpl;
import be.technifutur.models.Customer;
import be.technifutur.models.Product;
import be.technifutur.models.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        SupplierDAO supplierDAO = new SupplierDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();

        /*for (Product p : productDAO.getALL())
            System.out.println(p);*/

        //supplierDAO.getALL().forEach(System.out::println);
        //System.out.println(supplierDAO.getOne(1L));

        //supplierDAO.delete(999L);

        //Supplier s = new Supplier();
        //s.setSupplierId(999);
        //s.setCompanyName("Oracle");
        //supplierDAO.insert(s);
        //supplierDAO.delete(999L);


        //Supplier toCopy = supplierDAO.getOne(2L).orElseThrow();
        //System.out.println(toCopy);
        //supplierDAO.update(999L, toCopy);

        //supplierDAO.delete(999L);

        //supplierDAO.getALL().forEach(System.out::println);
        System.out.println(customerDAO.getOne("AROUT"));

        Customer c = new Customer();
        c.setCustomerId("OOOOP");
        c.setCompanyName("UUUUUU");
        //customerDAO.insert(c);
        customerDAO.delete("OOOOP");
    }
}