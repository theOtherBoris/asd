package controllo;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenza.dao.DAOEsame;
import persistenza.dao.DAOEsameAzienda;

/**
 * Servlet implementation class CercaEsame
 */
@WebServlet("/CercaEsame")
public class CercaEsame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CercaEsame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("id") != null) {
			request.setAttribute("listaEsame", DAOEsame.getAll());
			RequestDispatcher rd = request.getRequestDispatcher("cercaEsame.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("id") != null) {
			int idEsame = Integer.parseInt(request.getParameter("idEsame"));
			request.setAttribute("listaEsameAzienda", DAOEsameAzienda.esameAziendabyIdEsame(idEsame));
			RequestDispatcher rd = request.getRequestDispatcher("cercaAziendaByEsame.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
		//doGet(request, response);
	}

}
