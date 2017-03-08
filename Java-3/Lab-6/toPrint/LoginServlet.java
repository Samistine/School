import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Samuel
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            //response.sendError(400, "Username and\\or Password Not Received");
            request.setAttribute("status", "error");
            request.setAttribute("errorMessage", "Credentials Required!");
            getServletContext().getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            return;
        }

        try {
            Customer customer = Customer.getCustomer(username);

            //No customer || invalid password
            if (customer == null || !customer.getPassword().equals(password)) {
                request.setAttribute("status", "error");
                request.setAttribute("errorMessage", "Invalid Credentials!");
            } else { //Good login
                request.setAttribute("status", "success");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", "error");
            request.setAttribute("errorMessage", "SQLException!");
        }

        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
