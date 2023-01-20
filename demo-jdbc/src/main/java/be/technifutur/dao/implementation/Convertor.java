package be.technifutur.dao.implementation;

import be.technifutur.models.Customer;
import be.technifutur.models.Product;
import be.technifutur.models.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

abstract class Convertor {

    static <T> T convert(ResultSet res, Class<T> resultClass) throws SQLException {
        if (resultClass.equals(Product.class))
            return (T)convertProduct(res);
        else if (resultClass.equals(Supplier.class))
            return (T)convertSupplier(res);
        else if (resultClass.equals(Customer.class))
            return (T)convertCustomer(res);
        throw new IllegalArgumentException("resultClass  no valid");
    }

    private static Supplier convertSupplier(ResultSet res) throws SQLException {
        Supplier sup = new Supplier();

            sup.setSupplierId(res.getInt("customer_id"));
            sup.setAddress(res.getString("address"));
            sup.setCity(res.getString("city"));
            sup.setCompanyName(res.getString("company_name"));
            sup.setContactName(res.getString("contact_name"));
            sup.setContactTitle(res.getString("contact_title"));
            sup.setCountry(res.getString("country"));
            sup.setFax(res.getString("fax"));
            sup.setHomepage(res.getString("homepage"));
            sup.setPhone(res.getString("phone"));
            sup.setPostalCode(res.getString("postal_code"));
            sup.setRegion(res.getString("region"));

        return sup;
    }

    private static Product convertProduct(ResultSet res) throws SQLException {
        Product product = new Product();

        if (res.next()) {
            product.setId(res.getInt("product_id"));
            product.setName(res.getString("product_name"));
            product.setPrice(res.getDouble("unit_price"));
            product.setStock(res.getInt("units_in_stock"));
            product.setDiscontinued(res.getBoolean("discontinued"));
            product.setQtyPerUnit(res.getString("quantity_per_unit"));
        }
        if (res.getObject("supplier_id") != null) {
            product.setSupplier(convertSupplier(res));
        }
        return product;
    }

    private static Customer convertCustomer(ResultSet res) throws SQLException{
        Customer customer = new Customer();

        if (res.next()){
            customer.setCustomerId(res.getString("customer_id"));
            customer.setAddress(res.getString("address"));
            customer.setCity(res.getString("city"));
            customer.setCompanyName(res.getString("company_name"));
            customer.setContactName(res.getString("contact_name"));
            customer.setContactTitle(res.getString("contact_title"));
            customer.setCountry(res.getString("country"));
            customer.setFax(res.getString("fax"));
            customer.setPhone(res.getString("phone"));
            customer.setPostalCode(res.getString("postal_code"));
            customer.setRegion(res.getString("region"));
        }
        return customer;
    }
}
