
public class PruebaCRUD {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // READ: consultar los productos existentes
        System.out.println("1. CONSULTAR PRODUCTOS");
        dao.consultar();

        // CREATE: registrar un producto de prueba
        System.out.println("\n2. REGISTRAR PRODUCTO");
        dao.insertar("Zapatos casuales", 150000.00, 10);

        // READ: consultar los productos registrados
        System.out.println("\n3. CONSULTAR DESPUES DE REGISTRAR");
        dao.consultar();

        // UPDATE: actualizar el producto de prueba
        // El ID 1 se conserva para Tenis deportivos.
        // El nuevo producto normalmente recibirá el ID 2.
        System.out.println("\n4. ACTUALIZAR PRODUCTO");
        dao.actualizar(2, "Zapatos casuales", 160000.00, 12);

        // DELETE: eliminar el producto de prueba
        System.out.println("\n5. ELIMINAR PRODUCTO");
        dao.eliminar(2);

        // READ: comprobar que Tenis deportivos permanece
        System.out.println("\n6. CONSULTA FINAL");
        dao.consultar();
    }
}
