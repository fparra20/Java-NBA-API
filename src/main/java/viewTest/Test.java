/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewTest;

import java.util.ArrayList;
import model.Boxscore;
import model.Player;
import model.PlayoffsBracket;
import model.Scoreboard;
import model.Standings;
import model.Team;

/**
 *
 * @author Francisco Parra
 */
public class Test {

    public static void main(String[] args) {

        /*
        Scoreboard sb = new Scoreboard();

        // Get all games played on given date
        ArrayList<Scoreboard> sbList = sb.getScoreboardListByDate("20210623");

        // Shows Id and Arena City of the first game on that date.
        System.out.println(sbList.get(0).getGameId() + " -- " + sbList.get(0).getArenaCity());

        Boxscore bs = new Boxscore();

        // Get boxscore from a game on a given date
        ArrayList<Boxscore> bsList = bs.getBoxscoreByDateAndGame("20210622", "0042000312");

        // Show information for every Player
        for (Boxscore b : bsList) {
            System.out.println(b.getFullName() + " - Points: " + b.getPoints());
        }
        // Get all players on the league at the moment
        ArrayList<Player> pList = new Player().getAllPlayers();

        // Show full name for every Player
        for (Player p : pList) {
            System.out.println(p.getFullName());
        }

        // Get all players on a team
        ArrayList<Player> pList = new Player().getPlayersByTeamUrl("raptors");

        // Show full name for every Player on the Raptors
        for (Player p : pList) {
            System.out.println(p.getFullName() + " " + p.getAge());
        }

        // Get a specific player given its Id and Team
        Player p = new Player().getPlayerProfileFromId("203078", "wizards");

        // Get player's full name and college
        System.out.println(p.getFullName() + " " + p.getCollegeName() + " " + p.getTeamId());

        // Get a specific team given its Id
        ArrayList<Team> tmList = new Team().getAllTeams();

        // Get all teams full name and tricode
        for (Team t : tmList) {
            System.out.println(t.getFullName() + " " + t.getTricode());
        }

        // Get all east conference standings at the moment
        ArrayList<Standings> east = new Standings().getStandingsEast();

        // Get all west conference standings at the moment
        ArrayList<Standings> west = new Standings().getStandingsWest();

        // Get teams tricode and Win - Loss
        for (Standings s : east) {

            // Get team tricode given the Id
            String tm = new Team().getTeamById(s.getTeamId()).getTricode();

            System.out.println(tm + " " + s.getWin() + "-" + s.getLoss());
        }

         */
        // Get matches on a given year, conference and round
        ArrayList<PlayoffsBracket> round_one = new PlayoffsBracket().getPlayOffsBracketByYearConfRound(2020, "East", "1");

        // Get teams tricode and Wins
        for (PlayoffsBracket pb : round_one) {

            // Store top Team's (team with better seed) Tricode
            String topTeamTricode = new Team().getTeamById(pb.getTopRow().getTeamId()).getTricode();

            // Store bottom Team's Tricode
            String bottomTeamTricode = new Team().getTeamById(pb.getBottomRow().getTeamId()).getTricode();

            System.out.println(topTeamTricode + ": " + pb.getTopRow().getWins());
            System.out.println(bottomTeamTricode + ": " + pb.getBottomRow().getWins());
            System.out.println("__");
        }
    }
}
