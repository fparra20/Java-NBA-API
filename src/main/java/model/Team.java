package model;

import controller.RetrieveTeam;

import java.util.ArrayList;

public class Team {

    public String teamId;
    public String city;
    public String nickname;
    public String fullName;
    public String tricode;
    public String confName;
    public String divName;
    public String urlName;

    public Team() {

    }

    public Team getTeamById(String id) {
        return new RetrieveTeam().getTeamById(id);
    }

    public ArrayList<Team> getAllTeams() {
        return new RetrieveTeam().getTeams();
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTricode() {
        return tricode;
    }

    public void setTricode(String tricode) {
        this.tricode = tricode;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }
}
