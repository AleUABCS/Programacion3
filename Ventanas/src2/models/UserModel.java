package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserModel {
	
	public UserModel() {
		
	}
	
	public ArrayList<User> get () {
		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		ArrayList<User> users = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {	
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4);
				String phone = rs.getString(5);
				Date create_at = rs.getDate(6);
				Date update_at = rs.getDate(7);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(role);
				System.out.println(phone);
				System.out.println(create_at);
				System.out.println(update_at);

				users.add(new User(id, name, email, role, phone, create_at, update_at));
			}
			rs.close();
			return users;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return users;
	}
	public static void main(String[] args) {
		UserModel model = new UserModel();
		model.get();
	}
}
