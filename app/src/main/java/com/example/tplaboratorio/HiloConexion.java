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
        boolean texto = false;//////////SOLO PARA QUE NO ROMPA
        ConexionHttp con = new ConexionHttp();
        byte[] respuesta = con.obtenerInformacion("https://apiequipospedro.herokuapp.com/jugadores");
        String respuestaString = new String(respuesta);
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Message message = new Message();
        message.arg1 = 1;
        message.obj = respuestaString;
        colaMensajes.sendMessage(message);



        if(!texto){

        }

    }

}
