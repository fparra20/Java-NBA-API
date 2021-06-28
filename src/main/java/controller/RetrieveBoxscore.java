package controller;

import model.Boxscore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Clase que obtiene los datos de Boxscore
public class RetrieveBoxscore {

    // Método que obtiene la lista de Boxscore a partir de la fecha y del Id del partido
    public ArrayList<Boxscore> getBoxscore(String date, String gameId) {

        // Instancia una lista de objetos Boxscore
        ArrayList<Boxscore> bsList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/" + date + "/" + gameId + "_boxscore.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray data = jobj.getJSONObject("stats").getJSONArray("activePlayers");

            // Inicializa un contador
            int i = 0;

            // Controla que siga habiendo datos en el array data
            while (data.length() > i) {

                // Instancia un objeto de la clase Boxscore
                Boxscore sb = new Boxscore();

                // Accede al objeto JSON correspondiente a la posición del bucle
                JSONObject jobjScore = data.getJSONObject(i);

                // Rellena los datos del objeto
                sb.setPersonId(jobjScore.getString("personId"));
                sb.setFirstName(jobjScore.getString("firstName"));
                sb.setLastName(jobjScore.getString("lastName"));
                sb.setJersey(jobjScore.getString("jersey"));
                sb.setTeamId(jobjScore.getString("teamId"));
                sb.setAssists(jobjScore.getString("assists"));
                sb.setBlocks(jobjScore.getString("blocks"));
                sb.setDefReb(jobjScore.getString("defReb"));
                sb.setDnp(jobjScore.getString("dnp"));
                sb.setFga(jobjScore.getString("fga"));
                sb.setFgm(jobjScore.getString("fgm"));
                sb.setFgp(jobjScore.getString("fgp"));
                sb.setFta(jobjScore.getString("fta"));
                sb.setFtm(jobjScore.getString("ftm"));
                sb.setFtp(jobjScore.getString("ftp"));
                sb.setMin(jobjScore.getString("min"));
                sb.setOffReb(jobjScore.getString("offReb"));
                sb.setPlusMinus(jobjScore.getString("plusMinus"));
                sb.setPoints(jobjScore.getString("points"));
                sb.setPos(jobjScore.getString("pos"));
                sb.setSteals(jobjScore.getString("steals"));
                sb.setTotReb(jobjScore.getString("totReb"));
                sb.setTpa(jobjScore.getString("tpa"));
                sb.setTpm(jobjScore.getString("tpm"));
                sb.setTpp(jobjScore.getString("tpp"));
                sb.setTurnovers(jobjScore.getString("turnovers"));
                sb.setpFouls(jobjScore.getString("pFouls"));

                // Añade el objeto Boxscore a la lista
                bsList.add(sb);

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return bsList;
    }
}
