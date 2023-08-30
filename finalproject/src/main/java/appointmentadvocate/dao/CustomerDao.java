package appointmentadvocate.dao;
import java.sql.SQLException;
import java.util.List;
//import advocateappointment.exception.CustomerNotFoundException;

import appointmentadvocate.entity.Customer;
import appointmentadvocate.exception.CustomerNotFoundException;
public interface CustomerDao {
	
	boolean insert(Customer obj) throws SQLException;
	boolean modify(Customer obj )throws SQLException,CustomerNotFoundException;
	boolean delete(int id)throws SQLException,CustomerNotFoundException;
	List <Customer> allRecord() throws SQLException;
	Customer singleRecord(int id) throws SQLException,CustomerNotFoundException;
	
}
