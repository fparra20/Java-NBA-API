package model;

import controller.RetrieveStandings;

import java.util.ArrayList;

public class Standings {

    public String teamId;
    public String win;
    public String loss;
    public String winPct;
    public String gamesBehind;
    public String lastTenWin;
    public String lastTenLoss;
    public String streak;
    public String confRank;

    public Standings() {

    }

    public ArrayList<Standings> getStandingsEast() {
        return new RetrieveStandings().getStandingsEast();
    }

    public ArrayList<Standings> getStandingsWest() {
        return new RetrieveStandings().getStandingsWest();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getWinPct() {
        return winPct;
    }

    public void setWinPct(String winPct) {
        this.winPct = winPct;
    }

    public String getGamesBehind() {
        return gamesBehind;
    }

    public void setGamesBehind(String gamesBehind) {
        this.gamesBehind = gamesBehind;
    }

    public String getLastTenWin() {
        return lastTenWin;
    }

    public void setLastTenWin(String lastTenWin) {
        this.lastTenWin = lastTenWin;
    }

    public String getLastTenLoss() {
        return lastTenLoss;
    }

    public void setLastTenLoss(String lastTenLoss) {
        this.lastTenLoss = lastTenLoss;
    }

    public String getStreak() {
        return streak;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }

    public String getConfRank() {
        return confRank;
    }

    public void setConfRank(String confRank) {
        this.confRank = confRank;
    }
}
