package hospital;

import java.util.ArrayList;
import java.util.List;

public class Teams {
	private static List<Team> teams = new ArrayList<Team>();
	public static List<Team> getTeams() {
		return teams;
	}
	public void addTeam(Team team) {
		if (teams.contains(team) == false) {
			teams.add(team);
		} else {
			System.out.println("Already got this team");
		}
	}
	public void removeTeam(Team team) {
		teams.remove(team);
	}

}
