package koneksi;
import java.sql.*;

/**
 *
 * @author atsukoaditia
 */
public class koneksi {
    private Connection koneksi;

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil load driver MySQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal load driver: " + ex.getMessage());
            return null;
        }

        String url = "jdbc:mysql://localhost:3306/klinik";
        try {
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil koneksi database");
        } catch (SQLException ex) {
            System.out.println("Koneksi database gagal: " + ex.getMessage());
            koneksi = null;
        }

        return koneksi;
    }
}