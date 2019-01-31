package hospital;

import java.util.ArrayList;
import java.util.List;

public class Ward {
	private String name;
	private List<Patient> patients = new ArrayList<Patient>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void addPatient(Patient patient) {
		if (this.patients.size() < 25) {
			this.patients.add(patient);
		} else {
			System.out.println("Ward " + name + " is full");
		}
	}

	private Ward(String name) {
		super();
		this.name = name;
	}

	public static List<Ward> initialiseWards(int maxWards, List<Ward> wards) {
		int i = 1;
		String word = "";
		while (i <= maxWards) {
			word = "BW" + i;
			wards.add(new Ward(word));
			i++;
		}
		return wards;
	}
}
