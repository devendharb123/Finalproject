package appointmentadvocate;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import appointmentadvocate.dao.AdvocateDao;
import appointmentadvocate.dao.AppointmentDao;
import appointmentadvocate.dao.CustomerDao;
import appointmentadvocate.dao.impl.AdvocateDaoImpl;
import appointmentadvocate.dao.impl.AppointmentDaoImpl;
import appointmentadvocate.dao.impl.CustomerDaoImpl;
import appointmentadvocate.entity.Advocate;
import appointmentadvocate.entity.Appointment;
import appointmentadvocate.entity.Customer;
import appointmentadvocate.exception.AdvocateNotFoundException;
import appointmentadvocate.exception.AppointmentNotFoundException;
import appointmentadvocate.exception.CustomerNotFoundException;

public class AdvocateAppointmentApp 
{
	public static CustomerDao customerDao=new CustomerDaoImpl();
	public static AdvocateDao advocateDao=new AdvocateDaoImpl();
	public static AppointmentDao appointmentDao =new AppointmentDaoImpl();
	public static  Scanner scanner =new Scanner(System.in);
    public static void main( String[] args ) throws AdvocateNotFoundException, SQLException, AppointmentNotFoundException, CustomerNotFoundException
    {
        
    	while(true) {
    		
    		System.out.println("====================================================================================================");
    		System.out.println("*****WELCOME TO MAIN MENU*****\n"+"1) Customer" + "  " + "2) Advocate" + "  " +"3) Appointment"+" "
    				+ "4) Service\r" + "0) Exit\r");
    				
    		System.out.println("====================================================================================================");
    		
    		int choice = Integer.parseInt(scanner.nextLine());
    		switch(choice) {
    		case 1:
    			System.out.println("Customer Services Started:\n");
    			customerServices();
    			System.out.println("Customer Services Ended. Thank You!!\n");
    			
    		case 2:
    			System.out.println("Advocate Seevices Started:\n");
    			advocateServices();
    			System.out.println("Advocate  Seevices Ended:\n");
    			
    		case 3:
    			break;
    		case 4:
    			break;
    		case 0:
    			System.exit(0);  
    		default:
    			System.exit(0);
    		};
    		
    		
    	}
    }
   ////THIS IS APPOINTMENT METHOD

    public static void allAppointment()throws SQLException,AppointmentNotFoundException{  // display all the appointment (FOR ALL)
    	System.out.println("Printing All  The Appointments: \n");
    	try {
			List<Appointment> allAppointments= appointmentDao.allRecord();  // declaring the variable allappointments with the type of list
			for(Appointment i: allAppointments)System.out.println(i+"\n");
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("\n No Data\n");
			System.err.println(e);
				}
    	
    }
       public static void singleAppointment() throws SQLException,AppointmentNotFoundException{
    	System.out.println("Enter The Appointment Id \n");										// TO VIEW SINGLE appointment record
    	int appointmentId= Integer.parseInt(scanner.nextLine());    
    		
			try {
				Appointment obj = appointmentDao.singleRecord(appointmentId);  // accessing the single data from the appointmentdao, obj is an object type  Appointment
				System.out.println(obj);  // after printing the execution will terimnate the method and the return will be called
				return ;               // by this we can end the methods execution
			} catch (AppointmentNotFoundException e) {
				// TODO Auto-generated catch block
				
				System.err.println(e);
			}
			System.out.println("No Data Found With Id "+appointmentId);
    		return ;
    }
       
       // for deleting the appointment through id
       
    public static void deleteAppointment() throws SQLException,AppointmentNotFoundException{
    	System.out.println("\n Enter Appointment Id To Delete");
    	int appointmentId = Integer.parseInt(scanner.nextLine());  // by this the user can convert the data from string to int
    	try {
    		if(appointmentDao.delete(appointmentDao.singleRecord(appointmentId))){
    			System.out.println("\n Data Has Been Deleted \n");
    		}
    	}catch(SQLException | AppointmentNotFoundException e) {   // if the exception occur then the catch will run 
    		System.out.println("Data Has Not Been Deleted \n");
    		System.err.println(e);
    	}
    }
    
    // this is used for modifying the appointment
    
