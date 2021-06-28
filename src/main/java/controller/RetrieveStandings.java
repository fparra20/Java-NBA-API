package controller;

import model.Standings;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Clase que obtiene los datos de Standings
public class RetrieveStandings {

    // Método que obtiene la clasificación de equipos de la conferencia Oeste
    public ArrayList<Standings> getStandingsWest() {

        // Instancia una lista de objetos Standings
        ArrayList<Standings> sList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/current/standings_conference.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray west = jobj.getJSONObject("league").getJSONObject("standard").getJSONObject("conference").getJSONArray("west");

            // Inicializa un contador
            int i = 0;

            // Controla la búsqueda de información por conferencia
            while (west.length() > i) {

                // Instancia un objeto de la clase Standings
                Standings standings = new Standings();

                // Rellena los datos del objeto Standings
                standings.setTeamId(west.getJSONObject(i).getString("teamId"));
                standings.setWin(west.getJSONObject(i).getString("win"));
                standings.setLoss(west.getJSONObject(i).getString("loss"));
                standings.setWinPct(west.getJSONObject(i).getString("winPct"));
                standings.setConfRank(west.getJSONObject(i).getString("confRank"));
                standings.setLastTenWin(west.getJSONObject(i).getString("lastTenWin"));
                standings.setLastTenLoss(west.getJSONObject(i).getString("lastTenLoss"));
                standings.setGamesBehind(west.getJSONObject(i).getString("gamesBehind"));
                standings.setStreak(west.getJSONObject(i).getJSONObject("teamSitesOnly").getString("streakText"));

                // Añade el objeto Scoreboard a la lista
                sList.add(standings);

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        }

        // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return sList;
    }

    // Método que obtiene la clasificación de equipos de la conferencia Este
    public ArrayList<Standings> getStandingsEast() {

        // Instancia una lista de objetos Standings
        ArrayList<Standings> pList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/current/standings_conference.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray east = jobj.getJSONObject("league").getJSONObject("standard").getJSONObject("conference").getJSONArray("east");

            // Inicializa un contador
            int i = 0;

            // Controla la búsqueda de información por conferencia
            while (east.length() > i) {

                // Instancia un objeto de la clase Standings
                Standings standings = new Standings();

                // Rellena los datos del objeto Standings
                standings.setTeamId(east.getJSONObject(i).getString("teamId"));
                standings.setWin(east.getJSONObject(i).getString("win"));
                standings.setLoss(east.getJSONObject(i).getString("loss"));
                standings.setWinPct(east.getJSONObject(i).getString("winPct"));
                standings.setConfRank(east.getJSONObject(i).getString("confRank"));
                standings.setLastTenWin(east.getJSONObject(i).getString("lastTenWin"));
                standings.setLastTenLoss(east.getJSONObject(i).getString("lastTenLoss"));
                standings.setGamesBehind(east.getJSONObject(i).getString("gamesBehind"));
                standings.setStreak(east.getJSONObject(i).getJSONObject("teamSitesOnly").getString("streakText"));

                // Añade el objeto Scoreboard a la lista
                pList.add(standings);

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }

        }

        // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return pList;
    }

}
