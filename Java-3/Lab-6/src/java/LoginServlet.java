
import com.samistine.school.java3.lab5.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel Seidel
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    private static enum LoginError {
        CREDENTIALS_NOTSUPPLIED,
        CREDENTIALS_INVALID,
        DATABASE_EXCEPTION;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        if (username == null || password == null) {
            handleError(request, response, LoginError.CREDENTIALS_NOTSUPPLIED, Optional.empty());
            return;
        }

        try {
            Customer customer = Customer.getCustomer(username);

            //No customer || invalid password
            if (customer == null || !customer.getPassword().equals(password)) {
                handleError(request, response, LoginError.CREDENTIALS_INVALID, Optional.empty());
            } else { //Good login
                handleLogin(request, response, customer);
            }

        } catch (SQLException ex) {
            handleError(request, response, LoginError.DATABASE_EXCEPTION, Optional.of(ex));
        }
    }

    /**
     * Handles a successful login.
     *
     * @param request
     * @param response
     * @param customer
     */
    private void handleLogin(HttpServletRequest request, HttpServletResponse response, Customer customer) throws ServletException, IOException {
        request.getSession().setAttribute("customer", customer);
        request.setAttribute("accounts", customer.getAccounts());
        System.out.println("Accounts: " + customer.getAccounts());
        getServletContext().getRequestDispatcher("/accountLookup.jsp")
                .forward(request, response);
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, LoginError error, Optional<Exception> dbException) throws ServletException, IOException {
        dbException.ifPresent(throwable
                -> LOGGER.log(Level.SEVERE, "A database exception has occured while processing a user's login within " + getServletName(), throwable));

        request.setAttribute("status", "error");

        switch (error) {
            case CREDENTIALS_INVALID:
                request.setAttribute("errorMessage", "Invalid Credentials!");
                break;

            case CREDENTIALS_NOTSUPPLIED:
                request.setAttribute("errorMessage", "Credentials Required!");
                break;

            case DATABASE_EXCEPTION:
                request.setAttribute("errorMessage", "A database error occurred!");
                break;
        }

        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
