package com.min_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Students {
	Connection con=null;
	PreparedStatement ps=null;
	
	LinkedHashSet<Integer> stud_idList()
	
	{
		LinkedHashSet<Integer> lhs=new  LinkedHashSet<Integer>();
		ConnectionTest obj=new ConnectionTest();
		try {
			con=obj.getConnection();
			ps=con.prepareStatement("select * from students ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				{
					lhs.add(rs.getInt(1));
				}
			
				
	       } catch (Exception e) {
			e.printStackTrace();
		}
		return lhs;		
	}
	
	int verify()
	{
		Students obj=new Students();
		LinkedHashSet<Integer> Stud_ids = obj.stud_idList();
		System.out.println("enter your id");
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		sc.close();
		
		if(Stud_ids.contains(no))
		{
			return no;
		}
		else
		{
			System.out.println("you need to signup first....");
			return 0;
		}
	}
	
	

}
