package timetable_producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimetableServiceImpl implements TimetableService {

    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private Map<Integer, List<Subject>> timetables = new HashMap<>();

    public TimetableServiceImpl() {
    	timetables.put(6, new ArrayList<>());
        timetables.get(6).add(new Subject("Science", "John Doe", "09:00", "11:00", "Monday"));
        timetables.get(6).add(new Subject("Maths", "John Doe", "11:00", "13:00", "Tuesday"));
        timetables.get(6).add(new Subject("English", "John Doe", "14:00", "16:00", "Wednesday"));
        timetables.get(6).add(new Subject("History", "John Doe", "16:00", "18:00", "Thursday"));
        timetables.get(6).add(new Subject("Geography", "John Doe", "18:00", "20:00", "Friday"));
        
    }
    
    @Override
    public void displayAllTimetables() {
        for (int grade = 6; grade <= 11; grade++) {
        	displayTimetable(grade);
        }
    }

    public void displayTimetable(int grade) {
        if (grade < 6 || grade > 11) {
            System.out.println("Invalid grade. Grade should be between 6 and 11.");
            return;
        }
        
        // Retrieve the timetable for the specified grade
        List<Subject> timetable = timetables.get(grade); 
        
        if (timetable == null) {
        	System.out.println("\nTimetable is not created for grade " + grade);
        	return;
        }

        System.out.println("\nGrade " + grade + " Time Table");
        System.out.println("Day                  Time                 Subject         Teacher");
        System.out.println("------------------------------------------------------------------------");

        for (Subject subject : timetable) {
            System.out.printf("%-20s %-2s - %-12s %-15s %-20s\n",
                subject.getDay(), subject.getStartTime(), subject.getEndTime(), subject.getName(), subject.getTeacher());
        }
    }
    
    @Override
    public void createNewTimetable(int grade) {
        if (grade < 6 || grade > 11) {
            System.out.println("Invalid grade. Grade should be between 6 and 11.");
            return;
        }

        // Clear the existing timetable for the given grade
        if (timetables.get(grade) != null) {
        	timetables.get(grade).clear();
        }
        
        timetables.put(grade, new ArrayList<>());

        Scanner scanner = new Scanner(System.in);

        // Loop to input subjects
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter subject details for " + WEEKDAYS[i] + ": ");
            System.out.print("Subject name: ");
            String name = scanner.nextLine();
            System.out.print("Start time (HH:mm): ");
            String startTime = scanner.nextLine();
            System.out.print("End time (HH:mm): ");
            String endTime = scanner.nextLine();
            System.out.print("Teacher: ");
            String teacher = scanner.nextLine();

            // Add the new subject to the timetable for the given grade
            timetables.get(grade).add(new Subject(name, teacher, startTime, endTime, WEEKDAYS[i]));
        }

        System.out.println("New timetable for Grade " + grade + " created successfully.");
    }
    
    @Override
    public void deleteTimetable(int grade) {
        // Validate that the grade is between 6 and 11
        if (grade < 6 || grade > 11) {
            System.out.println("Invalid grade. Grade should be between 6 and 11.");
            return;
        }

        // Check if the timetable for the specified grade exists
        if (timetables.containsKey(grade)) {
        	timetables.remove(grade);  // Clear the timetable for the specified grade
            System.out.println("Timetable for Grade " + grade + " has been deleted.");
        } else {
            System.out.println("Timetable for Grade " + grade + " does not exist.");
        }
    }
    
}
