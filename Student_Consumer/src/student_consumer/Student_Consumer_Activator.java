package student_consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import student_publisher.StudentService;

public class Student_Consumer_Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	private Scanner scan;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Student Consumer Start");
		serviceReference = context.getServiceReference(StudentService.class.getName());
		StudentService studentService = (StudentService)context.getService(serviceReference);
			
		 scan = new Scanner(System.in);
		
	    while (true) {
            System.out.println("\n--------------Choose an option from Student Management--------------");
            System.out.println("1. Insert a New Student");
            System.out.println("2. Get All Student Details");
            System.out.println("3. Search Student Details");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Enroll Student for Subjects");
            System.out.println("7. Get Student's enrolled Subjects");
            System.out.println("8. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                	studentService.insertStudentDetails();
                    break;
                case 2:
                	studentService.getStudentAll();
                    break;
                case 3:
                	System.out.println("\nEnter the ID of student to display details");
  				    String stu = scan.nextLine();
                	studentService.searchStudentById(stu);
                    break;
                case 4:
                	System.out.println("\nEnter the Student ID of student to Update details");
  				    String student = scan.nextLine();
                	studentService.updateStudentDetails(student);
                    break;
                case 5:
                    System.out.println("\nEnter the ID of the Member you want to Delete");
  				    String sID = scan.nextLine();
                	studentService.deleteStudent(sID);
                    break;
                case 6:
                	System.out.println("\nEnter the ID of the student to add subjects");
    				String SID = scan.nextLine();
                	studentService.enrollForSubjects(SID);
                    break;
                case 7:
                	System.out.println("\nEnter the ID of the student get subjects");
    				String id = scan.nextLine();
                	studentService.getSubjectsByStudentId(id);
                	break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Student Subscriber Stop");
		context.ungetService(serviceReference);
		
	}

}
