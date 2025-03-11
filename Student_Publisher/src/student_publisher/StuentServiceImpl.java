package student_publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StuentServiceImpl implements StudentService{

	    private Scanner scan;
	    
	    private List<Student> enrolledStudents;

	    public StuentServiceImpl() {
	        scan = new Scanner(System.in);
	        enrolledStudents = new ArrayList<>();
	        enrolledStudents.add(new Student("S001", "Alice Johnson", "7", "alice@example.com", "123-456-7890"));
	        enrolledStudents.add(new Student("S002", "Bob Smith", "11", "bob@example.com", "987-654-3210"));
	        enrolledStudents.add(new Student("S003", "Charlie Brown", "9", "charlie@example.com", "555-123-6789"));
	    }
	    
	    @Override
	    public List<Student> getStudentAll() {
	   
	        System.out.printf("%-15s %-20s %-10s %-30s %-15s%n", "Student ID", "Name", "Grade", "Email", "Contact");
	        System.out.println("---------------------------------------------------------------------------------------------");
	        for (Student student : enrolledStudents) {
	            System.out.printf("%-15s %-20s %-10s %-30s %-15s%n",
	            		student.getsID(), student.getName(), student.getGrade(), student.getEmail(), student.getContact());
	        }
	        
	        return enrolledStudents;
	    }
	    
	    @Override
	    public Student searchStudentById(String studentID) {
	        Student student = findStudentById(studentID);
	        if (student != null) {
	            // Print student details
	            System.out.println("Student Details:");
	            System.out.println("ID: " + student.getsID());
	            System.out.println("Name: " + student.getName());
	            System.out.println("Grade: " + student.getGrade());
	            System.out.println("Email: " + student.getEmail());
	            System.out.println("Contact: " + student.getContact());
	        } else {
	            System.out.println("Student with ID " + studentID + " not found.");
	        }
	        return student;
	    }   

	    @Override
	    public void insertStudentDetails() {
	        String sID, name, grade, email, contact;

	        System.out.println("\n------- Register New Student To System --------");
	        System.out.print("Enter Student's ID: ");
	        sID = scan.nextLine();
	        System.out.print("Enter Student's name: ");
	        name = scan.nextLine();
	        System.out.print("Enter Student's grade: ");
	        grade = scan.nextLine();
	        System.out.print("Enter Student's email: ");
	        email = scan.nextLine();
	        System.out.print("Enter Student's contact number: ");
	        contact = scan.nextLine();
	        
	        enrolledStudents.add(new Student(sID, name, grade, email, contact));
	    }
	    
	    @Override
	    public void updateStudentDetails(String studentID) {
	        Student studentToUpdate = findStudentById(studentID);
	        if (studentToUpdate != null) {
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("Enter updated details for student with ID " + studentID + ":");
	            System.out.print("Name: ");
	            String name = scanner.nextLine();
	            System.out.print("Grade: ");
	            String grade = scanner.nextLine();
	            System.out.print("Email: ");
	            String email = scanner.nextLine();
	            System.out.print("Contact: ");
	            String contact = scanner.nextLine();

	            // Update the student details
	            studentToUpdate.setName(name);
	            studentToUpdate.setGrade(grade);
	            studentToUpdate.setEmail(email);
	            studentToUpdate.setContact(contact);

	            System.out.println("Student details updated successfully.");
	        } else {
	            System.out.println("Student with ID " + studentID + " not found.");
	        }
	    }

	    @Override
	    public void deleteStudent(String studentID) {
	    	Student student = findStudentById(studentID);
	    	 if (student != null) {
	    		 enrolledStudents.remove(student);
	    		 System.out.println("Student details updated successfully.");
	    	 } else {
	    		 System.out.println("Student with ID " + studentID + " not found.");
	    	 }
	    }
	    
	    @Override
	    public void enrollForSubjects(String studentID) {
	        Student student = findStudentById(studentID); // Find the student
	        if (student != null) {
	            // **Ensure student is not already added to enrolledStudents list**
	            if (!enrolledStudents.contains(student)) {
	                enrolledStudents.add(student); // Add student to enrolledStudents list
	            }
	            
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("Enter subjects to enroll (comma-separated): ");
	            String subjectsInput = scanner.nextLine();
	            List<String> subjects = new ArrayList<>();
	            for (String subject : subjectsInput.split(",")) {
	                subjects.add(subject.trim());
	            }
	            student.setEnrolledSubjects(subjects); // Set enrolled subjects for the student
	            System.out.println("Student with ID " + studentID + " enrolled for subjects: " + subjects);
	        } else {
	            System.out.println("Student with ID " + studentID + " not found.");
	        }
	    }
	    
	    public void getSubjectsByStudentId(String studentID) {
	    	Student student = findStudentById(studentID);
	    	if (student != null) {
	    		for (String subject : student.getEnrolledSubjects()) {
	    		    System.out.println(subject);
	    		}
	    	 } else {
	    		 System.out.println("Student with ID " + studentID + " not found.");
	    	 }
	    }
	    
	    private Student findStudentById(String studentID) {
	        // Iterate through the list of enrolled students
	        for (Student student : enrolledStudents) {
	            // Check if the student ID matches the provided studentID
	            if (student.getsID().equals(studentID)) {
	                // Return the student if found
	                return student;
	            }
	        }
	        
	        return null;
	    }

}
