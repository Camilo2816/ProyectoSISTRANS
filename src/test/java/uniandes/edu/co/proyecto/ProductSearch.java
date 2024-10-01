package uniandes.edu.co.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class ProductSearch {

    private static final String DB_URL = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD"; 
    private static final String USER = "ISIS2304A27202420"; 
    private static final String PASS = "SrFSChbQxm"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        System.out.print("Ingrese la fecha de vencimiento (YYYY-MM-DD): ");
        String fechaInput = scanner.nextLine();
        
        System.out.print("Ingrese el nombre de la sucursal: ");
        String sucursalInput = scanner.nextLine();
        
        System.out.print("Ingrese el nombre del producto: ");
        String productoInput = scanner.nextLine();

        String sql = "SELECT " +
                     "    p.NOMBRE AS producto, " +
                     "    p.PRECIOUNITARIO AS precio, " +
                     "    p.FECHAEXPIRACION AS fecha_vencimiento, " +
                     "    c.NOMBRE AS categoria, " +
                     "    s.NOMBRE AS sucursal " +
                     "FROM " +
                     "    PRODUCTO p " +
                     "JOIN " +
                     "    CATEGORIA c ON p.CATEGORIA_CATEGORIA_ID = c.CATEGORIA_ID " +
                     "JOIN " +
                     "    INFOEXTRABODEGA pb ON p.PRODUCTO_ID = pb.PRODUCTO_PRODUCTO_ID " +
                     "JOIN " +
                     "    BODEGA b ON pb.BODEGA_BODEGA_ID = b.BODEGA_ID " +
                     "JOIN " +
                     "    SUCURSAL s ON b.SUCURSAL_SUCURSAL_ID = s.SUCURSAL_ID " +
                     "WHERE " +
                     "    p.PRECIOUNITARIO BETWEEN ? AND ? " +
                     "    AND p.FECHAEXPIRACION >= ? " +
                     "    AND s.NOMBRE = ? " +
                     "    AND c.NOMBRE = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, 1); 
            pstmt.setDouble(2, 10); 
            pstmt.setDate(3, Date.valueOf(fechaInput)); 
            pstmt.setString(4, sucursalInput); 
            pstmt.setString(5, productoInput); 

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String producto = rs.getString("producto");
                    double precio = rs.getDouble("precio");
                    Date fechaVencimiento = rs.getDate("fecha_vencimiento");
                    String categoria = rs.getString("categoria");
                    String sucursal = rs.getString("sucursal");

                    System.out.println("Producto: " + producto +
                                       ", Precio: " + precio +
                                       ", Fecha de Vencimiento: " + fechaVencimiento +
                                       ", Categoría: " + categoria +
                                       ", Sucursal: " + sucursal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); 
        }
    }
}
