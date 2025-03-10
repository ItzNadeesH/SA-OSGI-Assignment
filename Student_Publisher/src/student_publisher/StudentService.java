package student_publisher;

import java.util.List;

public interface StudentService {

	void insertStudentDetails();

	void deleteStudent(String studentID);

	List<Student> getStudentAll();

	void enrollForSubjects(String studentID);

	public Student searchStudentById(String studentID);

	void updateStudentDetails(String studentID);
	
	public void getSubjectsByStudentId(String studentID);
}
