package itcollege.data;

import java.util.ArrayList;

public class DataCollections {
	
	public ArrayList<Admin> admins;	
	public ArrayList<Course> courses;
	public ArrayList<Subject> subjects;
	public ArrayList<Exam> exams;
	public ArrayList<MarkSheet> markSheets;
	public ArrayList<Student> students;
	public ArrayList<Batch> batchs;
	
	
	
	public DataCollections() {
		createAdmins();
		createSubjects();
		createCourses();
		createBatchs();
		createExams();
		createStudents();
		createMarkSheets();
	}

	private void createAdmins() {
		admins = new ArrayList<Admin>();
		admins.add(createAdmin("s", "s"));
	}
	
	private Admin createAdmin(String name, String pwd) {
		Admin o = new Admin();
		o.name= name;
		o.pwd =pwd;
		return o;
	}
	
	private void createSubjects() {
		subjects = new ArrayList<Subject>();
		subjects.add(createSubject("est", "Estonian"));
		subjects.add(createSubject("eng", "English"));
		subjects.add(createSubject("soc", "Social Ethics"));
		subjects.add(createSubject("net", "Networking"));
		subjects.add(createSubject("jav", "Java Programing"));
		subjects.add(createSubject("inf", "Informatics"));
		subjects.add(createSubject("mat", "Mathematics"));
		subjects.add(createSubject("gen", "Genetics"));
		subjects.add(createSubject("che", "Bio Chemistry"));
		subjects.add(createSubject("ele", "Electronics"));
		subjects.add(createSubject("elt", "Electricals"));
		subjects.add(createSubject("mec", "Mechanics"));
		subjects.add(createSubject("dat", "Data Analysis"));
		subjects.add(createSubject("img", "Imaging Technology"));
		subjects.add(createSubject("mtr", "Matrix"));
		
	} 
	
	private Subject createSubject(String code, String name) {
		Subject o = new Subject();
		o.name= name;
		o.code =code;
		return o;
	}
	
	public Subject getSubject(String code) {
		for(Subject o : subjects)
		{
			if(o.code == code){
				return o;
			}
		}
		return null;
	}
	
	private void createCourses() {
		courses = new ArrayList<Course>();
		ArrayList<Subject> s;
		s= new ArrayList<Subject>();
		s.add(getSubject("est"));
		s.add(getSubject("eng"));
		s.add(getSubject("jav"));
		s.add(getSubject("inf"));
		s.add(getSubject("soc"));
		s.add(getSubject("net"));
		courses.add(createCourse("CSE", "CyberSecurity Engineering",s));
		
		s= new ArrayList<Subject>();
		s.add(getSubject("est"));
		s.add(getSubject("eng"));
		s.add(getSubject("soc"));
		s.add(getSubject("mat"));
		s.add(getSubject("gen"));
		s.add(getSubject("che"));
		courses.add(createCourse("BME", "BioMedical Engineering",s));
		
		s= new ArrayList<Subject>();
		s.add(getSubject("est"));
		s.add(getSubject("eng"));
		s.add(getSubject("soc"));
		s.add(getSubject("dat"));
		s.add(getSubject("img"));
		s.add(getSubject("mtr"));
		courses.add(createCourse("RBE", "Robotical Engineering",s));
		
		s= new ArrayList<Subject>();
		s.add(getSubject("est"));
		s.add(getSubject("eng"));
		s.add(getSubject("soc"));
		s.add(getSubject("ele"));
		s.add(getSubject("elt"));
		s.add(getSubject("mec"));
		courses.add(createCourse("MCE", "Mechanical Engineering",s));
		
	} 
	
	private Course createCourse(String code, String name, ArrayList<Subject> subjects) {
		Course o = new Course();
		o.name= name;
		o.code =code;
		o.subjects = subjects;
		return o;
	}
	
	private void createBatchs() {
		batchs = new ArrayList<Batch>();
		for(Course c : courses)
		{
			batchs.add(createBatch(c.code));
		}
	}
	
	private void createMarkSheets() {
		markSheets = new ArrayList<MarkSheet>();
	}
	
	public MarkSheet getMarkSheet(String examId,int stdId) {
		for(MarkSheet o : markSheets)
		{
			if(examId.equals(o.exmId) && o.stdId == stdId){
				return o;
			} 
		}
		return null;
	}
	
	public Mark createMark(String code, int mark) {
		Mark o = new Mark();
		o.mark= mark;
		o.code =code;
		return o;
	}
	
	public void addMarkSheet(String examId,int stdId, ArrayList<Mark> marks) {
		MarkSheet ms = getMarkSheet(examId,stdId);
		if(ms == null){
			ms = new MarkSheet();
			ms.exmId = examId;
			ms.stdId = stdId;
			ms.marks = marks;
			markSheets.add(ms);
		}else{
			ms.marks = marks;
		}
	}
	
	private Batch createBatch(String code) {
		Batch o = new Batch();
		o.code= code;
		o.students =new ArrayList<Student>();
		return o;
	}
	
	public Batch getBatch(String code) {
		for(Batch o : batchs)
		{
			if(o.code == code){
				return o;
			}
		}
		return null;
	}
	
	private void createExams() {
		exams = new ArrayList<Exam>();
		exams.add(createExam("exam1", "Sem1"));
		exams.add(createExam("exam2", "Sem2"));
		exams.add(createExam("exam3", "Sem3"));
		exams.add(createExam("exam4", "Sem4"));
	}
	
	private Exam createExam(String name, String code) {
		Exam o = new Exam();
		o.name= name;
		o.code =code;
		return o;
	}
	
	private void createStudents() {
		students = new ArrayList<Student>();
		
		addStudent(sequenceStudentId(), "Raj", courses.get(0).code);
		addStudent(sequenceStudentId(), "Sumi", courses.get(1).code);
		addStudent(sequenceStudentId(), "Tanu", courses.get(2).code);
		addStudent(sequenceStudentId(), "Sheela", courses.get(3).code);
	}
	
	private Student createStudent(int id,String name, String code) {
		Student o = new Student();
		o.name= name;
		o.id =id;
		o.courseCode = code;
		return o;
	}
	
	public void addStudent(int id,String name, String code) {
		Student student = createStudent(id,name,code);
		students.add(id,student);
		
		Batch b = getBatch(code);
	
		b.students.add(student);
	}

	
	public boolean validAdmin(String name, String pwd) {
		name = name.trim();
		pwd = pwd.trim();
		
		for(Admin o : admins)
		{
			if(name.equals(o.name) && pwd.equals(o.pwd)){
				return true;
			}
		}

		 return false;
	}
	
	public int sequenceStudentId() {
		return students.size();
	}

	public Course getCourse(String code) {
		for(Course o : courses)
		{
			if(o.code == code){
				return o;
			}
		}
		return null;
	}

	public Student getStudent(int stdId) {
		for(Student o : students)
		{
			if(o.id == stdId){
				return o;
			}
		}
		return null;
	}
		
}
