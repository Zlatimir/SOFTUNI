package FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 2.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split(";");
            String command = data[0];
            switch (command) {
                case "Team":
                    String teamName = data[1];
                    Team team = new Team(teamName);
                    teams.put(teamName, team);
                    break;
                case "Add":
                    teamName = data[1];
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    String playerName = data[2];
                    int endurance = Integer.parseInt(data[3]);
                    int sprint = Integer.parseInt(data[4]);
                    int dribble = Integer.parseInt(data[5]);
                    int passing = Integer.parseInt(data[6]);
                    int shooting = Integer.parseInt(data[7]);
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    if (playerName == null || playerName.trim().isEmpty() || endurance < 0 || endurance > 100
                            || sprint < 0 || sprint > 100 || dribble < 0 || dribble > 100
                            || passing < 0 || passing > 100 || shooting < 0 || shooting > 100) {
                        break;
                    }
                    teams.get(teamName).addPlayer(player);
                    break;
                case "Remove":
                    teamName = data[1];
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                    } else {
                        playerName = data[2];
                        player = teams.get(teamName).getPlayerByName(playerName);
                        if (player != null) {
                            teams.get(teamName).removePlayer(player);
                        } else {
                            System.out.println("Player " + playerName + " is not in " + teamName + " team.");
                        }
                    }
                    break;
                case "Rating":
                    teamName = data[1];
                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team " + teamName + " does not exist.");
                    } else {
                        double skillLevel = 0.0;
                        for (Player player1 : teams.get(teamName).getPlayers()) {
                            skillLevel += player1.overallSkillLevel();
                        }
                        skillLevel = skillLevel / teams.get(teamName).getPlayers().size();
                        System.out.println(teamName + " - " + (int) Math.round(skillLevel));
                    }
                    break;
            }
            input = sc.nextLine();
        }
    }
}
