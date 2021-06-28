package controller;

import model.Scoreboard;
import model.TeamScore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

// Clase que obtiene los datos de Scoreboard
public class RetrieveScoreboard {

    // Método que obtiene la lista de partidos en una fecha concreta
    public ArrayList<Scoreboard> getScoreboardsOnDay(String date) {

        // Instancia una lista de objetos Scoreboard
        ArrayList<Scoreboard> sList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/" + date + "/scoreboard.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray data = jobj.getJSONArray("games");

            // Inicializa un contador
            int i = 0;

            // Controla la búsqueda de información por partidos
            while (data.length() > i) {

                // Instancia un objeto de la clase Scoreboard
                Scoreboard sb = new Scoreboard();

                // Accede al objeto  que contiene los datos que necesitamos
                JSONObject jobjScore = data.getJSONObject(i);

                // Rellena los datos del objeto Scoreboard
                sb.setArenaCity(jobjScore.getJSONObject("arena").getString("city"));
                sb.setArenaName(jobjScore.getJSONObject("arena").getString("name"));
                sb.setClock(jobjScore.getString("clock"));
                sb.setCurrentPeriod(jobjScore.getJSONObject("period").getInt("current"));
                sb.setGameDuration(jobjScore.getJSONObject("gameDuration").getString("hours") + ":" + jobjScore.getJSONObject("gameDuration").getString("minutes"));
                sb.setGameId(jobjScore.getString("gameId"));
                sb.setSeasonStageId(jobjScore.getInt("seasonStageId"));
                sb.setSeasonYear(jobjScore.getString("seasonYear"));

                // Comprobamos que el partido es de playoffs
                if (jobjScore.getInt("seasonStageId") >= 4) {

                    // Si lo es, añadimos
                    sb.setSummaryText(jobjScore.getJSONObject("playoffs").getString("seriesSummaryText"));
                }

                // Indica el formato en el que viene dada la fecha de comienzo en UTC
                DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

                // Indica que la TimeZone en la que viene dado el dato es UTC
                utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

                // Convierte el objeto obtenido en otro de tipo Date
                Date gameUTC = utcFormat.parse(jobjScore.getString("startTimeUTC"));

                // Indica el formato en el que queremos que salga la fecha
                DateFormat pstFormat = new SimpleDateFormat("HH:mm");

                // Indica la timeZone en la que queremos que salga
                // Con TimeZone.getDefault se obtiene la zona horaria del sistema en ese momento
                pstFormat.setTimeZone(TimeZone.getDefault());

                // Almacenamos la hora ya formateada
                sb.setStartTime(pstFormat.format(gameUTC));

                sb.setStatusNum(jobjScore.getInt("statusNum"));

                // Instancia un objeto TeamScore para el equipo Local
                TeamScore localT = new TeamScore();

                // Rellena los datos del objeto TeamScore para el equipo Local
                localT.setTeamId(jobjScore.getJSONObject("hTeam").getString("teamId"));
                localT.setTricode(jobjScore.getJSONObject("hTeam").getString("triCode"));
                localT.setWin(jobjScore.getJSONObject("hTeam").getString("win"));
                localT.setLoss(jobjScore.getJSONObject("hTeam").getString("loss"));
                localT.setSeriesWin(jobjScore.getJSONObject("hTeam").getString("seriesWin"));
                localT.setSeriesLoss(jobjScore.getJSONObject("hTeam").getString("seriesLoss"));
                localT.setScore(jobjScore.getJSONObject("hTeam").getString("score"));

                // Instancia un objeto TeamScore para el equipo Visitante
                TeamScore visitorT = new TeamScore();

                // Rellena los datos del objeto TeamScore
                visitorT.setTeamId(jobjScore.getJSONObject("vTeam").getString("teamId"));
                visitorT.setTricode(jobjScore.getJSONObject("vTeam").getString("triCode"));
                visitorT.setWin(jobjScore.getJSONObject("vTeam").getString("win"));
                visitorT.setLoss(jobjScore.getJSONObject("vTeam").getString("loss"));
                visitorT.setSeriesWin(jobjScore.getJSONObject("vTeam").getString("seriesWin"));
                visitorT.setSeriesLoss(jobjScore.getJSONObject("vTeam").getString("seriesLoss"));
                visitorT.setScore(jobjScore.getJSONObject("vTeam").getString("score"));

                // Añade al objeto Scoreboard los dos equipos
                sb.setLocalTeam(localT);
                sb.setVisitorTeam(visitorT);

                // Añade el objeto Scoreboard a la lista
                sList.add(sb);

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
}
