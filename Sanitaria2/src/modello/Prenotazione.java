package modello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Prenotazione {

	private int idPrenotazione;
	private int idAzienda;
	private int idEsame;
	private Calendar dataEsame;
	private int idPaziente;
	private Calendar dataPrenotazione;
	private int voto;
	private String commento;

	public Prenotazione(int idPrenotazione, int idAzienda, int idEsame, Calendar dataEsame, int idPaziente,
			Calendar dataPrenotazione, int voto, String commento) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.idAzienda = idAzienda;
		this.idEsame = idEsame;
		this.dataEsame = dataEsame;
		this.idPaziente = idPaziente;
		this.dataPrenotazione = dataPrenotazione;
		this.voto = voto;
		this.commento = commento;
	}

	public Prenotazione() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

	public Calendar getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(String dataEsame) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dataEsame.setTime(sdf.parse(dataEsame));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDataEsame(Calendar dataEsame) {
		this.dataEsame = dataEsame;
	}

	public int getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(int idPaziente) {
		this.idPaziente = idPaziente;
	}

	public Calendar getDataPrenotazione() {
		return dataPrenotazione;
	}

	public String getDataPrenotForm() {
		return formattaData(this.dataPrenotazione);
	}

	public String getDataEsameForm() {
		return formattaData(this.dataPrenotazione);
	}

	public void setDataPrenotazione(Calendar dataprenotazione) {
		this.dataPrenotazione = dataprenotazione;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	private static String formattaData(Calendar data) {
		String strdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

		if (data != null) {
			strdate = sdf.format(data.getTime());
		}
		return strdate;
	}

	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", idAzienda=" + idAzienda + ", idEsame=" + idEsame
				+ ", idPaziente=" + idPaziente + dataPrenotazione + ", voto=" + voto + ", commento=" + commento
				+ ", Data prenotazione=" + getDataPrenotForm() + ", Data esame=" + getDataEsameForm() + "]";
	}
	
	

}
