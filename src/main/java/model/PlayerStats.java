package model;

import controller.RetrievePlayerStats;

import java.util.ArrayList;

public class PlayerStats extends Player {

    public String ppg;
    public String rpg;
    public String apg;
    public String mpg;
    public String topg;
    public String spg;
    public String bpg;
    public String tpp;
    public String ftp;
    public String fgp;
    public String gamesPlayed;
    public String gamesStarted;
    public String plusMinus;
    public int seasonYear;

    public PlayerStats() {

    }

    public ArrayList<PlayerStats> getPlayerStatsById(String id) {
        return new RetrievePlayerStats().getPlayerStatsFromID(id);
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    public String getApg() {
        return apg;
    }

    public void setApg(String apg) {
        this.apg = apg;
    }

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public String getTopg() {
        return topg;
    }

    public void setTopg(String topg) {
        this.topg = topg;
    }

    public String getSpg() {
        return spg;
    }

    public void setSpg(String spg) {
        this.spg = spg;
    }

    public String getBpg() {
        return bpg;
    }

    public void setBpg(String bpg) {
        this.bpg = bpg;
    }

    public String getTpp() {
        return tpp;
    }

    public void setTpp(String tpp) {
        this.tpp = tpp;
    }

    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }

    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(String gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    public int getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(int seasonYear) {
        this.seasonYear = seasonYear;
    }

}
