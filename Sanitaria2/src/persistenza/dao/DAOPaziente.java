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

import modello.Paziente;
import persistenza.DAOPazienteInterface;
import persistenza.DataSource;

public class DAOPaziente implements DAOPazienteInterface {
	private static Connection connection;
	private static ResultSet result;
	private static Statement statement;
	private static PreparedStatement pr;

	public static Paziente getPazienteById(int idPaziente) {
		Paziente paziente = new Paziente();
		try {
			connection = DataSource.getConnection();
			statement = connection.createStatement();

			// Linguaggio SQL
			String query = "select * from paziente where idpaziente=" + idPaziente;


			// system.out.println(query);


			//system.out.println(query);


			result = statement.executeQuery(query);
			if (result.next()) {
				paziente.setIdPaziente(idPaziente);
				paziente.setNome(result.getString("nome"));
				paziente.setCognome(result.getString("cognome"));
				Calendar prov = new GregorianCalendar();
				prov.setTime(result.getDate("datanas"));
				paziente.setDataNas(prov);
				paziente.setCf(result.getString("cf"));
				paziente.setEmail(result.getString("email"));
				paziente.setPassword(result.getString("password"));
				paziente.setIdCitta(result.getInt("idcitta"));
				paziente.setIndirizzo(result.getString("indirizzo"));
				paziente.setSesso(result.getString("sesso"));
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			DataSource.closeAll(connection, statement, result, pr);
		}
		return paziente;
	}

	public static Paziente getPazienteByEmail(String email) {
		
		try {
			connection = DataSource.getConnection();
			// statement = connection.createStatement();

			// Linguaggio SQL
			String query = "select * from paziente where email = ?";
			pr = connection.prepareStatement(query);
			// System.out.println(query);
			pr.setString(1, email);
			result = pr.executeQuery();

			if (result.next()) {
				Paziente paziente = new Paziente();
				paziente.setIdPaziente(result.getInt("idPaziente"));
				paziente.setNome(result.getString("nome"));
				paziente.setCognome(result.getString("cognome"));
				Calendar prov = new GregorianCalendar();
				prov.setTime(result.getDate("datanas"));
				paziente.setDataNas(prov);
				paziente.setCf(result.getString("cf"));
				paziente.setEmail(email);
				paziente.setPassword(result.getString("password"));
				paziente.setIdCitta(result.getInt("idcitta"));
				paziente.setIndirizzo(result.getString("indirizzo"));
				paziente.setSesso(result.getString("sesso"));
				
				DataSource.closeAll(connection, statement, result, pr);
				return paziente;
			}

		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return null;
	}

	public static ArrayList<Paziente> getAll() {

		ArrayList<Paziente> listaPazienti = new ArrayList<>();
		try {
			connection = DataSource.getConnection();
			statement = connection.createStatement();

			// Linguaggio SQL
			String query = "select * from paziente";

			// System.out.println(query);

			result = statement.executeQuery(query);

			while (result.next()) {
				Paziente paziente = new Paziente();
				paziente.setIdPaziente(result.getInt("idPaziente"));
				paziente.setNome(result.getString("nome"));
				paziente.setCognome(result.getString("cognome"));
				paziente.setDataNas(dateToCalendar(result.getDate("datanas")));
				paziente.setCf(result.getString("cf"));
				paziente.setEmail(result.getString("email"));
				paziente.setPassword(result.getString("password"));
				paziente.setIdCitta(result.getInt("idcitta"));
				paziente.setIndirizzo(result.getString("indirizzo"));
				paziente.setSesso(result.getString("sesso"));
				listaPazienti.add(paziente);

			}

		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		DataSource.closeAll(connection, statement, result, pr);

		return listaPazienti;
	}

	public static int registrazionePaziente(Paziente paziente) throws SQLException {
		int done = 0;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			// Linguaggio SQL

			String query = "insert into paziente " + "(nome,cognome,datanas,cf,email,password,idcitta,indirizzo,sesso) "
					+ "values " + "(?,?,?,?,?,?,?,?,?)";
			
			String generatedColumns[] = { "idpaziente" };
			pr = connection.prepareStatement(query, generatedColumns);
			pr.setString(1, paziente.getNome());
			pr.setString(2, paziente.getCognome());
			Date sql = new Date(paziente.getDataNas().get(Calendar.YEAR)-1900, paziente.getDataNas().get(Calendar.MONTH)-1,
					paziente.getDataNas().get(Calendar.DAY_OF_MONTH));
			pr.setDate(3, sql);
			pr.setString(4, paziente.getCf());
			pr.setString(5, paziente.getEmail());
			pr.setString(6, paziente.getPassword());
			pr.setInt(7, paziente.getIdCitta());
			pr.setString(8, paziente.getIndirizzo());
			pr.setString(9, paziente.getSesso() + "");		
			
			pr.executeUpdate();

			ResultSet result = pr.getGeneratedKeys();
			if (result.next()) {
				done = Integer.parseInt(result.getString(1));
			}
		} catch (SQLException sqle) {
			try {
				connection.rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(sqle);
		} finally {
			if (done != 0) {
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return done;
	}

	public static int eliminaPaziente(int idPaziente) throws SQLException {
		int done = 0;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			statement = connection.createStatement();

			// Linguaggio SQL
			String query = "delete from paziente where idPaziente =" + idPaziente;
			done = statement.executeUpdate(query);

		} catch (SQLException sqle) {
			connection.rollback();
			System.out.println(sqle);
		} finally {
			if (done != 0) {

				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return done;
	}

	public static int update(Paziente paziente) throws SQLException {
		int done = 0;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "update paziente set " + "nome = ?, " + "cognome = ?, " + "datanas = ?, " + "cf = ?, "
					+ "email = ?, " + "password = ?, " + "idcitta = ?, " + "indirizzo = ?, " + "sesso = ? "
					+ "where idPaziente = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, paziente.getNome());
			pr.setString(2, paziente.getCognome());
			Date sql = new Date(paziente.getDataNas().get(Calendar.YEAR)-1900, paziente.getDataNas().get(Calendar.MONTH)-1,
					paziente.getDataNas().get(Calendar.DAY_OF_MONTH));
			pr.setDate(3, sql);
			pr.setString(4, paziente.getCf());
			pr.setString(5, paziente.getEmail());
			pr.setString(6, paziente.getPassword());
			pr.setInt(7, paziente.getIdCitta());
			pr.setString(8, paziente.getIndirizzo());
			pr.setString(9, paziente.getSesso() + "");
			pr.setInt(10, paziente.getIdPaziente());
			done = pr.executeUpdate();

		} catch (SQLException sqle) {
			connection.rollback();
			System.out.println(sqle);
		}

		finally {
			if (done != 0) {
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return done;
	}

	public static String getPassword(String email) {
		String psw = null;
		try {
			connection = DataSource.getConnection();
			// statement = connection.createStatement()
			// Linguaggio SQL
			String query = "select password from paziente where email = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			// system.out.println(query);

			result = pr.executeQuery();
			if (result.next())
				psw = result.getString("password");
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		finally {
			DataSource.closeAll(connection, statement, result, pr);
		}
		return psw;
	}

	public static boolean verificaCredenziali(String email, String password) {
		// TODO Auto-generated method stub
		boolean credenzialiOk = false;
		try{
			connection = DataSource.getConnection();
			String query = "select password from paziente where email = ? and password = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, password);
			result = pr.executeQuery();
			if(result.next()){
				credenzialiOk = true;
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return credenzialiOk;
	}

	
	
	
	public static int getPazienteId(String email) {
		int id = 0;
		try {
			connection = DataSource.getConnection();
			String query = "select idPaziente from Paziente where email = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			result = pr.executeQuery();
			if (result.next()) {
				id = result.getInt("idPaziente");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DataSource.closeAll(connection, statement, result, pr);
		}
		return id;
	}

	public static int cambiaDati(Paziente paziente) throws SQLException {
		int done = 0;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "update paziente set " + "nome = ?, " + "cognome = ?, " + "datanas = ?, " + "cf = ?, "
					+ "idcitta = ?, " + "indirizzo = ?, " + "sesso = ? " + "where idPaziente = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, paziente.getNome());
			pr.setString(2, paziente.getCognome());
			Date sql = new Date(paziente.getDataNas().get(Calendar.YEAR)-1900, paziente.getDataNas().get(Calendar.MONTH),
					paziente.getDataNas().get(Calendar.DAY_OF_MONTH));
			pr.setDate(3, sql);
			pr.setString(4, paziente.getCf());
			pr.setInt(5, paziente.getIdCitta());
			pr.setString(6, paziente.getIndirizzo());
			pr.setString(7, paziente.getSesso() + "");
			pr.setInt(8, paziente.getIdPaziente());
			done = pr.executeUpdate();

		} catch (SQLException sqle) {
			connection.rollback();
			System.out.println(sqle);
		}

		finally {
			if (done != 0) {
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return done;
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

	public static boolean trovaCodFis(String codFis) {

		try {
			connection = DataSource.getConnection();
			statement = connection.createStatement();
			// Linguaggio SQL
			String query = "select * from paziente where cf=" + codFis;
			result = statement.executeQuery(query);
			if(result.next()){
				DataSource.closeAll(connection, statement, result, pr);
				return true;
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		DataSource.closeAll(connection, statement, result, pr);
		return false;
	}

}
