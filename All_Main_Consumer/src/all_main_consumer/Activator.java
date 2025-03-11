package all_main_consumer;

import finance_consumer.FinanceConsumerActivator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import student_consumer.Student_Consumer_Activator;
import teacher_consumer.Teacher_Consumer_Activator;
import timetable_consumer.Timetable_Consumer_Activator;

public class Activator implements BundleActivator {

	Timetable_Consumer_Activator timetable = new Timetable_Consumer_Activator();
	FinanceConsumerActivator finance = new FinanceConsumerActivator();
	Teacher_Consumer_Activator teacher = new Teacher_Consumer_Activator();
	Student_Consumer_Activator student = new Student_Consumer_Activator();
	
	public void start(BundleContext bundleContext) throws Exception {
		Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
        	System.out.println("---------------------------------------------------------------");
            System.out.println("             ~ Welcome to NextGen Institute ~                  ");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Student Management");
            System.out.println("2. Staff Management");
            System.out.println("3. Financial Management");
            System.out.println("4. Timetable Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice to continue: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        student.start(bundleContext);
                        break;
                    case 2:
                        teacher.start(bundleContext);
                        break;
                    case 3:
                    	finance.start(bundleContext);
                        break;
                    case 4:
                       timetable.start(bundleContext);
                       break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Please enter a valid choice.");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Bye");
	}

}
