package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcDao {
	private String url = "jdbc:mysql://localhost:3306/companydb";
	private String username = "student";
	private String password = "student";
	private Connection conn;
	private ArrayList<ArrayList<String>> data;

	public ArrayList<ArrayList<String>> Readit(String s){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(s);
			int colCount = rs.getMetaData().getColumnCount();
			data = new ArrayList<>();
			ArrayList<String> header = new ArrayList<>();
			ArrayList<String> row = new ArrayList<>();
			
			   for (int col = 1; col < (colCount + 1); col++) {
				   header.add(rs.getMetaData().getColumnName(col));
			      }
			   data.add(header);
			   
				while (rs.next()) {
					row = new ArrayList<>();
					for (int i = 1; i < (colCount + 1); i++) {
						row.add(rs.getString(i));
					}
					data.add(row);
				}
				rs.close();
				stmt.close();
				conn.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return data; 
	}
	
	public int Writeit(String s){
		int uc = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			uc = stmt.executeUpdate(s);
				stmt.close();
				conn.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return uc; 
	}
}














