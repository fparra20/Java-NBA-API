package controller;

import model.PlayoffsBracket;
import model.TeamPlayoffs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Clase que obtiene los datos de Playoffs
public class RetrievePlayoffs {

    // Método que obtiene la lista de partidos de playoffs en un año concreto
    public ArrayList<PlayoffsBracket> getPlayOffsByYear(int year) {

        // Instancia una lista de objetos PlayoffsBracket
        ArrayList<PlayoffsBracket> poList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/v2015/json/mobile_teams/nba/" + year + "/scores/00_playoff_bracket.json");

            // Inicializa un contador
            int i = 0;

            // Accede al array que contiene los datos que necesitamos
            JSONArray rounds = jobj.getJSONObject("pb").getJSONArray("r");

            // Controla la búsqueda de información por rondas
            while (rounds.length() > i) {

                // Inicializa un contador
                int j = 0;

                // Accede al array que contiene los datos que necesitamos
                JSONArray conferences = jobj.getJSONObject("pb").getJSONArray("r").getJSONObject(i).getJSONArray("co");

                // Controla la búsqueda de información por conferencias
                while (conferences.length() > j) {

                    // Accede al array que contiene los datos que necesitamos
                    JSONArray series = jobj.getJSONObject("pb").getJSONArray("r").getJSONObject(i).getJSONArray("co").getJSONObject(j).getJSONArray("ser");

                    // Inicializa un contador
                    int k = 0;

                    // Controla la búsqueda de información por series de partidos
                    while (series.length() > k) {

                        // Instancia un objeto de la clase PlayoffsBracket
                        PlayoffsBracket po = new PlayoffsBracket();

                        // Rellena los datos del objeto PlayOffs
                        po.setRoundNum(String.valueOf(rounds.getJSONObject(i).getInt("id")));

                        po.setConfName(conferences.getJSONObject(j).getString("val"));

                        po.setGameNumber(series.getJSONObject(k).getInt("in"));

                        po.setSummaryStatusText(series.getJSONObject(k).getString("seri"));

                        // Instancia un objeto de la clase TeamPlayoffs para almacenar el equipo superior
                        TeamPlayoffs bottomRow = new TeamPlayoffs();

                        // Rellena los datos del objeto TeamPlayoffs
                        bottomRow.setSeedNum(series.getJSONObject(k).getString("t2s"));

                        bottomRow.setWins(String.valueOf(series.getJSONObject(k).getInt("t2w")));

                        bottomRow.setTeamId(series.getJSONObject(k).get("tid2").toString());

                        // Instancia un objeto de la clase TeamPlayoffs para almacenar el equipo inferior
                        TeamPlayoffs topRow = new TeamPlayoffs();

                        // Rellena los datos del objeto TeamPlayoffs
                        topRow.setSeedNum(series.getJSONObject(k).getString("t1s"));

                        topRow.setWins(String.valueOf(series.getJSONObject(k).getInt("t1w")));

                        topRow.setTeamId(series.getJSONObject(k).get("tid1").toString());

                        // Añade el objeto TeamPlayoffs al objeto PlayoffsBracket
                        po.setBottomRow(bottomRow);

                        // Añade el objeto TeamPlayoffs al objeto PlayoffsBracket
                        po.setTopRow(topRow);

                        // Añade el objeto PlayoffsBracket a la lista
                        poList.add(po);

                        // Suma 1 al contador para poder acceder al siguiente objeto.
                        k++;
                    }

                    // Suma 1 al contador para poder acceder al siguiente objeto.
                    j++;
                }

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;
            }

        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return poList;
    }

    // Método que obtiene la lista de partidos de playoffs en un año concreto
    public ArrayList<PlayoffsBracket> getPlayOffsByYearConfRound(int year, String conf, String round) {

        // Instancia una lista de objetos PlayoffsBracket para el año en concreto
        ArrayList<PlayoffsBracket> poList = getPlayOffsByYear(year);

        // Instancia una lista de objetos PlayoffsBracket
        ArrayList<PlayoffsBracket> poFiltered = new ArrayList<>();

        // Recorre la lista de Playoffs y la devuelve según
        for (int i = 0; i < poList.size(); i++) {

            // Comprueba que la conferencia y ronda
            if (poList.get(i).getConfName().equals(conf) && poList.get(i).getRoundNum().equals(round)) {

                // Añade el objeto PlayoffsBracket a la lista filtrada
                poFiltered.add(poList.get(i));
            }
        }

        // Devuelve la lista completa
        return poFiltered;
    }
}
