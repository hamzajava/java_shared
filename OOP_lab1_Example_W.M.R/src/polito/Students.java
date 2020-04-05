package polito;

import polito.Courses;
import polito.Exams;
import polito.University;

public class Students {
	private String firstName;
	private String lastName;
	private int iD;
	private Courses[] courses;
	private Exams[] exams;
	private int sum = 0;
	private double avg = 0.0;
	public static int id = 0; 
	
	
	public Students(int iD, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		courses = new Courses[University.MAX_COURSES_PER_STUDENTS];
		exams = new Exams[University.MAX_EXAM_LEN];
	}
	
	public int getiD()
	{
		return iD;
	}
	@Override
	public String toString() {
		return this.iD + " " + this.firstName + " " + this.lastName;
	}
	public void enrollCourseForStudent(Courses c) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				courses[i] = c;
				break;
			}
		}
	}
	
	public String courses() {
		StringBuffer result = new StringBuffer();
		
		for(Courses c : courses) {
			if (c != null) {
				result.append(c).append("\n");
			}
		}
		return result.toString();
	}
	
	public void registerExamsforStudents(Exams e) {
		exams[id++] = e;
	}
	
	public double STUDENT_WITH_AVERAGE() {
		for(int i = 0; i < id; i++) {
			sum = sum + exams[i].getPoints();
		}
		avg = sum/(id);
		
		return avg;
	}
	
	/*public Exams[] getExams() {
		
		Exams[] tempexams = new Exams[id-1];
		
		for (int i = 0; i < id; i++) {
			tempexams[i] = exams[i];
		}
		return tempexams;
	}*/
	
}