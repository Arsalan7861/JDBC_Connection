import java.sql.*;
/*
1. import --> java.sql
2. load and register the driver --> com.mysql.jdbc.Driver
3. Create Connection --> Connection
4. Create a statement --> Statement
5. execute the query
6. process the results
7. close
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3307/arsalankhroush";
        String name = "root";
        String pass = "arsalankhroush123@";
        String query = "select * from ogrenci";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, name, pass);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        rs.close();
        stmt.close();
        con.close();
    }
}