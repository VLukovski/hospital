package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hospital.Doctor;
import hospital.Patient;
import hospital.Receptionist;
import hospital.Team;
import hospital.Ward;

public class Tests {

	@Test
	public void test() {
		Patient p1 = new Patient("cold", "John John", 21);
		assertEquals(p1.getAge(), 21);
		assertEquals(p1.getSickness().get(0), "cold");
	}

	@Test
	public void test2() {
		List<Ward> wards = new ArrayList<Ward>();
		Ward.initialiseWards(16, wards);
		assertEquals(wards.get(0).getName(), "BW1");
		assertEquals(wards.get(15).getName(), "BW16");
	}

	@Test
	public void test3() {
		Patient p1 = new Patient("cold", "John John", 21);
		Patient p2 = new Patient("cold", "John Cena", 93);
		Patient p3 = new Patient("cold", "John Whatever", 31);
		List<Ward> wards = new ArrayList<Ward>();
		Ward.initialiseWards(16, wards);
		Receptionist.admitPatient(p1, wards, 25);
		Receptionist.admitPatient(p2, wards, 25);
		Receptionist.admitPatient(p3, wards, 25);
		assertEquals(wards.get(2).getPatients().get(0).getAge(), 31);
		Receptionist.dischargePatient(p2, wards);
		assertEquals(wards.get(1).getPatients().size(), 0);
		Receptionist.admitPatient(p1, wards, 25);
		assertFalse(wards.get(0).getPatients().size() == 2);
		Receptionist.admitPatient(p2, wards, 0);
		assertEquals(wards.get(0).getPatients().get(0).getID(), "JJBW10");
	}

	@Test
	public void test4() throws Throwable {
		Doctor d1 = new Doctor("Sam Fisher", 4);
		Doctor d2 = new Doctor("Serious Sam", 6);
		Team t1 = new Team(d2);
		t1.addDoctor(d2);
		assertEquals(t1.getDoctors().get(1), d2);

	}
	
	@Test
	public void test5() {
		
	}
	
		
}
