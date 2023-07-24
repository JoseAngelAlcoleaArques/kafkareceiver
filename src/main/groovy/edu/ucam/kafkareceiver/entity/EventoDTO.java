package edu.ucam.kafkareceiver.entity;

import edu.ucam.kafkareceiver.TipoEvento;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Map;

public class EventoDTO implements Serializable {

    private Timestamp fecha;
    private String id;
    private TipoEvento tipoEvento;
    private Long version;
    private Map<String, String> data;

    public EventoDTO() {
    }

    public EventoDTO(Timestamp fecha, String id, TipoEvento tipoEvento, Long version, Map<String, String> data) {
        this.fecha = fecha;
        this.id = id;
        this.tipoEvento = tipoEvento;
        this.version = version;
        this.data = data;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}

