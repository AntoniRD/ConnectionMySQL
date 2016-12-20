import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Budha on 2/12/16.
 */
public class Servlet_controller extends HttpServlet {

    ArrayList<Users> listDAO = new ArrayList<Users>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDAO = DAO_modelo.getAllUsers();
        request.setAttribute("lista", listDAO); //le paso los datos "por web" de la lista (key,value)
        request.getRequestDispatcher("index.jsp").forward(request, response); //al index jsp le envio los datos que contiene request i response
    }

}