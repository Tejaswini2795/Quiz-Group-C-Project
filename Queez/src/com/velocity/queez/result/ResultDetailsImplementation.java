package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResultDetailsImplementation implements ResultDetails {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	@Override
	public void getcalculatedResult(int studentId, Map<Integer, String> studentAnswers) {
		try {
			GetDbConnection connection = new GetDbConnection();
			con = connection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int marksObtained = 0;

		if (con != null) {
			try {
				String Query = "Select Question_Id, Answer from question";
				ps = con.prepareStatement(Query);
				rs = ps.executeQuery();
				HashMap<Integer, String> actualAnswer = new HashMap<Integer, String>();
				while (rs.next()) {
					actualAnswer.put(rs.getInt(1), rs.getString(2));
				}

				Set<Integer> answerSet = actualAnswer.keySet();

				for (Integer id : answerSet) {
					if (actualAnswer.get(id).equals(studentAnswers.get(id)))
						marksObtained++;
				}
				ShowResult showResult = new ShowResult();
				showResult.displayResult(studentId, marksObtained);
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
			  	// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}
