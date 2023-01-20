package be.technifutur.dao.implementation;

import be.technifutur.ConnexionFactory;
import be.technifutur.dao.CustomerDAO;
import be.technifutur.models.Customer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public void insert(Customer entity) {
        String sql = """
                INSERT INTO customers (customer_id, address, city, company_name, contact_name, contact_title, country, fax, phone, postal_code, region)
                VALUES (?,?,?,?,?,?,?,?,?,?,?)
                """;
        try (Connection co = ConnexionFactory.createConnexion();
              PreparedStatement stmt = co.prepareStatement(sql);)
        {
            stmt.setString(1, entity.getCustomerId());
            stmt.setString(2, entity.getAddress());
            stmt.setString(3, entity.getCity());
            stmt.setString(4, entity.getCompanyName());
            stmt.setString(5, entity.getContactName());
            stmt.setString(6, entity.getContactTitle());
            stmt.setString(7, entity.getCountry());
            stmt.setString(8, entity.getFax());
            stmt.setString(9, entity.getPhone());
            stmt.setString(10, entity.getPostalCode());
            stmt.setString(11, entity.getRegion());

            if (stmt.executeUpdate() != 1)
                throw new RuntimeException("Error when trying to insert Customer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Customer> getALL() {
        String sql = """
                SELECT * FROM customers
                """;
        try (Connection co = ConnexionFactory.createConnexion();
             Statement stmt = co.createStatement();
             ResultSet res = stmt.executeQuery(sql);
        ){
            List<Customer> customerList= new LinkedList<>();
            while (res.next())
                customerList.add(Convertor.convert(res, Customer.class));
            customerList.forEach(System.out::println);
            return customerList;
        }
        catch (SQLException e){
            throw new RuntimeException("Error : getAll customers");
        }
    }

    @Override
    public Optional<Customer> getOne(String id) {
        String sql = """
                SELECT * FROM customers WHERE customer_id=?
                """;
        try(Connection co = ConnexionFactory.createConnexion();
            PreparedStatement stmt = co.prepareStatement(sql);
        ){
            stmt.setString(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next())
                return Optional.of(Convertor.convert(res, Customer.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(String id, Customer entity) {
        return null;
    }

    @Override
    public void delete(String id) {
        String sqlDeleteCustomer = """
                DELETE FROM customers WHERE customer_id=?
                """;
        String sqlCount = """
                SELECT count(*)
                FROM orders
                WHERE customer_id=?
                """;
        try (Connection co = ConnexionFactory.createConnexion();
             PreparedStatement delStmt = co.prepareStatement(sqlDeleteCustomer);
             PreparedStatement countStmt = co.prepareStatement(sqlCount);)
        {
            countStmt.setString(1, id);
            ResultSet res = countStmt.executeQuery();
            res.next();
            int count = res.getInt(1);
            if (count > 0)
                throw new RuntimeException(String.format("Cannot delete Customer(%s) with active orders", id));
            delStmt.setString(1, id);
            if (delStmt.executeUpdate() != 1)
                throw new RuntimeException(String.format("Delete error : cannot find user with id:%s", id));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
