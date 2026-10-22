
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/jacrymo_aa2_ev01";
    private static final String USER = "root";
    private static final String PASSWORD = "Jacrymo2026!";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE: registrar un producto
    public void insertar(String nombre, double precio, int cantidad) {
        String sql = "INSERT INTO Producto "
                + "(nombre, precio, cantidadInventario) VALUES (?, ?, ?)";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.executeUpdate();

            System.out.println("Producto registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }

    // READ: consultar todos los productos
    public void consultar() {
        String sql = "SELECT * FROM Producto";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- INVENTARIO JACRYMO ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("idProducto")
                    + " | Nombre: " + rs.getString("nombre")
                    + " | Precio: " + rs.getDouble("precio")
                    + " | Cantidad: " + rs.getInt("cantidadInventario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // UPDATE: actualizar un producto por su ID
    public void actualizar(int id, String nombre,
                           double precio, int cantidad) {
        String sql = "UPDATE Producto SET nombre = ?, precio = ?, "
                + "cantidadInventario = ? WHERE idProducto = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, cantidad);
            ps.setInt(4, id);

            int filas = ps.executeUpdate();
            System.out.println(filas > 0
                    ? "Producto actualizado correctamente."
                    : "No se encontró el producto.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE: eliminar un producto por su ID
    public void eliminar(int id) {
        String sql = "DELETE FROM Producto WHERE idProducto = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            System.out.println(filas > 0
                    ? "Producto eliminado correctamente."
                    : "No se encontró el producto.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
