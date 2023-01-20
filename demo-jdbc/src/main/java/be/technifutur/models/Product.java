package be.technifutur.models;

import lombok.Data;

@Data
public class Product {
    private int         id;
    private String      name;
    private String      qtyPerUnit;
    private double      price;
    private int         stock;
    private boolean     discontinued;
    private Supplier    supplier;
}
