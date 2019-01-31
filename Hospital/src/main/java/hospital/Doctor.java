package hospital;

public class Doctor {
	private String name;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void promote() {
		if (rank < 10) {
			rank++;
		} else {
			System.out.println("Already at highest rank");
		}
	}

	public void demote() {
		if (rank > 0) {
			rank--;
		} else {
			System.out.println("Already at lowest rank");
		}
	}

	public Doctor(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}

}
