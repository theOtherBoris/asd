package controllo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TabellaPrenotazioni {

//	AZIENDA
//	COSTO
//	DATAESAME
//	IDPRENOTAZIONE
//	IDESAME
//	IDAZIENDA
//	IDPAZIENTE
//	ESAME

	private String nomeAzienda;
	private String nomeEsame;
	private double costoEsame;
	private Calendar dataEsame;
	private int idEsame;
	private int idPaziente;
	private int idAzienda;
	private int idPrenotazione;
	
	public TabellaPrenotazioni(ResultSet dati) throws SQLException{
		this.nomeAzienda = dati.getString("nomeAzienda");
		this.nomeEsame = dati.getString("nomeEsame");
		this.costoEsame = dati.getInt("costoEsame");
		this.dataEsame = dateToCalendar(dati.getDate("dataEsame"));
		this.idEsame = dati.getInt("idEsame");
		this.idPaziente = dati.getInt("idPaziente");
		this.idAzienda = dati.getInt("idAzienda");
		this.idPrenotazione = dati.getInt("idPrenotazione");
		
	}

	public int getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(int idPaziente) {
		this.idPaziente = idPaziente;
	}

	public TabellaPrenotazioni(String nomeAzienda, String nomeEsame, double costoEsame, Calendar dataEsame, int idEsame,
			int idPaziente, int idAzienda, int idPrenotazione) {
		super();
		this.nomeAzienda = nomeAzienda;
		this.nomeEsame = nomeEsame;
		this.costoEsame = costoEsame;
		this.dataEsame = dataEsame;
		this.idEsame = idEsame;
		this.idPaziente = idPaziente;
		this.idAzienda = idAzienda;
		this.idPrenotazione = idPrenotazione;
	}

	public TabellaPrenotazioni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	public double getCostoEsame() {
		return costoEsame;
	}

	public void setCostoEsame(double costoEsame) {
		this.costoEsame = costoEsame;
	}

	public Calendar getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Calendar dataEsame) {
		this.dataEsame = dataEsame;
	}

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	private static String[] mesi = { "GEN", "FEN", "MAR", "APR", "MAG", "GIU", "LUG", "AGO", "SET", "OTT", "NOV",
	"DIC" };

	private static String calendarToString(Calendar data) {
		return data.get(Calendar.YEAR) + "-" + mesi[Calendar.MONTH] + "-" + data.get(Calendar.DAY_OF_MONTH);
	}

	private static GregorianCalendar dateToCalendar(Date data) {
		GregorianCalendar gg = new GregorianCalendar();
		if (data != null) {
			gg.setTime(data);
		}
		return gg;
	}
}
