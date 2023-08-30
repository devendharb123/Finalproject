package appointmentadvocate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import appointmentadvocate.dao.AdvocateDao;
import appointmentadvocate.entity.Advocate;
import appointmentadvocate.entity.Appointment;
import appointmentadvocate.exception.AdvocateNotFoundException;
import appointmentadvocate.exception.AppointmentNotFoundException;
import appointmentadvocate.util.DbUtility;

public class AdvocateDaoImpl implements AdvocateDao{
	private final static String SELECT_ALL ="SELECT * FROM ADVOCATE ";
	private Connection connection = DbUtility.getConnection();
	private final static String SELECT_BY_ID="SELECT * FROM ADVOCATE WHERE a_Id=?";
	public List<Advocate> allRecord() throws SQLException{
		PreparedStatement st= connection.prepareStatement(SELECT_ALL);
		List<Advocate> advocate =new ArrayList<>();
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			Advocate obj= new Advocate(rs.getInt("a_Id"),rs.getString("a_Name"), rs.getString("a_ContactNumber"), rs.getString("a_Address"));
			advocate.add(obj);			
		}
		rs.close();
		st.close();
		return advocate;
		
	}
	public Advocate singleRecord(int id)  throws SQLException ,AdvocateNotFoundException {
		
		PreparedStatement st= connection.prepareStatement(SELECT_BY_ID);
		st.setInt(1, id);
		ResultSet rs= st.executeQuery()	;
		if(rs.next()) {
		Advocate obj = new Advocate(rs.getInt("a_Id"),rs.getString("a_Name"),rs.getString("a_ContactNumber"),rs.getString("a_Address")); 
		st.close();
		st.close();
		return obj;
		}
		return null;
	}
	@Override
	public boolean delete(Appointment obj) throws SQLException, AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modify(Appointment obj) throws SQLException, AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
}
