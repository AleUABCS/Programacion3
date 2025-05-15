package models;

import java.sql.Date;
import java.util.ArrayList;

public class User {
	private int id;
	private String name;
	private String email;
	private String role;
	private String phone;
	private Date create_at;
	private Date update_at;
	
	public User(int id, String name, String email, String role, String phone, Date create_at, Date update_at) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
	public Object[] toArray () {
		Object[] array = {
				this.id,
				this.name,
				this.email,
				this.role,
				this.phone,
				this.create_at,
				this.update_at
		};
		
		return array;
	}
}
