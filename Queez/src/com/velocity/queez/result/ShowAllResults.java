package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowAllResults {
	Connection con= null;
	PreparedStatement ps= null;
	
	public void displayStudResult(int studentID){
		try {
			GetDbConnection connection = new GetDbConnection();
			con = connection.getConnection();
			
			
			ps = con.prepareStatement("select marksObtained,Total_marks,Grade,Stud_Id from result where Stud_Id="+studentID);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------- Your Reults -------------------------------");
			System.out.println("  Obtained Marks      Out of \t\t Grade \t       Student ID");
			System.out.println("------------------------------------------------------------------------");
			
				while(rs.next()) {
					System.out.println("\t"+rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t   "+rs.getInt(4));
				}
			
		}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void displayAllResult(){
		try {
			GetDbConnection connection = new GetDbConnection();
			con = connection.getConnection();
			
			ps = con.prepareStatement("select marksObtained,Total_marks,Grade,Stud_Id from result");
			ResultSet rs = ps.executeQuery();
			System.out.println("------------------------------- Reults ---------------------------------");
			System.out.println("  Obtained Marks      Out of \t\t Grade \t       Student ID");
			System.out.println("------------------------------------------------------------------------");
			
				while(rs.next()) {
					System.out.println("\t"+rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t   "+rs.getInt(4));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
