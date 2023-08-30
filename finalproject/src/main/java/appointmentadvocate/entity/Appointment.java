package appointmentadvocate.entity;

public class Appointment {
	private int appointmentId;
	private int customerId;
	private int advocateId;	
	private String appointmentDate;
	public Appointment(int appointmentId, int customerId, int advocateId, String appointmentDate) {
		super();
		this.appointmentId = appointmentId;
		this.customerId = customerId;
		this.advocateId = advocateId;
		this.appointmentDate = appointmentDate;
	}
	public Appointment( int customerId, int advocateId, String appointmentDate) {
		super();
		this.customerId = customerId;
		this.advocateId = advocateId;
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public int getAdvocateId() {
		return advocateId;
	}
	public void setAdvocateId(int AdvocateId) {
		this.advocateId = AdvocateId;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	@Override
	public String toString() {
		return "Appointment [ AppointmentId=" + appointmentId + ", CustomerId=" + customerId + "  AdvocateId=" + advocateId + ", AppointmentDate="
				+ appointmentDate + "]";
	}
	
}
