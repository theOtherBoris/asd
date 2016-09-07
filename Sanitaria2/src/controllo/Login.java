package controllo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modello.Azienda;
import modello.Paziente;
import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOPaziente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ArrayList<String> listaErrori = new ArrayList<>();
		String tipoUtente = "";
		
		//controllo dati 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.equals("")){
			listaErrori.add("Email non inserita");
		}
		
		if(password.equals("")){				
			listaErrori.add("Password non inserita");
		}
		
		if(listaErrori.isEmpty()){
			String nome = "";
			//i campi sono riempiti 
			//bisogna cercare se l'utente � presente
			
			//chiamata dao utente
			if(DAOPaziente.verificaCredenziali(email, password)){
				tipoUtente = "paziente";
			}
			//chiamata dao azienda
			else if(DAOAzienda.verificaCredenziali(email, password)){
				tipoUtente = "azienda";
			}
			
			
			if(tipoUtente.equals("paziente")){
				
				HttpSession sessione = request.getSession();
				Paziente paziente = DAOPaziente.getPazienteByEmail(email);
				
				//set del nome e del cognome del paziente nella sessione
				sessione.setAttribute("nome", paziente.getNome()+ " " + paziente.getCognome());
				//set id paziente nella sessione
				sessione.setAttribute("id", paziente.getIdPaziente());
				//set tipo utente nella sessione
				sessione.setAttribute("tipo", "p");
				response.sendRedirect("HomePageUtente");
//				RequestDispatcher rd = request.getRequestDispatcher("/HomePageUtente");
//				rd.forward(request, response);
			}
			else if(tipoUtente.equals("azienda")){
				
				Azienda azienda = DAOAzienda.getAziendaByMail(email);
				
				HttpSession sessione = request.getSession();
				sessione.setAttribute("nome", azienda.getNome());
				//set id azienda nella sessione
				sessione.setAttribute("id", azienda.getIdAzienda());
				//set tipo utente nella sessione
				sessione.setAttribute("tipo", "a");
						
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/azienda/homePageAzienda.jsp");
				rd.forward(request, response);
			}
			else{
				listaErrori.add("Username e/o Password errati");
				request.setAttribute("listaErrori", listaErrori);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		else{
			request.setAttribute("listaErrori", listaErrori);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
		
	}
}
