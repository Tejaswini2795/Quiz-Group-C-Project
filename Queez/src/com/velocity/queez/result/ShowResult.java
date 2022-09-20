package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ShowResult {
	
	Connection con= null;
	PreparedStatement ps= null;
	
	String grade1 = "Class A";
	String grade2 = "Class B";
	String grade3 = "Class C";
	String grade4 = "Class D";
	
	String userName = "admin";
	String pass = "password";
	
	String id= null;
	String mark = null;
	
	void showOption() {
		ShowAllResults results = new ShowAllResults();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. View Student Result");
		System.out.println("2. Administrator Access");
		System.out.println("3. Start Test");
		System.out.println("\nEnter Your Option: ");
		int i = sc.nextInt();
		
		
		switch (i) {
		case 1: {
			System.out.println("Enter Student ID: ");
			int j = sc.nextInt();
			results.displayStudResult(j);
			break;
		}case 2:{
			boolean flag = false;
			do {
				System.out.println("\nEnter Administrator UserName:");
				String name = sc.next();
				
				System.out.println("\nEnter Password:");
				String password = sc.next();
				
				if(userName.equals(name) && pass.equals(password)) {
					flag = true;
					results.displayAllResult();
					}else {
						System.out.println("Please Enter correct User Name and Password...\n");
					}
				
			} while (flag == false);
			break;
		}case 3:{
			System.out.println("Start Your test");
			System.out.println("Enter Student ID: ");
			int j = sc.nextInt();
			Give_Test giveTest = new Give_Test(j);
			giveTest.questionM();
			break;
		}
		default:{
			System.out.println("Please Enter Vaild Option");

		}
	  }
		sc.close();
	}
	
		public void displayResult(int studentID, int marks){
			id = Integer.toString(studentID);
			mark = Integer.toString(marks);
			
			try {
				GetDbConnection connection = new GetDbConnection();
				con = connection.getConnection();
				
					//This will Update is isAttempted flag to 1 after successful submission
					ps = con.prepareStatement("update Student set isAttempted = if(isAttempted=0,1,isAttempted) where Stud_Id="+ studentID);
					int u = ps.executeUpdate();
					System.out.println(u);
				//This will Insert data in result table	
				ps = con.prepareStatement("insert into result (marksObtained,Grade,Stud_Id) values (?,?,?)");
				
				System.out.println("Student "+studentID+" obtained Marks: ");
				
				ps.setString(1, mark);
				ps.setString(3, id);
				
				if(marks>=8) {
					System.out.print(grade1+" With "+ mark);
					ps.setString(2, grade1);
				}else if (marks>=6 && marks<=7) {
					System.out.print(grade2+" With "+ mark);
					ps.setString(2, grade2);
				}else if(marks==5) {
					System.out.println(grade3+" With "+ mark);
					ps.setString(2, grade3);
				}else {
					System.out.println(" You got: "+grade4+" With "+ mark+" marks");
					ps.setString(2, grade4);
				}
				
				int i = ps.executeUpdate();
				System.out.println("\nData Updated Successfully...."+ i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
