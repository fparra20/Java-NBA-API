package model;

import controller.RetrievePlayoffs;

import java.util.ArrayList;

public class PlayoffsBracket {

    public String roundNum;
    public String confName;
    public String seriesId;
    public boolean isSeriesCompleted;
    public String summaryStatusText;
    public int gameNumber;
    public TeamPlayoffs topRow;
    public TeamPlayoffs bottomRow;

    public ArrayList<PlayoffsBracket> getPlayOffsBracketByYearConfRound(int year, String conf, String round) {
        return new RetrievePlayoffs().getPlayOffsByYearConfRound(year, conf, round);
    }

    public String getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(String roundNum) {
        this.roundNum = roundNum;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public boolean isIsSeriesCompleted() {
        return isSeriesCompleted;
    }

    public void setIsSeriesCompleted(boolean isSeriesCompleted) {
        this.isSeriesCompleted = isSeriesCompleted;
    }

    public String getSummaryStatusText() {
        return summaryStatusText;
    }

    public void setSummaryStatusText(String summaryStatusText) {
        this.summaryStatusText = summaryStatusText;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public TeamPlayoffs getTopRow() {
        return topRow;
    }

    public void setTopRow(TeamPlayoffs topRow) {
        this.topRow = topRow;
    }

    public TeamPlayoffs getBottomRow() {
        return bottomRow;
    }

    public void setBottomRow(TeamPlayoffs bottomRow) {
        this.bottomRow = bottomRow;
    }

}
