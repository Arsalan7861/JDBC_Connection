import java.sql.*;
/*
1. import --> java.sql
2. load and register the driver --> com.mysql.cj.jdbc.Driver
3. Create Connection --> Connection
4. Create a statement --> Statement
5. execute the query
6. process the results
7. close
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3307/database";
        String name = "name";
        String pass = "password";
        int id = 8;
        String fName = "";
        String lName = "";
        int age = 56;
//        String query = "select * from ogrenci";
        //String query = "insert into ogrenci values (7, 'Ahmad', 'Ali', 67)";
        String query = "insert into ogrenci values (?, ?, ?, ?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, name, pass);
//        Statement stmt = con.createStatement();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, fName);
        stmt.setString(3, lName);
        stmt.setInt(4, age);
//        ResultSet rs = stmt.executeQuery(query);//DQL
        int count = stmt.executeUpdate();//DML
        System.out.println(count + "row/s effected");
//        while (rs.next()) {//Printing data
//            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//        }
        stmt.close();
        con.close();
    }
}
//DDL : Data definition language : used whenever a structure of the database is changed.
//DML : Change the value of the data
//DQL : Data Query Language
//TCL : Transaction Control Language
