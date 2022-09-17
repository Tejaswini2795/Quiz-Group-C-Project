package com.velocity.queez.result;

public class Result {
	int resultId;
	int studentId;
	int marks;
	char grade;
	
	public Result() {
		super();
	}

	public Result(int resultId, int studentId, int marks, char grade) {
		super();
		this.resultId = resultId;
		this.studentId = studentId;
		this.marks = marks;
		this.grade = grade;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", studentId=" + studentId + ", marks=" + marks + ", grade=" + grade
				+ "]";
	}

}
