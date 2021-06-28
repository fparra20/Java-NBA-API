package controller;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

// Clase asíncrona que ejecuta un hilo devuelve un JSONObject
public class RetrieveInfo {

    protected JSONObject execute(String... urls) {

        // Instancia un JSONObject vacío
        JSONObject jobj = null;

        // Control de excepciones
        try {

            // Crea un objeto URL con la que llega por parámetro
            URL url = new URL(urls[0]);

            // Abre una conexión HTTP con la URL anterior
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Indica el tipo de llamada a la página
            con.setRequestMethod("GET");

            // Instancia un String vacío
            String inline = "";

            // Crea la conexión
            con.connect();

            // Almacena la respuesta del servidor
            int responsecode = con.getResponseCode();

            // Si el servidor no responde con el código 200 significa que la conexión es invalida
            if (responsecode != 200) {

                // Lanza una excepción con la respuesta
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } // En caso contrario
            else {

                // Instancia un objeto Scanner que se rellena con el contenido de la web URL
                Scanner sc = new Scanner(url.openStream());

                // Controla que el scanner siga leyendo datos mientras haya
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }

                // Cierra el escaner
                sc.close();
            }

            // Formatea el String a tipo JSONObject
            jobj = new JSONObject(inline);

        } // Control de excepciones
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // Devuelve el JSONObject
        return jobj;
    }
}
