package backend.domain;

public class Student {
	
	String fName;
	String lName;
	
	public Student() {}

	public Student(String fN, String lN) {
		this.fName = fN;
		this.lName = lN;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s\n", fName, lName);
	}

}
