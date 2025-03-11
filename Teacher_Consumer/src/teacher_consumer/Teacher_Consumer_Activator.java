package teacher_consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import teacher_producer.TeacherService;

public class Teacher_Consumer_Activator implements BundleActivator {
	 
	ServiceReference<?> serviceReference ;
	private Scanner scan;
    
	public void start(BundleContext context) throws Exception {
	    System.out.println("Teacher Subscriber Start");
	    serviceReference = context.getServiceReference(TeacherService.class.getName());
	    
	    TeacherService teacherService = (TeacherService) context.getService(serviceReference);
	    scan = new Scanner(System.in);
        
        
	    while (true) {
	    	System.out.println("\n--------------Choose an option from Staff Management--------------");
	        System.out.println("1. Insert a New Teacher");
	        System.out.println("2. Display Teachers List");
	        System.out.println("3. Update Teacher Details");
	        System.out.println("4. Delete Teacher");
	        System.out.println("5. Assign Subjects for Teacher");
	        System.out.println("6. Search Teacher");
	        System.out.println("7. Exit");

	        System.out.print("Enter your choice: ");
	        int choice = scan.nextInt();
	        scan.nextLine(); // Consume newline character
	        
	        switch (choice) {
	            case 1:
	                teacherService.createTeacher();
	                break;
	            case 2:
	                teacherService.displayTeachers();
	                break;
	            case 3:
	            	teacherService.editTeacher();
	                break;
	            case 4:
	            	System.out.print("\nEnter the ID of the teacher you want to delete: ");
	                String teacherID = scan.nextLine();
	                teacherService.deleteTeacher(teacherID);
	                break;    
	            case 5:
	            	System.out.println("\nAssign Subject to the Teacher");
	            	System.out.print("\nEnter the ID of the teacher: ");
	                String tID = scan.nextLine();
	                teacherService.assignCourses(tID);
	                break;
	            case 6:
	            	System.out.println("\nSearch Teacher");
	            	System.out.print("\nEnter the ID of the teacher you want to search: ");
	                String tchID = scan.nextLine();
	            	teacherService.searchTeacher(tchID);
	            	break;
	            case 7:
	            	System.out.println("\nExiting...");
	                return;
	            default:
	            	System.out.println("\nInvalid choice! Please try again.");
	        }
	    }
	
	}

 
	public void stop(BundleContext context) throws Exception {
		System.out.println("Student Subscriber Stop");
		context.ungetService(serviceReference);
	}
 
}