    public static void modifyAppointment() throws SQLException ,AppointmentNotFoundException{
    	System.out.println("\n Enter Appointment Id To Modify Details: \n");
    	int appointment_Id= Integer.parseInt(scanner.nextLine());
    	System.out.println("\n Enter New Customer Id To Modify: \n");
    	int customer_Id= Integer.parseInt(scanner.nextLine());
    	System.out.println("\n Enter New Advocate Id To Modify: \n");
    	int advocate_Id= Integer.parseInt(scanner.nextLine());
       	System.out.println("\n Enter New Appointment Date To Modify: \n");
    	scanner.nextLine();
    	String appointment_Date= scanner.nextLine();
    	Appointment obj = new Appointment(appointment_Id,customer_Id,advocate_Id,appointment_Date);
    	try {
    		if(appointmentDao.modify(obj)) {
    			System.out.println("\n UPDATE DONE\n");
    			return ;
    		}
    	}catch(SQLException |AppointmentNotFoundException e) {
    		System.err.println(e);
    	}
    	System.out.println("\n NOT UPDATED\n");
    	return ;
    	
    	
    	
    }
    
    // this is for bookappointment 
    
    
    public static void bookAppointment() throws SQLException,AppointmentNotFoundException, CustomerNotFoundException,
    AdvocateNotFoundException {
    	System.out.println("\n Enter Customer Id To Book Appointment \n");
    	int customer_Id=Integer.parseInt(scanner.nextLine());
    	Customer customer_Obj = customerDao.singleRecord(customer_Id);
    	System.out.println("\n Enter Advocate Id To Book Appointment \n");
    	int advocate_Id=Integer.parseInt(scanner.nextLine());
    	Advocate advocate_Obj = advocateDao.singleRecord(advocate_Id);
    	scanner.nextLine();
    	System.out.println("\n Enter Date To Book Appointment \n");
    	
    	String appointment_Date= scanner.nextLine();
    	
    	Appointment obj= new Appointment(customer_Obj.getC_Id(),advocate_Obj.getA_Id(),appointment_Date);
    	
    	try {
    		if(appointmentDao.bookAppointment(obj)) {
    			System.out.println("\n Data Has Inserted \n");
    		}
    	}catch(SQLException |AppointmentNotFoundException  e) {
    		System.err.println(e);
    	}
    	
    	return ;
    }
    
    // THIS IS THE ADVOCATE METHODS PART
    
    // for allrecords printing from advocate
    
    public static void a_AllRecord() throws AdvocateNotFoundException {
    	System.out.println("\n Showing All Records Of Advocates \n");
    	try {
    		List<Advocate> advocateList = advocateDao.allRecord();
    		for (Advocate i: advocateList ) {
    			System.out.println(i+"\n");
    		}
    		
    	}catch(SQLException e) {
    		System.err.println(e);
    	}
    	
    	
    	return ;
    }
    
