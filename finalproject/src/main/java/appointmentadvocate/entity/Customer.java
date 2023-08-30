package appointmentadvocate.entity;

public class Customer {
	private int c_Id;
	private String c_Name;
	private String c_ContactNumber;
	private String c_EmailId;
	private String c_Address;
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public String getC_ContactNumber() {
		return c_ContactNumber;
	}
	public void setC_ContactNumber(String c_ContactNumber) {
		this.c_ContactNumber = c_ContactNumber;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	public String getC_EmailId() {
		return c_EmailId;
	}
	public void setC_EmailId(String c_EmailId) {
		this.c_EmailId = c_EmailId;
	}
	public Customer(int c_Id,String c_Name, String c_ContactNumber, String c_EmailId,String c_Address) {
		super();
		this.c_Id = c_Id;
		this.c_ContactNumber = c_ContactNumber;
		this.c_Name = c_Name;
		this.c_EmailId = c_EmailId;
		this.c_Address= c_Address;
	}
	public Customer(String c_Name, String c_ContactNumber, String c_EmailId,String c_Address) {
		super();
		//this.c_Id = c_Id;
		this.c_ContactNumber = c_ContactNumber;
		this.c_Name = c_Name;
		this.c_EmailId = c_EmailId;
		this.c_Address= c_Address;
	}
	public String getC_Address() {
		return c_Address;
	}
	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}
	@Override
	public String toString() {
		return "Id=" + c_Id + ",  Name=" + c_Name + ", ContactNumber=" + c_ContactNumber + ", EmailId="
				+ c_EmailId + ", Address=" + c_Address + "\n";
	}  
	
		
	
	
}
