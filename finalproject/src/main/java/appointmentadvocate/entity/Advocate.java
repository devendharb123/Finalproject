package appointmentadvocate.entity;

public class Advocate {
	private int a_Id;
	private String a_ContactNumber;
	private String a_Name;
	private String a_Address;
	public Advocate(int a_Id, String a_Name, String a_ContactNumber, String a_Address) {
		super();
		this.a_Id = a_Id;
		this.a_ContactNumber = a_ContactNumber;
		this.a_Name = a_Name;
		this.a_Address = a_Address;
	}
	public int getA_Id() {
		return a_Id;
	}
	public void setA_Id(int a_Id) {
		this.a_Id = a_Id;
	}
	public String getA_ContactNumber() {
		return a_ContactNumber;
	}
	public void setA_ContactNumber(String a_ContactNumber) {
		this.a_ContactNumber = a_ContactNumber;
	}
	public String getA_Name() {
		return a_Name;
	}
	public void setA_Name(String a_Name) {
		this.a_Name = a_Name;
	}
	public String getA_Address() {
		return a_Address;
	}
	public void setA_Address(String a_Address) {
		this.a_Address = a_Address;
	}
	@Override
	public String toString() {
		return " Id=" + a_Id + ", ContactNumber=" + a_ContactNumber + ", Name=" + a_Name + ", Address="
				+ a_Address +"\n";
	}
	
	
	
}
