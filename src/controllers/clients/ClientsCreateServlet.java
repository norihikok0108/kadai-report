package controllers.clients;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Client;
import models.Employee;
import models.validators.ClientValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ClientsCreateServlet
 */
@WebServlet("/clients/create")
public class ClientsCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Client c = new Client();

            c.setEmployee((Employee)request.getSession().getAttribute("login_employee"));

            Date client_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("client_date");
            if(rd_str != null && !rd_str.equals("")) {
                client_date = Date.valueOf(request.getParameter("client_date"));
            }
            c.setClient_date(client_date);
            c.setClient_name(request.getParameter("client_name"));
            c.setPartner_name(request.getParameter("partner_name"));
            c.setClient_address(request.getParameter("client_address"));
            c.setClient_content(request.getParameter("client_content"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            c.setCreated_at(currentTime);
            c.setUpdated_at(currentTime);

            List<String> errors = ClientValidator.validate(c);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("client", c);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/clients/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/clients/index");
            }
        }
    }

}
