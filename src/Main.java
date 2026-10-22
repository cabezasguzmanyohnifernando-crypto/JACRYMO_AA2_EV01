import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL =
            "jdbc:mysql://localhost:3306/jacrymo_aa2_ev01";

    private static final String USER = "root";

    private static final String PASSWORD = "Jacrymo2026!";

    public static void main(String[] args) {

        try (Connection conexion =
                DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Conexion con MySQL exitosa.");
            System.out.println("Sistema JACRYMO conectado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL:");
            System.out.println(e.getMessage());
        }
    }
}