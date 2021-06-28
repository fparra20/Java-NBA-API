package model;


public class TeamScore extends Team {

    public String win;
    public String loss;
    public String seriesWin;
    public String seriesLoss;
    public String score;

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

    public String getSeriesWin() {
        return seriesWin;
    }

    public void setSeriesWin(String seriesWin) {
        this.seriesWin = seriesWin;
    }

    public String getSeriesLoss() {
        return seriesLoss;
    }

    public void setSeriesLoss(String seriesLoss) {
        this.seriesLoss = seriesLoss;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
