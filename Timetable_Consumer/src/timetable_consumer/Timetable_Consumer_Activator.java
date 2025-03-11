package timetable_consumer;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import teacher_producer.TeacherService;
import timetable_producer.TimetableService;

public class Timetable_Consumer_Activator implements BundleActivator {

    ServiceReference<?> timetableServiceReference;
    ServiceReference<?> teacherServiceReference;
    private Scanner scan;

    public void start(BundleContext context) throws Exception {
        System.out.println("Start Timetable Consumer");
        timetableServiceReference = context.getServiceReference(TimetableService.class.getName());
        TimetableService timetableService = (TimetableService) context.getService(timetableServiceReference);
        
        teacherServiceReference = context.getServiceReference(TeacherService.class.getName());
        TeacherService teacherService = (TeacherService) context.getService(teacherServiceReference);
        
        while (true) {
        	scan = new Scanner(System.in);
   		 	
	   		 System.out.println("\n--------------Choose an option from Timetable Management--------------");
	         System.out.println("1. Display Timetable");
	         System.out.println("2. Assign Teachers to Subject");
	         System.out.println("3. Display Teachers with Subjects");
	         System.out.println("4. Update Teacher Assign to Subject");
	         System.out.println("5. Exit");
	         
	         System.out.print("Enter your choice: ");
	         int choice = scan.nextInt();
	         scan.nextLine();
	         switch (choice) {
	         case 1:
	             System.out.print("Enter the grade (6-11): ");
	             int grade = scan.nextInt();
	             timetableService.displayTimetable(grade);
	             break;
	         case 2:
	         	teacherService.displayTeachers();
	         	// teacherService.assignTeachers();
	             break;
	         case 3:
	         	System.out.print("Enter the grade (6-11): ");
	             teacherService.displayTeachers();
	             break;
	         case 4:
	        	 teacherService.editTeacher();
	             break;
	         case 5:
	        	 System.out.println("Exiting...");
	             return;
	         default:
	             System.out.println("\nInvalid choice. Please try again.");   
	         }
        }     		
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Good Bye");
        context.ungetService(timetableServiceReference);
        context.ungetService(teacherServiceReference);
    }
}
