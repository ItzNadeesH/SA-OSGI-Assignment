package finance_producer;

import java.util.ArrayList;
import java.util.Scanner;

public class FinanceServiceImpl implements FinanceService {

    private ArrayList<Finance> financeDetails = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public FinanceServiceImpl() {
        // Add sample data to the financeDetails array
    	financeDetails.add(new Finance("1234567890123", "Kamal", "Science", "8", getCurrentDate(), 750.0, "April"));
    	financeDetails.add(new Finance("9876543210987", "Samantha", "English", "7", getCurrentDate(), 600.0, "May"));
    	financeDetails.add(new Finance("5647382910123", "Nimal", "History", "9", getCurrentDate(), 450.0, "June"));
    	financeDetails.add(new Finance("9081726354890", "Sunil", "Physics", "10", getCurrentDate(), 800.0, "July"));
    	financeDetails.add(new Finance("3412789654321", "Rashmi", "Chemistry", "11", getCurrentDate(), 950.0, "August"));
    }

    @Override
    public void displayFinance() {
        showFinanceDetails();
    }

    @Override
    public void addFinanceDetails() {
        System.out.print("\nEnter student name:");
        String name = scanner.nextLine();

        System.out.print("Enter subject:");
        String subject = scanner.nextLine();

        System.out.print("Enter grade:");
        String grade = scanner.nextLine();
        
        System.out.print("Enter month:");
        String month = scanner.nextLine();

        System.out.print("Enter amount:");
        double amount = scanner.nextDouble();

        String id = generateShortUniqueId();

        Finance newFinance = new Finance(id, name, subject, grade, getCurrentDate(), amount, month);
        financeDetails.add(newFinance);
        System.out.println(" Finance details added successfully! ");
    }

    @Override
    public void showFinanceDetails() {
        System.out.println("FeeID\t\t Student Name\t Subject\t Grade\t Date\t\t Amount\t\t Month\t");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        for (Finance finance : financeDetails) {
            System.out.printf("%-16s %-15s %-15s %-7s %-15s %-15f %-6s%n",
                    finance.getId(), finance.getStudentName(), finance.getClassName(),
                    finance.getGrade(), finance.getDate(), finance.getAmount(), finance.getMonth());
        }
    }

    @Override
    public void calculateTotalCollectedFees() {
        double totalCollectedFees = 0;
        for (Finance finance : financeDetails) {
            totalCollectedFees += finance.getAmount();
        }
        System.out.println("Total Collected Fees: " + totalCollectedFees);
    }

    private String generateShortUniqueId() {
        return Long.toString(System.currentTimeMillis());
    }

    private String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

    @Override
    public void getTotalPaidForSubject() {
    	System.out.print("Enter subject:");
        String subjectName = scanner.nextLine();
        double totalPaidForSubject = 0;

        for (Finance finance : financeDetails) {
            if (finance.getClassName().equals(subjectName)) {
                totalPaidForSubject += finance.getAmount();
            }
        }
        System.out.println("Total Paid for " + subjectName + ": " + totalPaidForSubject );
    }
}
