package polito;

import polito.Exams;
import polito.Students;
import polito.University;

public class Courses {
	private String title;
	private String teacherName;
	private int courseCode;
	private Students[] students;
	private Exams[] exams;
	private double courseAverage = 0.0;
	
	public Courses(int courseCode, String title, String teacherName) {
		this.title = title;
		this.teacherName = teacherName;
		this.courseCode = courseCode;
		students = new Students[University.MAX_STUDENTS_PER_COURSE];
		exams = new Exams[University.MAX_EXAM_LEN];
	}
	
	@Override
	public String toString() {
		return (this.courseCode + "," + this.title + "," + this.teacherName); 
	}
	public void enrollStudentForCourse(Students s) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = s;
				break;
			}
		}
	}
	
	public String attendees() {
		StringBuffer result = new StringBuffer();
		
		for (Students s : students) {
			if (s != null) {
				result.append(s).append("\n");
			}
		}
		return result.toString();
	}
	
	private int id = 0;
	public void registerExamsforCourses(Exams e) {
		exams[id++] = e;
	}
}