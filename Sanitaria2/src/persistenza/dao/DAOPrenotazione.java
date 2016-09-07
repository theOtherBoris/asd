package persistenza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modello.Prenotazione;
import persistenza.DAOPrenotazioneInterface;
import persistenza.DataSource;

public class DAOPrenotazione implements DAOPrenotazioneInterface {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet result;
	private static PreparedStatement pr;

	
	public static ArrayList<Prenotazione> getPrenotazioniAttive(int idPaziente) {
		// TODO Auto-generated method stub
		ArrayList<Prenotazione> lista = new ArrayList<>();
		String dataOdierna = calendarToString(new GregorianCalendar());
		int idPrenotazione,idAzienda,idEsame,voto;
		String commento;
		Calendar dataEsame,dataPrenotazione;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Prenotazione where idPaziente = ? and dataEsame >= ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next()){
				idPrenotazione = result.getInt("idPrenotazione");
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				dataEsame = dateToCalendar(result.getDate("dataEsame"));
				dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
				voto = result.getInt("voto");
				commento = result.getString("commento");
				lista.add(new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static ArrayList<Prenotazione> getStoricoPaziente(int idPaziente) {
		// TODO Auto-generated method stub
		ArrayList<Prenotazione> lista = new ArrayList<>();
		String dataOdierna = calendarToString(new GregorianCalendar());
		int idPrenotazione,idAzienda,idEsame,voto;
		String commento;
		Calendar dataEsame,dataPrenotazione;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Prenotazione where idPaziente = ? and dataEsame < ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next()){
				idPrenotazione = result.getInt("idPrenotazione");
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				dataEsame = dateToCalendar(result.getDate("dataEsame"));
				dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
				voto = result.getInt("voto");
				commento = result.getString("commento");
				lista.add(new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static ArrayList<Prenotazione> getPrenotazioniGiorno(int idAzienda, Calendar dataEsame) {
		// TODO Auto-generated method stub
		ArrayList<Prenotazione> lista = new ArrayList<>();
		String dataOdierna = calendarToString(dataEsame);
		int idPrenotazione,idEsame,voto,idPaziente;
		String commento;
		Calendar dataPrenotazione;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Prenotazione where idAzienda = ? and dataEsame = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idAzienda);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next()){
				idPrenotazione = result.getInt("idPrenotazione");
				idPaziente = result.getInt("idPaziente");
				idEsame = result.getInt("idEsame");
				dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
				voto = result.getInt("voto");
				commento = result.getString("commento");
				lista.add(new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}
	
	public static ArrayList<Prenotazione> getPrenotazioniGiornoPaziente(int idPaziente, Calendar dataEsame) {
		// TODO Auto-generated method stub
		ArrayList<Prenotazione> lista = new ArrayList<>();
		String dataOdierna = calendarToString(dataEsame);
		int idPrenotazione,idEsame,voto,idAzienda;
		String commento;
		Calendar dataPrenotazione;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Prenotazione where idPaziente = ? and dataEsame = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next()){
				idPrenotazione = result.getInt("idPrenotazione");
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
				voto = result.getInt("voto");
				commento = result.getString("commento");
				lista.add(new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static ArrayList<Prenotazione> getStoricoAzienda(int idAzienda) {
		// TODO Auto-generated method stub
				ArrayList<Prenotazione> lista = new ArrayList<>();
				String dataOdierna = calendarToString(new GregorianCalendar());
				int idPrenotazione,idEsame,voto,idPaziente;
				String commento;
				Calendar dataPrenotazione,dataEsame;
				try{
					connection = DataSource.getConnection();
					String query = "select * from Prenotazione where idAzienda = ? and dataEsame < ?";
					pr = connection.prepareStatement(query);
					pr.setInt(1, idAzienda);
					pr.setString(2, dataOdierna);
					result = pr.executeQuery();
					while(result.next()){
						idPrenotazione = result.getInt("idPrenotazione");
						idPaziente = result.getInt("idPaziente");
						idEsame = result.getInt("idEsame");
						dataEsame = dateToCalendar(result.getDate("dataEsame"));
						dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
						voto = result.getInt("voto");
						commento = result.getString("commento");
						lista.add(new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento));
					}
				}catch(SQLException e){
					System.out.println(e);
				}finally{
					DataSource.closeAll(connection, statement, result, pr);
				}
				return lista;
	}

	
	public static int lasciaFeedback(int idPrenotazione, int voto, String commento) throws SQLException {
		// TODO Auto-generated method stub
		int numeroRighe = 0;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "update Prenotazione set voto = ? , commento = ? where idPrenotazione = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, voto);
			pr.setString(2, commento);
			pr.setInt(3, idPrenotazione);
			numeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(numeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return numeroRighe;
	}
	
	public static int prenotaEsame(Prenotazione prenotazione) throws SQLException {
		// TODO Auto-generated method stub
		int nummeroRighe = 0;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query ="insert into Prenotazione "
					    + "(idAzienda,idEsame,dataEsame,idPaziente,dataPrenotazione)"
					    + "values"
					    + "(?,?,?,?,?)";
			pr = connection.prepareStatement(query);
			pr.setInt(1,prenotazione.getIdAzienda());
			pr.setInt(2,prenotazione.getIdEsame());
			Date sql = new Date(prenotazione.getDataEsame().get(Calendar.YEAR)-1900, prenotazione.getDataEsame().get(Calendar.MONTH)-1,
					prenotazione.getDataEsame().get(Calendar.DAY_OF_MONTH));
			pr.setDate(3, sql);
			pr.setInt(4,prenotazione.getIdPaziente());
			sql = new Date(prenotazione.getDataPrenotazione().get(Calendar.YEAR)-1900, prenotazione.getDataPrenotazione().get(Calendar.MONTH),
					prenotazione.getDataPrenotazione().get(Calendar.DAY_OF_MONTH));
			pr.setDate(5,sql);
//			pr.setInt(6,prenotazione.getVoto());
//			pr.setString(7,prenotazione.getCommento());
			nummeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(nummeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return nummeroRighe;
	}

	
	public static int eliminaPrenotazione(int idPrenotazione) throws SQLException {
		// TODO Auto-generated method stub
		int nummeroRighe = 0;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "delete from Prenotazione where idPrenotazione = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPrenotazione);
			nummeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(nummeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return nummeroRighe;
	}

	
	public static int rimandaEsame(int idPrenotazione, Calendar nuovaDataEsame) throws SQLException {
		// TODO Auto-generated method stub
		int nummeroRighe = 0;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "update Prenotazione set dataEsame = ? where idPrenotazione = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, calendarToString(nuovaDataEsame));
			pr.setInt(2, idPrenotazione);
			nummeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(nummeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return nummeroRighe;
	}

	
	public static int eDisponibile(int idAzienda, int idEsame, Calendar dataEsameDaPrenotare) {
		// TODO Auto-generated method stub
		int disponibilita = 0;
		try{
			connection = DataSource.getConnection();
			String query = "select count(*) from Prenotazione "
						 + "group by idAzienda,idEsame,dataEsame "
						 + "having"
						 + "idAzienda = ? and "
						 + "idEsame = ? and "
						 +" dataEsame = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idAzienda);
			pr.setInt(2, idEsame);
			pr.setString(3, calendarToString(dataEsameDaPrenotare));
			result = pr.executeQuery();
			if(result.next()){
				disponibilita = result.getInt(0);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return disponibilita;
	}
	
	public static Prenotazione getPrenotazioneById(int idPrenotazione){
		Prenotazione p = null;
		int idAzienda,idEsame,idPaziente,voto;
		String commento;
		Calendar dataEsame,dataPrenotazione;
		try{
			connection = DataSource.getConnection();
			String query = "select * from prenotazione where idPrenotazione = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPrenotazione);
			result = pr.executeQuery();
			if(result.next()){
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				dataEsame = dateToCalendar(result.getDate("dataEsame"));
				idPaziente = result.getInt("idPaziente");
				dataPrenotazione = dateToCalendar(result.getDate("dataPrenotazione"));
				voto = result.getInt("voto");
				commento = result.getString("commento");
				p = new Prenotazione(idPrenotazione, idAzienda, idEsame, dataEsame, idPaziente, dataPrenotazione, voto, commento);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return p;
	}
	
	private static String[] mesi = {"GEN","FEN","MAR","APR","MAG","GIU","LUG","AGO","SET","OTT","NOV","DIC"};
	
	private static String calendarToString(Calendar data){
		return data.get(Calendar.DAY_OF_MONTH) + "-" + mesi[Calendar.MONTH] + "-" + data.get(Calendar.YEAR);
	}
	
	private static GregorianCalendar dateToCalendar(Date data){
		GregorianCalendar gg = new GregorianCalendar();
		if(data != null){
			gg.setTime(data);
		}
		return gg;
	}

}
