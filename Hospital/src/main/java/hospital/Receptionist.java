package hospital;

import java.util.List;

public abstract class Receptionist{
	public static void admitPatient(Patient patient, List<Ward> wards, int maxPatients) {
		int j = 0;
		for (int i = 0; i < wards.size() - 1; i++) {
			if (wards.get(i).getPatients().contains(patient)) {
				System.out.println("Patient already in hospital");
				return;
			}
			if (wards.get(i).getPatients().size() > wards.get(i + 1).getPatients().size()) {
				j = i + 1;
			}
		}
		if (wards.get(j).getPatients().size() == maxPatients) {
			System.out.println("All wards are full");
			return;
		}
		patient.setID(new StringBuilder().append(patient.getName().split(" ")[0].charAt(0))
				.append(patient.getName().split(" ")[1].charAt(0)) + wards.get(j).getName() + Admin.count);
		Admin.count++;
		wards.get(j).addPatient(patient);
		System.out.println("Patient added to ward number " + (j + 1));
	}

	public static void dischargePatient(Patient patient, List<Ward> wards) {
		for (int i = 0; i < wards.size(); i++) {
			if (wards.get(i).getPatients().contains(patient)) {
				wards.get(i).getPatients().remove(patient);
				System.out.println("Patient removed");
			}
		}
	}
}
