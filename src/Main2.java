import java.sql.*;

//Editing data in database using DAO(Data Access Object) structure.
public class Main2 {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
//        Student s1 = dao.getStudent(3);//Calling with id
//        System.out.println("First Name: " + s1.fName);
//        System.out.println("Last Name: " + s1.lName);
//        System.out.println("Age: " + s1.age);
//        Student student = new Student();
//        student.id = 9;
//        student.fName = "Muhammed";
//        student.lName = "Ali";
//        student.age = 25;
//        dao.connect();
//        dao.addStudent(student);
        dao.connect();
        dao.removeStudent(9);

    }
}

class StudentDAO{
    String url = "jdbc:mysql://localhost:3307/database";
    String name = "name";
    String pass = "password";
    Connection con = null;
    PreparedStatement pst = null;
    Statement stmt = null;
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, name, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Student getStudent(int id){
        try {
            String query = "select * from ogrenci where id = " + id;
            Student s = new Student();
            s.id = id;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, name, pass);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            s.fName = rs.getString(2);
            s.lName = rs.getString(3);
            s.age = rs.getInt(4);
            return s;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void addStudent(Student s){
        try {
            String query = "insert into ogrenci values (?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, s.id);
            pst.setString(2, s.fName);
            pst.setString(3, s.lName);
            pst.setInt(4, s.age);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeStudent(int id){
        try {
            String query = "delete from ogrenci where id = " + id;
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    int id;
    String fName;
    String lName;
    int age;
}
