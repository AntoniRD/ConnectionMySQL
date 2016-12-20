import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Budha on 2/12/16.
 */
public class DAO_modelo{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.16.4.224:3306/mysql";

    static ArrayList<Users>listUsers = new ArrayList<Users>();

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "test";

    public static ArrayList<Users> getAllUsers(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String host = rs.getString("host");
                String user = rs.getString("user");

                //inicializacion de usuarios dandoles de alta
                Users users = new Users();
                users.setHost(host);
                users.setUser(user);

                listUsers.add(users);


            }
            //STEP 6: Clean-up environment

            rs.close();
            return listUsers;


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return null;
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}//end FirstExample