package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class Questions {
	Connection con=null;
	PreparedStatement ps=null;
	
	Map<Integer,String> test()
	{
		GetDbConnection obj=new GetDbConnection();
		Map<Integer,String> q_map=new HashMap<Integer,String>();
		try {
			con=obj.getConnection();
			//ps=con.prepareStatement("select * from questions");
			ps=con.prepareStatement("select * from questions ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				{
					q_map.put(rs.getInt(1),rs.getString(2));
				}
			
				
	       } catch (Exception e) {
			e.printStackTrace();
		}
		return q_map;
	}
	
	
	

}
