	package polito;
	import java.util.*;
	
	/**
	 * This class represents a university education system.
	 * 
	 * It manages students and courses.
	 *
	 */
	public class University {
		private String name;
		private String firstName;
		private String lastName;
		private String rectorName;
		public static final int MAX_STUDENTS = 1000;
		public static final int INITIAL_ID = 10000;
		private Students[] students;
		private int nextId = INITIAL_ID;
		private Courses[] courses;
		public static final int MAX_COURSES = 50;
		public static final int INITIAL_COURSE = 10;
		private int nextCourse = INITIAL_COURSE;
		public static final int MAX_STUDENTS_PER_COURSE = 100;
		public static final int MAX_COURSES_PER_STUDENTS = 25;
		private Exams[] exams;
		public static final int MAX_EXAM_LEN=11;
		//List<Exams> exams= new LinkedList<>();
		private double studentAverage = 0.0;
		private double courseAverage = 0.0;
		private double points = 0.0;
		private int examId = 0;
		
	
		/**
		 * Constructor
		 * @param name name of the university
		 */
		public University(String name){
			//TODO: to be implemented
			this.name = name;
			students = new Students[MAX_STUDENTS];
			courses = new Courses[MAX_COURSES];
			exams= new Exams[MAX_EXAM_LEN];
		}
		
		/**
		 * Getter for the name of the university
		 * @return name of university
		 */
		public String getName(){
			//TODO: to be implemented
			return name;
		}
		
		/**
		 * Defines the rector for the university
		 * 
		 * @param first
		 * @param last
		 */
		public void setRector(String first, String last){
			//TODO: to be implemented
			this.firstName = first;
			this.lastName = last;
			this.rectorName = firstName + " " + lastName;
		}
		
		/**
		 * Retrieves the rector of the university
		 * 
		 * @return
		 */
		public String getRector(){
			//TODO: to be implemented
			return this.rectorName;
		}
		
		/**
		 * Enroll a student in the university
		 * 
		 * @param first first name of the student
		 * @param last last name of the student
		 * @return
		 */
		public int enroll(String first, String last){
			//TODO: to be implemented
			Students s = new Students(nextId, first, last);
			students[nextId-INITIAL_ID] = s;
			return nextId++;
		}
		
		/**
		 * Retrieves the information for a given student
		 * 
		 * @param id the id of the student
		 * @return information about the student
		 */
		public String student(int id){
			//TODO: to be implemented
			Students s = students[id-INITIAL_ID];
			return s.toString();
		}
		
		/**
		 * Activates a new course with the given teacher
		 * 
		 * @param title title of the course
		 * @param teacher name of the teacher
		 * @return the unique code assigned to the course
		 */
		public int activate(String title, String teacher){
			//TODO: to be implemented
			Courses c = new Courses(nextCourse, title, teacher);
			courses[nextCourse-INITIAL_COURSE] = c;
			
			return nextCourse++;
		}
		
		/**
		 * Retrieve the information for a given course
		 * 
		 * @param code unique code of the course
		 * @return information about the course
		 */
		public String course(int code){
			//TODO: to be implemented
			Courses c = courses[code-INITIAL_COURSE];
			return c.toString();
		}
		
		/**
		 * Register a student to attend a course
		 * @param studentID id of the student
		 * @param courseCode id of the course
		 */
		public void register(int studentID, int courseCode){
			//TODO: to be implemented
			Students s = students[studentID-INITIAL_ID];
			Courses c = courses[courseCode-INITIAL_COURSE];
			s.enrollCourseForStudent(c);
			c.enrollStudentForCourse(s);
		}
		
		/**
		 * Retrieve a list of attendees
		 * 
		 * @param courseCode unique id of the course
		 * @return list of attendees separated by "\n"
		 */
		public String listAttendees(int courseCode){
			//TODO: to be implemented
			Courses c = courses[courseCode-INITIAL_COURSE];
			
			return c.attendees();
		}
	
		/**
		 * Retrieves the study plan for a student
		 * 
		 * @param studentID id of the student
		 * @return list of courses the student is registered for
		 */
		public String studyPlan(int studentID){
			//TODO: to be implemented
			Students s = students[studentID-INITIAL_ID];
			
			return s.courses();
		}
		
		//TO BE IMPLEMENTED
		/**
		 * Register score for a student that took an exam
		 * 
		 * @param studentID unique id of the student
		 * @param courseCode unique id of the course
		 * @param point number of points the student won
		 */
		public static int id=0;
		public void exam(int studentID, int courseCode, int points) {
			Students s = students[studentID-INITIAL_ID];
			Courses c = courses[courseCode-INITIAL_COURSE];
			Exams e= new Exams(points ,courseCode, studentID);
			exams[id++]=e;
			s.registerExamsforStudents(e);
			c.registerExamsforCourses(e);
				
		}
			
		/**
		 * Retrieve average number of points for a student
		 * 
		 * @param studentID unique id of the student
		 * @return string containing the id of the student and averaged points
		 */
		
		
		
		public String studentAvg(int studentID) {
			
			Students s = students[studentID-INITIAL_ID];
			/*if (s.getExams().length==0) {
				return "Student STUDENT_ID hasn't taken any exams";
			}
			*/
			if (students[studentID-INITIAL_ID].id==0) {
				return "Student STUDENT_ID hasn't taken any exams";
			}
			return s.getiD() + " " + s.STUDENT_WITH_AVERAGE();
		}
		
		/**
		 * Retrieve average number of points for a course
		 * 
		 * @param courseID unique id of the course
		 * @return string containing the id of the course and averaged points	
		 */
		public String courseAvg(int courseID) {
			return null;
		}
		
		/**
		 * Retrieve a list of top 3 students
		 * 
		 * @return list of students separated by "\n"
		 */
		public String topThreeStudents() {
			return null;
		}
	}