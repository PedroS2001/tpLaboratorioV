package com.example.tplaboratorio;

import android.os.Handler;
import android.os.Message;


public class HiloConexion extends Thread{

    Handler colaMensajes;
    private Integer tipo;
    private String url;
    private Integer pos;

    public HiloConexion(Handler handler, String url, int tipo, int pos) {
        this.colaMensajes = handler;
        this.url = url;
        this.tipo = tipo;
        this.pos = pos;
    }

    @Override
    public void run() {
        ConexionHttp con = new ConexionHttp();
        byte[] respuesta = con.obtenerInformacion(url);

        if(this.tipo == 1)
        {
            String respuestaString = new String(respuesta);

            Message message = new Message();
            message.arg1 = 1;
            message.obj = respuestaString;
            colaMensajes.sendMessage(message);
        }
        else if(this.tipo == 2)
        {
            String respuestaString = new String(respuesta);

            Message message = new Message();
            message.arg1 = 2;
            message.obj = respuestaString;
            colaMensajes.sendMessage(message);
        }
        else if(this.tipo == 3)
        {
            Message message = new Message();
            message.arg1 = 3;
            message.arg2 = this.pos;
            message.obj = respuesta;
            this.colaMensajes.sendMessage(message);
        }


    }

}
