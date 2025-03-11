package timetable_producer;

public class Subject {
	private String name;
	private String teacher;
	private String startTime;
	private String endTime;
	private String day;
	
	public Subject(String name, String teacher, String startTime, String endTime, String day) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
