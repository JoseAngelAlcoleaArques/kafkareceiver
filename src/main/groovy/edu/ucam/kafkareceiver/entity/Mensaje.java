package edu.ucam.kafkareceiver.entity;

import java.util.Date;

public class Mensaje {

    private String id;
    private Date date;
    private String mensaje;

    public Mensaje(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
