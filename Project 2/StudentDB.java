import java.sql.*;

public class StudentDB {
  Connection con;
  public StudentDB(){
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

    }


    catch (ClassNotFoundException e){
      e.printStackTrace();

    }

    try {
 con=DriverManager.getConnection("jdbc:oracle:thin:@claros.cs.purdue.edu:1524:strep","liu734","iLwOxHgv");

    }
    catch (SQLException e){
      e.printStackTrace();


    }

  }


}