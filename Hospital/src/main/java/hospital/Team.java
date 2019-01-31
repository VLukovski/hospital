package hospital;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Doctor> doctors = new ArrayList<Doctor>();
	private List<Patient> patients = new ArrayList<Patient>();
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void addDoctor(Doctor doctor) {
		if (doctors.size() < 20) {
			doctors.add(doctor);
		} else {
			System.out.println("Too many doctors in this team");
		}
	}
	public void removeDoctor(Doctor doctor) {
		doctors.remove(doctor);
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	public void removePatient(Patient patient) {
		patients.remove(patient);
	}
	public Team(Doctor consultant) throws Exception {
		super();
		if (consultant.getRank() < 5) {
			System.out.println("Can't make a team without a fitting consultant");
			throw new Exception();
		}
		else {
			doctors.add(consultant);
		}
	}
}
