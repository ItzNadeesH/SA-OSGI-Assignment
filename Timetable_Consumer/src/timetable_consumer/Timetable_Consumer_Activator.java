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
	         System.out.println("1. Display Timetable All Timetables");
	         System.out.println("2. Display Timetable by Grade");
	         System.out.println("3. Create a Timetable");
	         System.out.println("4. Delete Timetable");
	         System.out.println("5. View All Teachers");
	         System.out.println("6. Exit");
	         
	         System.out.print("Enter your choice: ");
	         int choice = scan.nextInt();
	         scan.nextLine();
	         switch (choice) {
	         case 1:
	             
	             timetableService.displayAllTimetables();
	             break;
	         case 2:
	        	 System.out.print("Enter the grade (6-11): ");
	             int grade = scan.nextInt();
	        	 timetableService.displayTimetable(grade);
	             break;
	         case 3:
	        	 System.out.print("Enter the grade (6-11): ");
	             int grde = scan.nextInt();
	        	 timetableService.createNewTimetable(grde);
	             break;
	         case 4:
	        	 System.out.print("Enter the grade (6-11): ");
	             int grd = scan.nextInt();
	        	 timetableService.deleteTimetable(grd);
	             break;
	         case 5:
	        	 teacherService.displayTeachers();
	             break;
	         case 6:
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
