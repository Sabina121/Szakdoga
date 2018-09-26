package application;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SQLlite {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost/test2_muzeum";
	final String FELHASZNALONEV = "root";
	final String JELSZO = "";

	Connection conn = null;
	Statement createStatement = null;
	DatabaseMetaData dbmd = null;

	public SQLlite() {
		try {
			conn = DriverManager.getConnection(URL, FELHASZNALONEV, JELSZO);
			System.out.println("A kapcsolat létrejött az adatbázissal!");
		} catch (SQLException e) {
			System.err.println("Valami baj van a kapcsolat létrehozásakor.");
			System.out.println(e);
		}

		if (conn != null) {
			try {
				createStatement = conn.createStatement();
			} catch (SQLException e) {
				System.err.println("Valami baj van a createStatement létrehozásakor.");
				System.out.println(e);
			}
		}

		try {
			dbmd = conn.getMetaData();
		} catch (SQLException e) {
			System.err.println("Valami baj van a DatabaseMetaData létrehozásakor.");
			System.out.println(e);
		}

		try {
			String sql = "CREATE TABLE felhasznalok (`id` INT NOT NULL AUTO_INCREMENT , `nev` VARCHAR(255) NOT NULL , `cim` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
			ResultSet rs = dbmd.getTables(null, null, "%", null);
			if (!rs.next()) {
				createStatement.execute(sql);
			}
		} catch (SQLException e) {
			System.err.println("Valami baj van az adattáblák létrehozásakor.");
			System.out.println(e);
		}
	}

	public ObservableList<Adatok> getAdatok() {
		String sql = "SELECT targy.id,\r\n" + "      muzeum.nev,\r\n" + "       muzeum.cim,\r\n"
				+ "       leiras.megnevezes,\r\n" + "       targy.leltarszam,\r\n" + "       targy.gyujtemeny,\r\n"
				+ "       leiras.kor,\r\n" + "       leiras.alkoto,\r\n" + "       leiras.darabszam,\r\n"
				+ "       leiras.kinezet,\r\n" + "       beszerzes.lhely,\r\n" + "       beszerzes.tulajdonos,\r\n"
				+ "       beszerzes.megszerzes,\r\n" + "       beszerzes.ar,\r\n" + "       hely.kolcs_statusz,\r\n"
				+ "       hely.kiall_hely,\r\n" + "       hely.raktar,\r\n" + "       egyeb.adatgyujto,\r\n"
				+ "       egyeb.revizio,\r\n" + "       egyeb.revszemely\r\n" + "FROM targy \r\n"
				+ "INNER JOIN muzeum ON targy.muzeum_id = muzeum.id\r\n"
				+ "INNER JOIN leiras ON targy.leiras_id = leiras.id\r\n"
				+ "INNER JOIN beszerzes ON targy.beszerzes_id = beszerzes.id\r\n"
				+ "INNER JOIN hely ON targy.hely_id = hely.id\r\n" + "INNER JOIN egyeb ON targy.egyeb_id = egyeb.id";
		ResultSet rs = null;
		ObservableList<Adatok> tireList = FXCollections.observableArrayList();

		try {
			rs = createStatement.executeQuery(sql);
			while (rs.next()) {
				Adatok tire = new Adatok(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14), rs.getBoolean(15),
						rs.getString(16), rs.getBoolean(17), rs.getString(18), rs.getString(19), rs.getString(20));

				tireList.add(tire);
			}
		} catch (SQLException ex) {
			System.out.println("Valami baj van a userek kiolvasásakor");
			System.out.println("" + ex);
		}

		return tireList;
	}

	public void addAdat(String muzeum, String muzCim, String megnevezes, String leltSzam, String gyujetemeny,
			String kor, String alkoto, int darab, String leiras, String lhely, String tulaj, String megszerzes, int ar,
			boolean kolcs, String kiallHely, boolean raktar, String adatgyujt, String revDate, String revGyujt) {
		try {
			String sql = "insert into abroncsok (gyarto, tipus, szelesseg, magassag, atmero, sulyindex, sindex, uosztaly, fekut, zaj) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, muzeum);
			preparedStatement.setString(2, muzCim);
			preparedStatement.setString(3, megnevezes);
			preparedStatement.setString(4, leltSzam);
			preparedStatement.setString(5, gyujetemeny);
			preparedStatement.setString(6, kor);
			preparedStatement.setString(7, alkoto);
			preparedStatement.setInt(8, darab);
			preparedStatement.setString(9, leiras);
			preparedStatement.setString(10, lhely);
			preparedStatement.setString(11, tulaj);
			preparedStatement.setString(12, megszerzes);
			preparedStatement.setInt(13, ar);
			preparedStatement.setString(14, kolcs ? "Y" : "N");
			preparedStatement.setString(15, kiallHely);
			preparedStatement.setString(16, raktar ? "Y" : "N");
			preparedStatement.setString(17, adatgyujt);
			preparedStatement.setString(18, revDate);
			preparedStatement.setString(19, revGyujt);
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a user hozzáadásakor");
			System.out.println("" + ex);
		}
	}

	public void updateAdat(String muzeum, String muzCim, String megnevezes, String leltSzam, String gyujetemeny,
			String kor, String alkoto, int darab, String leiras, String lhely, String tulaj, String megszerzes, int ar,
			boolean kolcs, String kiallHely, boolean raktar, String adatgyujt, String revDate, String revGyujt) {
		try {
			String sql = "update abroncsok set gyarto = ?, tipus = ?, szelesseg = ?, magassag = ?, atmero = ?, sulyindex = ?, sindex = ?, uosztaly = ?, fekut = ?, zaj = ? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, muzeum);
			preparedStatement.setString(2, muzCim);
			preparedStatement.setString(3, megnevezes);
			preparedStatement.setString(4, leltSzam);
			preparedStatement.setString(5, gyujetemeny);
			preparedStatement.setString(6, kor);
			preparedStatement.setString(7, alkoto);
			preparedStatement.setInt(8, darab);
			preparedStatement.setString(9, leiras);
			preparedStatement.setString(10, lhely);
			preparedStatement.setString(11, tulaj);
			preparedStatement.setString(12, megszerzes);
			preparedStatement.setInt(13, ar);
			preparedStatement.setString(14, kolcs ? "Y" : "N");
			preparedStatement.setString(15, kiallHely);
			preparedStatement.setString(16, raktar ? "Y" : "N");
			preparedStatement.setString(17, adatgyujt);
			preparedStatement.setString(18, revDate);
			preparedStatement.setString(19, revGyujt);
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact hozzáadásakor");
			System.out.println("" + ex);
		}

	}

	public void removeAdat(String id) {
		try {
			String sql = "delete from abroncsok where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.execute();
		} catch (SQLException ex) {
			System.out.println("Valami baj van a contact törlésekor");
			System.out.println("" + ex);
		}
	}
}
