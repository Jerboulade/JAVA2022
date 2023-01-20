package be.technifutur.dao.implementation;

import be.technifutur.ConnexionFactory;
import be.technifutur.dao.ProductDAO;
import be.technifutur.dao.SupplierDAO;
import be.technifutur.models.Product;
import be.technifutur.models.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void insert(Product entity) {

    }

    @Override
    public List<Product> getALL() {
        String sql = """
                SELECT *
                FROM products p
                LEFT JOIN suppliers s
                ON p.product_id = s.supplier_id
                """;
        // mettre le driver en activité + donnée de connexion (url, username, password)
        try (Connection co = ConnexionFactory.createConnexion();
             Statement stmt = co.createStatement();
             ResultSet res = stmt.executeQuery(sql))
        {
            // get product from DB
            List<Product> productList = new ArrayList<>();
            while (res.next()){
                productList.add(Convertor.convert(res, Product.class));
            }
            productList.forEach(System.out::println);
            return productList;

        }
        catch (SQLException e){
            throw new RuntimeException("error in data access product");
        }
    }

    @Override
    public Optional<Product> getOne(Long id) {
        String sql = """
                SELECT *
                FROM products
                LEFT JOIN suppliers ON product_id = supplier_id
                WHERE product_id= 
                """ + id;
        try (Connection co = ConnexionFactory.createConnexion();
             Statement stmt = co.createStatement();
             ResultSet res = stmt.executeQuery(sql))
        {
            // get product from DB
            if (res.next())
                return Optional.of(Convertor.convert(res, Product.class));
        }
        catch (SQLException e){
            throw new RuntimeException("error in data access : product");
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(Long id, Product entity) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

}
