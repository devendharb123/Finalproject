package appointmentadvocate.dao;

import java.sql.SQLException;
import java.util.List;

import appointmentadvocate.entity.Advocate;
import appointmentadvocate.entity.Appointment;
import appointmentadvocate.exception.AdvocateNotFoundException;
import appointmentadvocate.exception.AppointmentNotFoundException;

public interface AdvocateDao {
	public List<Advocate> allRecord()throws SQLException,AdvocateNotFoundException;
	public Advocate singleRecord(int id) throws SQLException ,AdvocateNotFoundException;
	public boolean delete(Appointment obj) throws SQLException, AppointmentNotFoundException;
	public boolean modify(Appointment obj) throws SQLException, AppointmentNotFoundException;
	
}
