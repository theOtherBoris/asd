package utilita;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import modello.Paziente;
import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOPaziente;

public class Verifica {
	private static final String alfabeto = "^[A-Z ]*$";
	private static final String alfaIndirizzo = "^[A-Z 0-9 ,]*$";
	private static final String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean controlloCodiceFiscale(String codiceFiscale) {

		int i, s, c;
		String cf2;
		int setdisp[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24,
				23 };
		if (codiceFiscale.length() == 0){
			return false;
		}
		// return "";
		if (codiceFiscale.length() != 16)
			return false;
		// return "La lunghezza del codice fiscale non &egrave;\n"
		// + "corretta: il codice fiscale dovrebbe essere lungo\n"
		// + "esattamente 16 caratteri.";
		cf2 = codiceFiscale.toUpperCase();
		for (i = 0; i < 16; i++) {
			c = cf2.charAt(i);
			if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'Z'))
				return false;
			// return "Il codice fiscale contiene dei caratteri non validi:\n"
			// + "i soli caratteri validi sono le lettere e le cifre.";
		}
		s = 0;
		for (i = 1; i <= 13; i += 2) {
			c = cf2.charAt(i);
			if (c >= '0' && c <= '9')
				s = s + c - '0';
			else
				s = s + c - 'A';
		}
		for (i = 0; i <= 14; i += 2) {
			c = cf2.charAt(i);
			if (c >= '0' && c <= '9')
				c = c - '0' + 'A';
			s = s + setdisp[c - 'A'];
		}
		if (s % 26 + 'A' != cf2.charAt(15))
			return false;
		// return "Il codice fiscale non &egrave; corretto:\n"
		// + "il codice di controllo non corrisponde.";

		return true;
	}

	public static boolean controlloPartitaIva(String partitaIva) {

		int i, c, s;
		if (partitaIva.length() == 0)
			return false;
		if (partitaIva.length() != 11)
			return false;
		// return "La lunghezza della partita IVA non &egrave;\n"
		// + "corretta: la partita IVA dovrebbe essere lunga\n"
		// + "esattamente 11 caratteri.\n";
		for (i = 0; i < 11; i++) {
			if (partitaIva.charAt(i) < '0' || partitaIva.charAt(i) > '9')
				return false;
			// return "La partita IVA contiene dei caratteri non ammessi:\n"
			// + "la partita IVA dovrebbe contenere solo cifre.\n";
		}
		s = 0;
		for (i = 0; i <= 9; i += 2)
			s += partitaIva.charAt(i) - '0';
		for (i = 1; i <= 9; i += 2) {
			c = 2 * (partitaIva.charAt(i) - '0');
			if (c > 9)
				c = c - 9;
			s += c;
		}
		if ((10 - s % 10) % 10 != partitaIva.charAt(10) - '0')
			return false;
		// return "La partita IVA non &egrave; valida:\n"
		// + "il codice di controllo non corrisponde.";
		return true;
	}

	public static boolean[] verificaPaziente(Paziente p) {
		return verificaPaziente(p,true);
	}
	
	public static boolean[] verificaPaziente(Paziente p, boolean checkAll) {
		boolean[] errore = new boolean[12];
		//all'indice 10 vengono indicati gli errori del DB
		
		if (!controlloCodiceFiscale(p.getCf())&& !DAOPaziente.trovaCodFis(p.getCf())){ // codFis sbagliato o gi� presente
			errore[0] = true;
			errore[1] = true;
			}
		if (p.getNome().length() < 3 || !p.getNome().toUpperCase().matches(alfabeto)){
			errore[0] = true;
			errore[2] = true;
			}
		if (p.getCognome().length() < 3 || !p.getCognome().toUpperCase().matches(alfabeto)){
			errore[0] = true;
			errore[3] = true;
			}
		if(p.getIndirizzo().length()<1||!p.getNome().toUpperCase().matches(alfaIndirizzo)){
			errore[0] = true;
			errore[6]= true;
			}
		if(p.getIdCitta()<1){
			errore[0] = true;
			errore[7]= true;
			}

		if((!p.getSesso().equals("F"))&&(!p.getSesso().equals("f"))&&(!p.getSesso().equals("m"))&&(!p.getSesso().equals("M"))){
			errore[0] = true;
			errore[9]= true;
			}
		if(p.getDataNas()==null){
			errore[0] = true;
			errore[11]= true;
		}
		if(checkAll) {
			if((DAOPaziente.getPazienteByEmail(p.getEmail())!=null)||(DAOAzienda.getAziendaByMail(p.getEmail())!=null)){
				errore[0] = true;
				errore[8]=true;
				}
			if (!p.getEmail().matches(email)){
				errore[0] = true;
				errore[4] = true;
				}
			if(p.getPassword().length()<1){
				errore[0] = true;
				errore[5]= true;
				}			
		}
		
		return errore;
	}

	public static boolean ValiditaEmail(String str){
	   return str.matches(email);
    }

public static String formattaData(Calendar data) {
	String strdate = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

	if (data != null) {
		strdate = sdf.format(data.getTime());
	}
	return strdate;

}
}
