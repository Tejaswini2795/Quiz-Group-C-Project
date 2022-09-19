package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentRegistration 
{
	PreparedStatement ps = null;
	Connection con = null;
	
	public void registerStudent(String First_Name, String Last_Name, String Email_Id)
	{
		try
		{
			GetDbConnection dbConnection = new GetDbConnection();
			con = dbConnection.getConnection();
			ps = con.prepareStatement("insert into student(First_Name, Last_Name, Email_Id) values(?,?,?)");
			ps.setString(1, First_Name);
			ps.setString(2, Last_Name);
			ps.setString(3, Email_Id);
			Statement stmt = null;
			String query = "SELECT * from Student WHERE Email_Id = '" + Email_Id + "'";
			try
			{
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next())
			 {
				System.out.println("Email already exist!!");
			 }
				else
				{
					int i = ps.executeUpdate();
					System.out.println("Student registered successfully ");
				}
		     	}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public static boolean isValid(String Email_Id)
	{
	String regex = "^(.+)@(.+)$";
	Pattern pattern = Pattern.compile(regex);
	if (Email_Id == null)
	{
		return false;
	}
	return pattern.matcher(Email_Id).matches();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter first name : "); 
			String First_Name = sc.next();
			System.out.println("Enter last name : ");
			String Last_Name = sc.next();
			System.out.println("Enter Email ID : ");	
			String Email_Id = sc.next();
			boolean result = isValid(Email_Id);
			
			if (result == true)
			{
			//	System.out.println("Provided email address "+ Email_Id + " is valid \n");
			}
			
			else
			{
				System.out.println("Provided email address "+ Email_Id + " is invalid \n");
			}
			
			StudentRegistration studentRegistration = new StudentRegistration();
			studentRegistration.registerStudent(First_Name, Last_Name, Email_Id);
		
		    sc.close();
}
}	
