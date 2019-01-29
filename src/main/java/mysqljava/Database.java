package mysqljava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	// me connecter a la bdd
	Connection conn = null;
	
	Database() {
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            // chaine de connexion pour une base de données en java
            // jdbc:SGBD://ip:port/database_name?user=username&password=pwd
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db?user=root&serverTimezone=UTC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public void doSomeRequest() {
		try {
			// creer un statement
			Statement stmt = this.conn.createStatement();
			// executer requete et recupérer resultat
			ResultSet rs = stmt.executeQuery("SELECT * FROM movies;");
			// parcourir résultat
			while(rs.next()) {
				System.out.println(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
