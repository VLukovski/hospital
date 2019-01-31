package hospital;

import java.util.List;

public abstract class Admin {
	public static int count = 0;

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
				.append(patient.getName().split(" ")[1].charAt(0)) + wards.get(j).getName() + count);
		count++;
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
	
	public static void addDoctorToTeam(Doctor doctor, List<Team> teams, Team team) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getDoctors().contains(doctor)) {
				System.out.println("Already got this doc");
				return;
			}
		}
		team.addDoctor(doctor);
	}
	
	public static void removeDoctorFromTeam(Doctor doctor, Team team)	{
		if (doctor.getRank() > 4 && team.getDoctors().stream().filter(n -> n.getRank() < 5).count() < 2) {
			System.out.println("Last consultant in team");
		}
		else if (team.getDoctors().contains(doctor)) {
			team.removeDoctor(doctor);
		}
		else {
			System.out.println("This doc is not in this team");
		}
	}
	
	public static void moveDoctor(Doctor doctor, Team team1, Team team2) {
		if (team1.getDoctors().contains(doctor)) {
			team1.removeDoctor(doctor);
			team2.addDoctor(doctor);
		}else if (team2.getDoctors().contains(doctor)) {
			team2.removeDoctor(doctor);
			team1.addDoctor(doctor);
		}
	}
	
	public void makeTeam(Doctor doctor) throws Exception {
		if (Teams.getTeams().size() < 16) {
			Teams.getTeams().add(new Team(doctor));
		} else {
			System.out.println("Too many teams, stop!");
		}
	}
}
