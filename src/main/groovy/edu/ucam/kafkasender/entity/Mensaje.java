package edu.ucam.kafkasender.entity;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {

    private String id;
    private Date date;
    private String mensaje;

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
