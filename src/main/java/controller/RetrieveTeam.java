/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Team;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class RetrieveTeam {

    public ArrayList<Team> getTeams() {

        ArrayList<Team> tList = new ArrayList<>();

        JSONObject jobj;

        try {

            // Obtenemos un jugador en concreto
            URL url = new URL("http://data.nba.net/data/10s/prod/v1/2020/teams.json");

            // Abre conexión con la página web
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Indica una request de tipo GET
            con.setRequestMethod("GET");

            String inline = "";

            con.connect();

            int responsecode = con.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();
            }

            jobj = new JSONObject(inline);

            JSONArray data = jobj.getJSONObject("league").getJSONArray("standard");

            int i = 0;

            while (data.length() > i) {

                Team tm = new Team();

                tm.setFullName(data.getJSONObject(i).getString("fullName"));
                tm.setConfName(data.getJSONObject(i).getString("confName"));
                tm.setDivName(data.getJSONObject(i).getString("divName"));
                tm.setTricode(data.getJSONObject(i).getString("tricode"));
                tm.setTeamId(data.getJSONObject(i).getString("teamId"));
                tm.setUrlName(data.getJSONObject(i).getString("urlName"));

                tList.add(tm);

                i++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tList;
    }

    public Team getTeamById(String id) {

        ArrayList<Team> tList = getTeams();

        Team foundTeam = null;

        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getTeamId().equals(id)) {
                foundTeam = tList.get(i);
                break;
            }
        }

        return foundTeam;
    }
}
