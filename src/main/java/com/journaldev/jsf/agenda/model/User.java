package main.java.com.journaldev.jsf.agenda.model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


@ManagedBean(name="user")
@RequestScoped
public class User {

	private long userID;
	private String name;
	private String address;
	private Date created_date;

	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String add()
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		int i = 0;

		if(userID !=0)
		{
			PreparedStatement ps = null;
			Connection con = null; 
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "root");
				String sql = "INSERT INTO user1(userId, name, address, created_date) VALUES(?,?,?,?)";
				ps= con.prepareStatement(sql); 
				ps.setLong(1, userID);
				ps.setString(2, name);
				ps.setString(3, address);
				if(created_date != null)
				{
					String date = fmt.format(created_date);
					Object obj = date;
					if(obj == null)
					{
						ps.setDate(4, null);
					}
					else
					{
						java.sql.Date dt = java.sql.Date.valueOf(new String(date));
						ps.setDate(4, dt);
					}
				}

				i = ps.executeUpdate();
				System.out.println("Data Added Successfully");
			}
			catch(Exception e)
			{
				System.out.println(e); 
			}
			finally
			{
				try
				{
					con.close();
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(i >0)
			{
				return "output";
			}
			else
			{
				return "invalid";
			}
		}
		else
		{
			return "invalid";
		}
	} 
}