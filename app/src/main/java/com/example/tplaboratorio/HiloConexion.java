package com.example.tplaboratorio;

import java.util.logging.Handler;

public class HiloConexion extends Thread{

    Handler colaMensajes;
    public HiloConexion(Handler handler)
    {
        this.colaMensajes = handler;
    }

    @Override
    public void run() {
        super.run();
    }

}
