package teacher_producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TeacherServiceImpl implements TeacherService {
    private Scanner scan;
    
    private List<Teacher> registeredTeachers;

    public TeacherServiceImpl() {
    	scan = new Scanner(System.in);
    	registeredTeachers = new ArrayList<>();
    	 registeredTeachers.add(new Teacher("T001", "John Doe", "john.doe@example.com", "111-222-3333"));
         registeredTeachers.add(new Teacher("T002", "Sarah Smith", "sarah.smith@example.com", "444-555-6666"));
         registeredTeachers.add(new Teacher("T003", "Michael Brown", "michael.brown@example.com", "777-888-9999"));
    }

    @Override
    public void createTeacher() {
        String teacherID, name, email, contact;

        System.out.println("Register New Teacher To System");

        System.out.print("Teacher's ID: ");
        teacherID = scan.nextLine();

        System.out.print("Teacher's Name: ");
        name = scan.nextLine();

        System.out.print("Teacher's Email: ");
        email = scan.nextLine();

        System.out.print("Teacher's Contact Number: ");
        contact = scan.nextLine();

        registeredTeachers.add(new Teacher(teacherID, name, email, contact));
    }
    
    
    @Override
    public void displayTeachers() {
        
        System.out.printf("%-15s %-20s %-10s %-30s%n", "TeacherID", "Name", "Email", "Contact No");
        System.out.println("---------------------------------------------------------------------");

        for (Teacher teacher : registeredTeachers) {
        	System.out.printf("%-15s %-20s %-10s %-30s%n",
        			teacher.getTeacherID(), teacher.getName(), teacher.getEmail(), teacher.getContact());
        }
    }



    @Override
    public void editTeacher() {
        System.out.println("Edit Teacher Profile");
       
        System.out.print("Enter Teacher's ID: ");
        String teacherID = scan.nextLine();

        Teacher teacherToEdit = findTeacherById(teacherID);
        if (teacherToEdit != null) {
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Enter updated details for Teacher with ID " + teacherID + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Contact: ");
            String contact = scanner.nextLine();

            // Update the student details
            teacherToEdit.setName(name);
            teacherToEdit.setEmail(email);
            teacherToEdit.setContact(contact);;

            System.out.println("Teacher details updated successfully.");
        } else {
        	 System.err.println("\nTeacher not found with ID: " + teacherID);
        }
    }

   
    
    @Override
    public void deleteTeacher(String teacherID) {
    	 Teacher teacher = findTeacherById(teacherID);
         if (teacher != null) {
        	 registeredTeachers.remove(teacher);
         } else {
        	 System.out.println("Teacher with ID " + teacherID + " not found.");
         }
    }
    
    
    @Override
    public void assignCourses(String teacherID) {
        Teacher teacher = findTeacherById(teacherID);
        if (teacher != null) {
                System.out.print("\nEnter subjects to assign (comma-separated): ");
                String subjectsInput = scan.nextLine();
                List<String> subjects = Arrays.asList(subjectsInput.split("\\s*,\\s*"));

                // Update the assigned subjects for the teacher
                List<String> currentSubjects = teacher.getAssignedCourses();
                currentSubjects.addAll(subjects);
                teacher.setAssignedCourses(currentSubjects);

                // Update the file with the assigned subjects

                System.out.println("Subjects assigned successfully.");
            
        } else {
            System.err.println("\nTeacher not found with ID: " + teacherID);
        }
    }

   
    private Teacher findTeacherById(String teacherID) {
        for (Teacher teacher : registeredTeachers) {
            if (teacher.getTeacherID().equals(teacherID)) {
                return teacher;
            }
        }
        return null;
    }
    
	@Override
	public void searchTeacher(String teacherID) {
        Teacher teacher = findTeacherById(teacherID);
        if (teacher != null) {
        	System.out.println("\n  Teacher Details:");
            System.out.println("Teacher ID    - " + teacher.getTeacherID());
            System.out.println("Name          - " + teacher.getName());
            System.out.println("Email         - " + teacher.getEmail());
            System.out.println("Contact       - " + teacher.getContact());
        } else {
            System.err.println("\n Teacher not found with ID: " + teacherID);
        }
    }

}
