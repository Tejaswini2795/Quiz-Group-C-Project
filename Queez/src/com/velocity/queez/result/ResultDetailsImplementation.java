package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ResultDetailsImplementation implements ResultDetails {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	@Override
	public void getcalculatedResult(int studentId, Map<Integer, String> studentAnswers) {
		// TODO Auto-generated method
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int marksObtained = 0;

		if (con != null) {
			try {
				String Query = "Select QuestionId, Answer from question";
				ps = con.prepareStatement(Query);
				rs = ps.executeQuery();
				System.out.println("Result set:"+rs);
				HashMap<Integer, String> actualAnswer = new HashMap<Integer, String>();
				while (rs.next()) {
					actualAnswer.put(rs.getInt(1), rs.getString(2));
				}

				Set<Integer> answerSet = actualAnswer.keySet();

				for (Integer id : answerSet) {
					if (actualAnswer.get(id).equals(studentAnswers.get(id)))
						marksObtained++;
				}

				System.out.println("Marks Obtained by student:" + marksObtained);

				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
			  	// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		//trial code
		Map<Integer, String> studentAnswers = new HashMap();
		studentAnswers.put(1,"A");
		studentAnswers.put(2,"C");
		studentAnswers.put(3,"B");
		studentAnswers.put(4,"A");
		studentAnswers.put(5,"C");
		ResultDetailsImplementation rs = new ResultDetailsImplementation();
		rs.getcalculatedResult(1, studentAnswers);
		System.out.println("Ended program");
		
	}

}
