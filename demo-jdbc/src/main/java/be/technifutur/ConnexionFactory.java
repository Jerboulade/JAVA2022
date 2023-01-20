package be.technifutur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionFactory {
    private final static String URL = "jdbc:postgresql://localhost:5435/northwind";
    private final static String USR = "postgres";
    private final static String PSWD = "biscotte";

    public static Connection createConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USR, PSWD);
    }

}
