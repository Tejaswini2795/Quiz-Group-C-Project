package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ShowResult {
	
	Connection con= null;
	PreparedStatement ps= null;
	
	String grade1 = "Class A";
	String grade2 = "Class B";
	String grade3 = "Class C";
	String grade4 = "Class D";
	
	String id = null;
	String mark = null;
	
		public void displayResult(int studentID, int marks){
			id = Integer.toString(studentID);
			mark = Integer.toString(marks);
			
			try {
				GetDbConnection connection = new GetDbConnection();
				con = connection.getConnection();
				
				ps = con.prepareStatement("insert into result (marksObtained,Grade,Stud_Id) values (?,?,?)");
				
				System.out.println("Your "+studentID+" obtained Marks: ");
				if(marks>=8) {
					System.out.print(grade1+" With"+ mark);
					ps.setString(1, mark);
					ps.setString(2, grade1);
					ps.setString(3, id);
					
				}else if (marks>=6 && marks<=7) {
					System.out.print(grade2+" With"+ mark);
					ps.setString(1, mark);
					ps.setString(2, grade2);
					ps.setString(3, id);
					
				}else if(marks==5) {
					System.out.println(grade3+" With"+ mark);
					ps.setString(1, mark);
					ps.setString(2, grade3);
					ps.setString(3, id);
					
				}else {
					System.out.println("You are Fail!, you got: "+grade4+" With"+ mark);
					ps.setString(1, mark);
					ps.setString(2, grade3);
					ps.setString(3, id);
				}
				
				int i = ps.executeUpdate();
				System.out.println("Data Updated Successfully...."+ i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
