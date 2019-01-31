package hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private List<String> sickness = new ArrayList<String>();
	private String name;
	private int age;
	private String ID;
	private List<String> treatment;

	public List<String> getSickness() {
		return sickness;
	}

	public void addSickness(String sickness) {
		this.sickness.add(sickness);
	}

	public void removeSickness(String sickness) {
		this.sickness.remove(sickness);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public List<String> getTreatment() {
		return treatment;
	}

	public void addTreatment(String treatment) {
		this.treatment.add(treatment);
	}

	public void finishTreatment(String treatment) {
		this.treatment.remove(treatment);
	}

	public Patient(String sickness, String name, int age) {
		super();
		this.sickness.add(sickness);
		this.name = name;
		this.age = age;
	}
}