    // single record printing from the advocate
    
    
    public static void a_SingleRecord() {
    	System.out.println("\n** Enter Advocate Id **\n");
    	int advocateid = Integer.parseInt(scanner.nextLine());
    	try {
    		Advocate obj;
			try {
				obj = advocateDao.singleRecord(advocateid);
				System.out.println(obj);
			} catch (AdvocateNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}catch(SQLException e) {
    		System.err.println(e);
    	}
    }

    public static void advocateServices() throws AdvocateNotFoundException, SQLException, AppointmentNotFoundException, CustomerNotFoundException {
    	while(true) {
    		
    		System.out.println("======================================================================================================");
    		System.out.println("1. Book an appointment\r" + "2. Modify appointment details\r"+ "3. Delete an appointment\r\n"
    		    				+ "4. View single record\r"+ "5. View all records\r\n"+ "0. Exit\r\n");
    		System.out.println("=======================================================================================================");
    		int choice = Integer.parseInt(scanner.nextLine());
    		switch(choice) {
    		case 1:
    			System.out.println(" \r\n Booking  Appointment Services Started:\r\n");
    			bookAppointment();
    			System.out.println("\r\n Booking Appointment Services Ended \r\n");
    			break;
    		case 2:
    			System.out.println(" \r\n Modify Appointment Services Started:\r\n");
    			modifyAppointment();
    			System.out.println("\r\n Modify Appointment Services Ended\r\n");
    			break;
    		case 3:
    			System.out.println(" \r\n Delete Appointment Services:\r\n");
    			deleteAppointment();
    			System.out.println("\r\n Ending Delete Appointment Services\r\n");
    			break;
    		case 4:
    			System.out.println(" \r\n Statring View Single Record Services: \r\n");
    			singleAppointment();
    			System.out.println("\r\n **Ending View Single Records Services \r\n");
    			break;
    		case 5:
    			System.out.println(" \r\n **Statring View All Record Services: \r\n");
    			//sAllRecord();
    			allAppointment();
    			System.out.println("\r\n Ending View All Records Services \r\n");
    			break;
    		case 0:
    			return ;
    			
    		}
    	}
    }
    
                                 //THIS IS THE CUSTOMER METHODA PART
    public static void customerDelete() {
    	scanner.nextLine();
    	System.out.println("\n Enter Customer Id To Delete: \n");
    	int customerId= Integer.parseInt(scanner.nextLine());
    	
    	try {
    		if(customerDao.delete(customerId)) {
    			System.out.println("\n Data has been deleted: \n");
    		}else {
    			System.out.println("\n No Data has been Found With Id :- "+customerId+"\n");
    		}
    	} catch(SQLException | CustomerNotFoundException e) {
    		System.err.println(e);
    	}
    	return ;
    }
    public static void customerRegister() {
 
    	scanner.nextLine();
    	System.out.println("\n **Enter Customer Name \n");
    	
    	String name = scanner.nextLine();
    	System.out.println("\n Enter Customer Email Address: \n");
    	String email= scanner.nextLine();
    	System.out.println("\n Enter Customer Number:\n");
    	String contactNumber= scanner.nextLine();
    	System.out.println("\n Enter Customer Address: \n");
    	String address= scanner.nextLine();
    	
    	Customer obj = new Customer(name,contactNumber,email,address);
    	try {
			if(customerDao.insert(obj)) {
				System.out.println("Inserted");
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
    	   	
    	
    }
    public static void customerModify() {
    	System.out.println("\n Enter Customer Id To Modify Data: \n");
    	int customerid= Integer.parseInt(scanner.nextLine());
    	System.out.println("\n Enter Name of Customer to update \n");
    	scanner.nextLine();
    	String newName = scanner.nextLine();
    	System.out.println("\n Enter Contact Number  of Customer to update \n");
    	String newContactNumber= scanner.nextLine();
    	System.out.println("\n Enter Email Address of Customer to update \n");
    	String newEmail= scanner.nextLine();
    	System.out.println("\n Enter Address of Customer to update \n");
    	String newAddess = scanner.nextLine();
    	Customer obj =new Customer(customerid,newName,newContactNumber,newEmail,newAddess);
    	try {
    		if(customerDao.modify(obj)) {
    			System.out.println("\n Data has been Updated \n");
    		}else {
    			System.out.println("\n Data has not been Updated\n");
    			}
    	}catch(SQLException | CustomerNotFoundException e){
    		System.err.println(e);
    		
    	}
 
    	
    	
    	return ;
    	
    }
    public static void customerSingleRecord() {
    	System.out.println("\n Enter Customer Id:\n");
    	int id = Integer.parseInt(scanner.nextLine());
    	try {
    		Customer obj = customerDao.singleRecord(id);
    		System.out.println(obj);
    		
    	}catch(SQLException  | CustomerNotFoundException e) {
    		System.err.println(e);
    	}
    	
    	
    }
    public static void customercAllRecord() {
    	System.out.println("\n Showing All Records \n");
    	try {
    		List<Customer> customerList = customerDao.allRecord();
    		for (Customer i: customerList ) {
    			System.out.println(i+"\n");
    		}
    		
    	}catch(SQLException e) {
    		System.err.println(e);
    	}
    	return ;
    }
    public static void customerServices() {
    	while(true) {
    		System.out.println("1. Register Customer\r\n"
    				+ "2. Modify Customer details\r\n"
    				+ "3. Delete Customer record\r\n"
    				+ "4. View single record\r\n"
    				+ "5. View all records\r\n"
    				+ "0. Exit\r\n");
    		int choice =Integer.parseInt(scanner.nextLine());
    		switch(choice) {
    		case 1:
    			System.out.println("Starting Registering Services:\n");
    			customerRegister();
    			System.out.println("Ending Registering Services\n");
    			break;
    		case 2:
    			System.out.println("Starting Modifying Services:\n");
    			customerModify();
    			System.out.println("Ending Registering Services:\n");
    			break;
    		case 3:
    			System.out.println("Starting Deleting Services:\n");
    			customerDelete();
    			System.out.println("Ending Deleting Services\n");
    			break;
    		case 4:
    			System.out.println("Starting View Single Record Services:\n");
    			customerSingleRecord();
    			System.out.println("Ending View Single Record Services\n");
    			break;
    		case 5:
    			System.out.println("Starting View All Record Services:\n");
    			customercAllRecord();
    			System.out.println("Ending View All Record Services\n");
    			break;
    		case 0:
    			return;
    		
    		};
    	}
    	
    	
    }
    
	
}
