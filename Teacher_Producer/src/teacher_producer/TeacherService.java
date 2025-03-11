package teacher_producer;


public interface TeacherService {
    public void displayTeachers();

    void createTeacher();

    void editTeacher();

    void deleteTeacher(String teacherID);
    
    void searchTeacher(String teacherID);

	void assignSubject(String teacherID);
    
}
