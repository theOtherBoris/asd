package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modello.TabellaPrenotazioni;
import persistenza.DAOTabellaPrenotazioniInterface;
import persistenza.DataSource;

public class DAOTabellaPrenotazioni implements DAOTabellaPrenotazioniInterface {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet result;
	private static PreparedStatement pr;

	public static ArrayList<TabellaPrenotazioni> getAll() {
		ArrayList<TabellaPrenotazioni> lista = new ArrayList<>();
		try{
			connection = DataSource.getConnection();
			statement = connection.createStatement();
			String query = "select * from TabellaPrenotazioni";
			result = statement.executeQuery(query);
			while(result.next())
				lista.add(new TabellaPrenotazioni(result));
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	public static ArrayList<TabellaPrenotazioni> getStoricoPaziente(int idPaziente) {
		ArrayList<TabellaPrenotazioni> lista = new ArrayList<>();
		try{
			connection = DataSource.getConnection();
			String dataOdierna = calendarToString(new GregorianCalendar());
			String query = "select * from VISTAPRENOTAZIONI where idPaziente = ? and dataEsame < ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next())
				lista.add(new TabellaPrenotazioni(result));
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	public static ArrayList<TabellaPrenotazioni> getPrenotazioniAttive(int idPaziente) {
		ArrayList<TabellaPrenotazioni> lista = new ArrayList<>();
		try{
			connection = DataSource.getConnection();
			String dataOdierna = calendarToString(new GregorianCalendar());
			String query = "select * from VISTAPRENOTAZIONI where idPaziente = ? and dataEsame >= ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			pr.setString(2, dataOdierna);
			result = pr.executeQuery();
			while(result.next())
				lista.add(new TabellaPrenotazioni(result));
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	public static ArrayList<TabellaPrenotazioni> getPrenotationi(int idPaziente) {
		ArrayList<TabellaPrenotazioni> lista = new ArrayList<>();
		try{
			connection = DataSource.getConnection();
			String query = "select * from VISTAPRENOTAZIONI where idPaziente = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idPaziente);
			result = pr.executeQuery();
			while(result.next())
				lista.add(new TabellaPrenotazioni(result));
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}
	
	private static String[] mesi = { "GEN", "FEN", "MAR", "APR", "MAG", "GIU", "LUG", "AGO", "SET", "OTT", "NOV",
	"DIC" };
	
	private static String calendarToString(Calendar data) {
		return data.get(Calendar.DAY_OF_MONTH) + "-" + mesi[Calendar.MONTH] + "-" + data.get(Calendar.YEAR);
	}

}
