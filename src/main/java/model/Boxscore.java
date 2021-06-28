package model;

import controller.RetrieveBoxscore;

import java.util.ArrayList;

public class Boxscore extends Player {

    public String points;
    public String pos;
    public String min;
    public String fgm;
    public String fga;
    public String fgp;
    public String ftm;
    public String fta;
    public String ftp;
    public String tpm;
    public String tpa;
    public String tpp;
    public String offReb;
    public String defReb;
    public String totReb;
    public String assists;
    public String pFouls;
    public String steals;
    public String turnovers;
    public String blocks;
    public String plusMinus;
    public String dnp;

    public ArrayList<Boxscore> getBoxscoreByDateAndGame(String date, String gameId) {

        return new RetrieveBoxscore().getBoxscore(date, gameId);
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getFgm() {
        return fgm;
    }

    public void setFgm(String fgm) {
        this.fgm = fgm;
    }

    public String getFga() {
        return fga;
    }

    public void setFga(String fga) {
        this.fga = fga;
    }

    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
    }

    public String getFtm() {
        return ftm;
    }

    public void setFtm(String ftm) {
        this.ftm = ftm;
    }

    public String getFta() {
        return fta;
    }

    public void setFta(String fta) {
        this.fta = fta;
    }

    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }

    public String getTpm() {
        return tpm;
    }

    public void setTpm(String tpm) {
        this.tpm = tpm;
    }

    public String getTpa() {
        return tpa;
    }

    public void setTpa(String tpa) {
        this.tpa = tpa;
    }

    public String getTpp() {
        return tpp;
    }

    public void setTpp(String tpp) {
        this.tpp = tpp;
    }

    public String getOffReb() {
        return offReb;
    }

    public void setOffReb(String offReb) {
        this.offReb = offReb;
    }

    public String getDefReb() {
        return defReb;
    }

    public void setDefReb(String defReb) {
        this.defReb = defReb;
    }

    public String getTotReb() {
        return totReb;
    }

    public void setTotReb(String totReb) {
        this.totReb = totReb;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getpFouls() {
        return pFouls;
    }

    public void setpFouls(String pFouls) {
        this.pFouls = pFouls;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    public String getDnp() {
        return dnp;
    }

    public void setDnp(String dnp) {
        this.dnp = dnp;
    }

}
