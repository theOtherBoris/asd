package modello;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pdf {

	private String nomePaziente;
	private String cognomePaziente;
	private String cf;
	private Calendar dataNas;
	private String nomeAzienda;
	private String indirizzoAzienda;
	private String esame;
	private String note;
	private double costo;
	private Calendar dataprenotazione;
	private Calendar dataEsame;
	private String citta;
	private int idPaziente;
	private int idPrenotazione;
	private int idAzienda;
	private int idCitta;
	private int idEsame;
	
//	public Pdf(ResultSet dati) throws SQLException{
//		this.nomePaziente = dati.getString("nomePaziente");
//		this.cognomePaziente = dati.getString("cognomePaziente");
//		this.cf = dati.getString("cf");
//		this.dataNas = dateToCalendar(dati.getDate("dataNas"));
//		this.nomeAzienda = dati.getString("nomeAzienda");
//		this.indirizzoAzienda = dati.getString("indirizzoAzienda");
//		this.esame = dati.getString("esame");
//		this.note = dati.getString("note");
//		this.costo = dati.getDouble("costo");
//		this.dataprenotazione = dateToCalendar(dati.getDate("dataprenotazione"));
//		this.dataEsame = dateToCalendar(dati.getDate("dataEsame"));
//		this.citta = dati.getString("citta");
//		this.idPaziente = dati.getInt("idPaziente");
//		this.idPrenotazione = dati.getInt("idPrenotazione");
//		this.idAzienda = dati.getInt("idAzienda");
//		this.idCitta = dati.getInt("idCitta");
//		this.idEsame = dati.getInt("idEsame");
//	}

	public String getNomePaziente() {
		return nomePaziente;
	}

	public void setNomePaziente(String nomePaziente) {
		this.nomePaziente = nomePaziente;
	}

	public String getCognomePaziente() {
		return cognomePaziente;
	}

	public void setCognomePaziente(String cognomePaziente) {
		this.cognomePaziente = cognomePaziente;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getDataNas() {
		return calendarToString(dataNas);
	}

	public void setDataNas(Calendar dataNas) {
		this.dataNas = dataNas;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getIndirizzoAzienda() {
		return indirizzoAzienda;
	}

	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDataprenotazione() {
		return calendarToString(dataprenotazione);
	}

	public void setDataprenotazione(Calendar dataprenotazione) {
		this.dataprenotazione = dataprenotazione;
	}

	public String getDataEsame() {
		return calendarToString(dataEsame);
	}

	public void setDataEsame(Calendar dataEsame) {
		this.dataEsame = dataEsame;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(int idPaziente) {
		this.idPaziente = idPaziente;
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

	public Pdf(String nomePaziente, String cognomePaziente, String cf, Calendar dataNas, String nomeAzienda,
			String indirizzoAzienda, String esame, String note, double costo, Calendar dataprenotazione,
			Calendar dataEsame, String citta, int idPaziente, int idPrenotazione, int idAzienda, int idCitta,
			int idEsame) {
		super();
		this.nomePaziente = nomePaziente;
		this.cognomePaziente = cognomePaziente;
		this.cf = cf;
		this.dataNas = dataNas;
		this.nomeAzienda = nomeAzienda;
		this.indirizzoAzienda = indirizzoAzienda;
		this.esame = esame;
		this.note = note;
		this.costo = costo;
		this.dataprenotazione = dataprenotazione;
		this.dataEsame = dataEsame;
		this.citta = citta;
		this.idPaziente = idPaziente;
		this.idPrenotazione = idPrenotazione;
		this.idAzienda = idAzienda;
		this.idCitta = idCitta;
		this.idEsame = idEsame;
	}

	public Pdf() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String calendarToString(Calendar data) {
		// return data.get(Calendar.DAY_OF_MONTH) + "/" +
		// data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());
	}
	
	public static Calendar dateToCalendar(Date data){
		Calendar gg = new GregorianCalendar();
		if(data != null){
			gg.setTime(data);
		}
		return gg;
	}

}
