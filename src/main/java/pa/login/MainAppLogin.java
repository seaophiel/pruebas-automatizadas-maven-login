package pa.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAppLogin {
	
	private static Statement stmt;
	private static ResultSet results;
	
	public static void main(String[] args) {
		System.out.println("Inicia APP de Login");
		
		String sql = "Select * From usuarios where User='sebastian1981@gmail.com' AND Password='123456'";
		
		try(Connection conn = DBconnection.createNewDBconnection()){
			System.out.println("Se abre conexion correctamente");
			System.out.println("Se buscara login para credenciales usuario=sebastian1981@gmail.com y password=123456");
			stmt = conn.createStatement();
			results = stmt.executeQuery(sql);

			 while (results.next()) {
				 System.out.println("Se encontraron datos:");
				 Integer id = Integer.valueOf(results.getString("Id"));
				 String user = String.valueOf(results.getString("User"));
				 String password = String.valueOf(results.getString("Password"));
				 String nombre = String.valueOf(results.getString("Nombre"));
				 System.out.println("id: " + id);
				 System.out.println("user: " + user);
				 System.out.println("password: " + password);
				 System.out.println("nombre: " + nombre);
			 }
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Fin del proceso login");
		}
	}
}
