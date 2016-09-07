package controllo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modello.Citta;
import modello.Paziente;
import persistenza.dao.DAOCitta;
import persistenza.dao.DAOPaziente;
import utilita.Verifica;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Citta> listaCitta = DAOCitta.getAll();
		request.setAttribute("listaCitta", listaCitta);
		RequestDispatcher rd = request.getRequestDispatcher("registrazioneUtente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String cf = request.getParameter("cf");
		String email = request.getParameter("email");
		String sesso = request.getParameter("sesso");
		String password = request.getParameter("password");
		String indirizzo = request.getParameter("indirizzo");
		String dataNas = request.getParameter("dataNascita");
		int idCitta = Integer.parseInt(request.getParameter("citta"));		
		Paziente paziente = new Paziente(nome, cognome, dataNas, cf, email, password, idCitta, indirizzo, sesso);	
		boolean[] errori = Verifica.verificaPaziente(paziente);
		if (!errori[0]) { // Paziente ok
			try {
                
				int id = DAOPaziente.registrazionePaziente(paziente);
				if(id<1){  //Errore del db
					errori[0] = true;
					errori[10] = true;
					ArrayList<Citta> listaCitta = DAOCitta.getAll();
					request.setAttribute("listaCitta", listaCitta);
					request.setAttribute("errori", errori);
					RequestDispatcher rd = request.getRequestDispatcher("registrazioneUtente.jsp");
					rd.forward(request, response);
					return;
				}
				HttpSession sessione = request.getSession();
				sessione.setAttribute("nome", nome + " " + cognome);
				sessione.setAttribute("id", id);
				sessione.setAttribute("tipo", "p");
				response.sendRedirect("HomePageUtente");
//				RequestDispatcher rd = request.getRequestDispatcher("HomePageUtente");
//				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			for (boolean a : errori) {
				System.out.println(a);
			}
			ArrayList<Citta> listaCitta = DAOCitta.getAll();
			request.setAttribute("listaCitta", listaCitta);
			request.setAttribute("errori", errori);
			RequestDispatcher rd = request.getRequestDispatcher("registrazioneUtente.jsp");
			rd.forward(request, response);
		}
	}

}