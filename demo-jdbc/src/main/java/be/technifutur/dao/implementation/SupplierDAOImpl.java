package be.technifutur.dao.implementation;

import be.technifutur.ConnexionFactory;
import be.technifutur.dao.SupplierDAO;
import be.technifutur.models.Product;
import be.technifutur.models.Supplier;

import java.sql.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public void insert(Supplier entity) {
        String sql = "INSERT INTO suppliers (supplier_id, company_name, contact_name, contact_title, address, city, region, postal_code, country, phone, fax, homepage) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection co = ConnexionFactory.createConnexion();
             PreparedStatement stmt = co.prepareStatement(sql);)
        {
            stmt.setLong(1, entity.getSupplierId());
            stmt.setString(2, entity.getCompanyName());
            stmt.setString(3, entity.getContactTitle());
            stmt.setString(4, entity.getAddress());
            stmt.setString(5, entity.getCity());
            stmt.setString(6, entity.getRegion());
            stmt.setString(7, entity.getPostalCode());
            stmt.setString(8, entity.getCountry());
            stmt.setString(9, entity.getPhone());
            stmt.setString(10, entity.getPhone());
            stmt.setString(11, entity.getFax());
            stmt.setString(12, entity.getHomepage());

            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException("insert impossible", e);
        }
    }

    @Override
    public List<Supplier> getALL() {
        String sql = """
                SELECT *
                FROM suppliers
                """;
        // mettre le driver en activité + donnée de connexion (url, username, password)
        try (Connection co = ConnexionFactory.createConnexion();
             Statement stmt = co.createStatement();
             ResultSet res = stmt.executeQuery(sql))
        {
            // get product from DB
            List<Supplier> supplierList = new ArrayList<>();
            while (res.next()){
                supplierList.add(Convertor.convert(res, Supplier.class));
            }
            supplierList.forEach(System.out::println);
            return supplierList;

        }
        catch (SQLException e){
            throw new RuntimeException("error in data access : supplier");
        }
    }

    @Override
    public Optional<Supplier> getOne(Long id) {
        String sql = """
                SELECT *
                FROM suppliers
                WHERE supplier_id= 
                """ + id;
        try (Connection co = ConnexionFactory.createConnexion();
             Statement stmt = co.createStatement();
             ResultSet res = stmt.executeQuery(sql))
        {
            // get supplier from DB
            if (res.next())
                return Optional.of(Convertor.convert(res, Supplier.class));
        }
        catch (SQLException e){
            throw new RuntimeException("error in data access : supplier");
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(Long id, Supplier entity) {

        String sql = """
                UPDATE suppliers
                SET 
                    company_name = ?
                    ,contact_name = ?
                    ,contact_title = ?
                    ,address = ?
                    ,city = ?
                    ,region = ?
                    ,postal_code = ?
                    ,country = ?
                    ,phone = ?
                    ,fax = ?
                    ,homepage = ?
                WHERE supplier_id = ?
                """;
        try (Connection co = ConnexionFactory.createConnexion();
             PreparedStatement stmt = co.prepareStatement(sql))
        {
            stmt.setString(1, entity.getCompanyName());
            stmt.setString(2, entity.getContactTitle());
            stmt.setString(3, entity.getAddress());
            stmt.setString(4, entity.getCity());
            stmt.setString(5, entity.getRegion());
            stmt.setString(6, entity.getPostalCode());
            stmt.setString(7, entity.getCountry());
            stmt.setString(8, entity.getPhone());
            stmt.setString(9, entity.getPhone());
            stmt.setString(10, entity.getFax());
            stmt.setString(11, entity.getHomepage());
            stmt.setLong(12, id);

            return (stmt.executeUpdate() == 1);
        }
        catch (SQLException e){
                 throw new RuntimeException("Error update",e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = """
                DELETE FROM suppliers WHERE supplier_id = ?
                """;
        String sqlNull = """
                UPDATE products SET suppliers_id=null WHERE supplier_id = ?
                """;
        try (Connection co = ConnexionFactory.createConnexion();
             PreparedStatement stmt = co.prepareStatement(sql);
             PreparedStatement stmtNull = co.prepareStatement(sqlNull);)
        {
            stmtNull.setLong(1, id);
            stmtNull.executeUpdate();

            stmt.setLong(1, id);
            if (stmt.executeUpdate() != 1)
                throw new RuntimeException(String.format("supplier with id:%d not found", id));
        }
        catch (SQLException e){
            throw new RuntimeException("error when delete supplier");
        }
    }

}
