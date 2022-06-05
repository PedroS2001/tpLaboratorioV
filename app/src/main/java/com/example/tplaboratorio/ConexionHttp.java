package com.example.tplaboratorio;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionHttp {

    //PETICION GET SIN PARAMETROS
    public String obtenerInformacion(String urlEndpoint)
    {
        String respuesta = "";

        try {
            URL url = new URL(urlEndpoint);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            connection.connect();   //Realizo la peticion y se guardan los datos ne connection

            int responseCode = connection.getResponseCode();
            if(responseCode == 200)
            {
                InputStream iStream = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];

                int cantidadLeida=0;
                while ( (cantidadLeida = iStream.read(buffer)) != -1 )
                {
                    baos.write(buffer, 0, cantidadLeida);
                }

                iStream.close();

                respuesta = new String(baos.toByteArray(), "UTF-8");
                Log.d("LEYO:", "" + respuesta);

            }else {
                Log.d("ERROR", "Salio mal la consulta " + responseCode);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return respuesta;
    }

}
