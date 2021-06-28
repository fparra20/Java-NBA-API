package controller;

import model.Player;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Clase que obtiene los datos de Player
public class RetrievePlayer {

    // Método que obtiene la lista de jugadores completa
    public ArrayList<Player> getPlayers() {

        // Instancia una lista de objetos Player
        ArrayList<Player> pList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/data/10s/prod/v1/2020/players.json");

            // Accede al array que contiene los datos que necesitamos
            JSONArray data = jobj.getJSONObject("league").getJSONArray("standard");

            // Inicializa un contador
            int i = 0;

            // Controla que siga habiendo datos en el array data
            while (data.length() > i) {

                // Instancia un objeto de la clase Player
                Player player = new Player();

                // Accede al objeto JSON correspondiente a la posición del bucle
                JSONObject jobjPlayer = data.getJSONObject(i);

                // Rellena los datos del objeto Player
                player.setPersonId(jobjPlayer.getString("personId"));

                player.setFirstName(jobjPlayer.getString("firstName"));

                player.setLastName(jobjPlayer.getString("lastName"));

                player.setJersey(jobjPlayer.getString("jersey"));

                player.setPos(jobjPlayer.getString("pos"));

                player.setTeamId(jobjPlayer.getString("teamId"));

                // Añade el objeto Player a la lista
                pList.add(player);

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return pList;
    }

    // Método que obtiene un jugador concreto a partir de su id y la url de su equipo
    public Player getPlayerInfoById(String id, String teamUrl) {

        // Instancia un objeto Player
        Player player = new Player();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/v2015/json/mobile_teams/nba/2020/teams/" + teamUrl + "_roster.json");

            // Accede al array que contiene los datos del equipo
            JSONObject dataTeam = jobj.getJSONObject("t");

            // Accede al array que contiene los datos del jugador que necesitamos
            JSONArray dataPlayer = jobj.getJSONObject("t").getJSONArray("pl");

            // Inicializa un contador
            int i = 0;

            // Controla que siga habiendo datos en el array data
            while (dataPlayer.length() > i) {

                // Controla el jugador sea el pasado por parámetro
                if (dataPlayer.getJSONObject(i).get("pid").toString().equals(id)) {

                    // Rellena los datos del objeto
                    player.setPersonId(dataPlayer.getJSONObject(i).get("pid").toString());

                    player.setCollegeName(dataPlayer.getJSONObject(i).getString("hcc"));

                    player.setCountry(dataPlayer.getJSONObject(i).getString("hcc"));

                    player.setDateOfBirthUTC(dataPlayer.getJSONObject(i).getString("dob"));

                    player.setFirstName(dataPlayer.getJSONObject(i).getString("fn"));

                    player.setHeight(dataPlayer.getJSONObject(i).getString("ht"));

                    player.setJersey(dataPlayer.getJSONObject(i).getString("num"));

                    player.setLastName(dataPlayer.getJSONObject(i).getString("ln"));

                    player.setPos(dataPlayer.getJSONObject(i).getString("pos"));

                    player.setTeamId(dataTeam.get("tid").toString());

                    player.setWeight(dataPlayer.getJSONObject(i).get("wt").toString());

                    player.setYearsPro(dataPlayer.getJSONObject(i).get("y").toString());
                }

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve el jugador
        return player;
    }

    // Método que obtiene una lista de jugadores de un equipo concreto
    public ArrayList<Player> getPlayersByTeamUrl(String teamUrl) {

        // Instancia una lista de objetos Player
        ArrayList<Player> pList = new ArrayList<>();

        // Instancia un objeto JSONObject
        JSONObject jobj;

        // Intenta lanzar el código, necesario para usar la clase RetrieveInfo
        try {

            // Obtiene el JSONObject con toda la información
            jobj = new RetrieveInfo().execute("https://data.nba.net/v2015/json/mobile_teams/nba/2020/teams/" + teamUrl + "_roster.json");

            // Accede al objeto que contiene los datos que necesitamos del equipo
            JSONObject dataTeam = jobj.getJSONObject("t");

            // Accede al array que contiene los datos que necesitamos
            JSONArray dataPlayer = jobj.getJSONObject("t").getJSONArray("pl");

            // Inicializa un contador
            int i = 0;

            // Controla que siga habiendo datos en el array data
            while (dataPlayer.length() > i) {

                // Instancia un objeto de la clase Boxscore
                Player player = new Player();

                // Rellena los datos del objeto
                player.setPersonId(dataPlayer.getJSONObject(i).get("pid").toString());

                player.setCollegeName(dataPlayer.getJSONObject(i).getString("hcc"));

                player.setCountry(dataPlayer.getJSONObject(i).getString("hcc"));

                player.setDateOfBirthUTC(dataPlayer.getJSONObject(i).getString("dob"));

                player.setFirstName(dataPlayer.getJSONObject(i).getString("fn"));

                player.setHeight(dataPlayer.getJSONObject(i).getString("ht"));

                player.setJersey(dataPlayer.getJSONObject(i).getString("num"));

                player.setLastName(dataPlayer.getJSONObject(i).getString("ln"));

                player.setPos(dataPlayer.getJSONObject(i).getString("pos"));

                player.setTeamId(dataTeam.get("tid").toString());

                player.setWeight(dataPlayer.getJSONObject(i).get("wt").toString());

                player.setYearsPro(dataPlayer.getJSONObject(i).get("y").toString());

                // Añade el objeto Player a la lista
                pList.add(player);

                // Suma 1 al contador para poder acceder al siguiente objeto.
                i++;

            }
        } // Control de excepciones
        catch (Exception e) {
            e.printStackTrace();
        }

        // Devuelve la lista completa
        return pList;
    }
}
