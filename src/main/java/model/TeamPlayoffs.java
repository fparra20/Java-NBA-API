package model;

public class TeamPlayoffs extends Team {

    public String seedNum;
    public String wins;
    public boolean isSeriesWinner;

    public String getSeedNum() {
        return seedNum;
    }

    public void setSeedNum(String seedNum) {
        this.seedNum = seedNum;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public boolean isIsSeriesWinner() {
        return isSeriesWinner;
    }

    public void setIsSeriesWinner(boolean isSeriesWinner) {
        this.isSeriesWinner = isSeriesWinner;
    }

}