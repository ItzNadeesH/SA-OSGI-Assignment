package finance_consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import finance_producer.FinanceService;

public class FinanceConsumerActivator implements BundleActivator {

    ServiceReference<?> serviceReference;
    private Scanner scan;

    public void start(BundleContext context) throws Exception {
        System.out.println("Start FinanceConsumer");
        serviceReference = context.getServiceReference(FinanceService.class.getName());
        FinanceService financeService = (FinanceService) context.getService(serviceReference);
        
        scan = new Scanner(System.in);
        
        while (true) {
        	System.out.println("\n--------------Choose an option from Finance Management--------------");
            System.out.println("1. Collect Class Fees");
            System.out.println("2. Display Paid Details");
            System.out.println("3. Calculate Total Collected Fees");
            System.out.println("4. Get Total Paid for a Subject");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    financeService.addFinanceDetails();
                    break;
                case 2:
                    financeService.showFinanceDetails();
                    break;
                case 3:
                    financeService.calculateTotalCollectedFees();
                    break;
                case 4:
                    financeService.getTotalPaidForSubject();
                    break;
                case 5:
                	System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        	
        }

    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Good Bye");
        context.ungetService(serviceReference);
    }
}
