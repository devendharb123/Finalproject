package appointmentadvocate.dao;

import java.sql.SQLException;
import java.util.List;

import appointmentadvocate.entity.Appointment;
import appointmentadvocate.exception.AppointmentNotFoundException;

public interface AppointmentDao  {
	public boolean bookAppointment(Appointment obj) throws  SQLException , AppointmentNotFoundException;	
	public boolean modify(Appointment obj) throws SQLException , AppointmentNotFoundException;
	public Appointment singleRecord(int id) throws SQLException ,AppointmentNotFoundException;
	public List<Appointment> allRecord() throws SQLException ,AppointmentNotFoundException;
	boolean delete(Appointment obj) throws SQLException, AppointmentNotFoundException;
	
}
