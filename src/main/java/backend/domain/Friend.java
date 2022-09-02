package backend.domain;


public class Friend {
	
	private String name;
	
	public Friend() {}

	public Friend(String n) {
		this.name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
