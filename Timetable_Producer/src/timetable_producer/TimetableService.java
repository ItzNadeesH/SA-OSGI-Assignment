package timetable_producer;

public interface TimetableService {
	void displayTimetable(int grade);
	void displayAllTimetables();
	void createNewTimetable(int grade);
	void deleteTimetable(int grade);

}
