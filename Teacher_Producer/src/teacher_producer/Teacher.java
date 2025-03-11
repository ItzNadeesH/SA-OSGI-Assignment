package teacher_producer;

public class Teacher {
    private String teacherID;
    private String name;
    private String contact;
    private String email;
    private String subject;

    public Teacher(String teacherID, String name, String email,String contact, String subject) {
        super();
    	this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.subject = subject;
    }

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}
}
