package com.example.tplaboratorio;

import android.os.Handler;
import android.os.Message;


public class HiloConexion extends Thread{

    Handler colaMensajes;
    public HiloConexion(Handler handler)
    {
        this.colaMensajes = handler;
    }

    @Override
    public void run() {
        ConexionHttp con = new ConexionHttp();

        String respuesta = con.obtenerInformacion("https://www.thecocktaildb.com/api/json/v1/1/random.php");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message message = new Message();
        message.arg1 = 1;
        message.obj = respuesta;

        colaMensajes.sendMessage(message);
    }

}
