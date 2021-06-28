package controller;

import model.PlayerStats;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Clase que obtiene los datos de PlayerStats
public class RetrievePlayerStats {

    // Método que obtiene la lista de estadisticas de un jugador en concreto
    public ArrayList<PlayerStats> getPlayerStatsFromID(String playerID) {

        // Instancia una lista de objetos PlayerStats
        ArrayList<PlayerStats> sList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/2020/players/" + playerID + "_profile.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray data = jobj.getJSONObject("league").getJSONObject("standard").getJSONObject("stats").getJSONObject("regularSeason").getJSONArray("season");

            // Inicializa un contador
            int i = 0;

            // Controla la búsqueda de información por temporadas
            while (data.length() > i) {

                // El mismo jugador ha podido jugar en varios equipos la misma temproada, y con
                // este bucle recogemos sus estadísticas en cada uno de los equipos, y el total de la temporada
                // Controla la búsqueda de información por equipos, dentro de una misma temporada
                for (int j = 0; j < data.getJSONObject(i).getJSONArray("teams").length(); j++) {

                    // Instancia un objeto de la clase PlayerStats
                    PlayerStats stats = new PlayerStats();

                    // Accede al objeto necesario para obtener las  estadísticas en un equipo en concreto
                    JSONObject jobjSeason = data.getJSONObject(i).getJSONArray("teams").getJSONObject(j);

                    // Rellena los datos del objeto PlayerStats
                    stats.setSeasonYear(data.getJSONObject(i).getInt("seasonYear"));
                    stats.setGamesPlayed(jobjSeason.getString("gamesPlayed"));
                    stats.setTeamId(jobjSeason.getString("teamId"));
                    stats.setPpg(jobjSeason.getString("ppg"));
                    stats.setApg(jobjSeason.getString("apg"));
                    stats.setBpg(jobjSeason.getString("bpg"));
                    stats.setFgp(jobjSeason.getString("fgp"));
                    stats.setFtp(jobjSeason.getString("ftp"));
                    stats.setGamesStarted(jobjSeason.getString("gamesStarted"));
                    stats.setMpg(jobjSeason.getString("mpg"));
                    stats.setPlusMinus(jobjSeason.getString("plusMinus"));
                    stats.setRpg(jobjSeason.getString("rpg"));
                    stats.setSpg(jobjSeason.getString("spg"));
                    stats.setTopg(jobjSeason.getString("topg"));
                    stats.setTpp(jobjSeason.getString("tpp"));

                    // Añade el objeto PlayerStats a la lista
                    sList.add(stats);
                }

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return sList;
    }
}
