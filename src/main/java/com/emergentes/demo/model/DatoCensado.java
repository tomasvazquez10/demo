package com.emergentes.demo.model;


public class DatoCensado {

    private Long id;
    private String temperatura;
    private String humedad;

    public DatoCensado(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        return "DatoCensado{" +
                "id=" + id +
                ", temperatura='" + temperatura + '\'' +
                ", humedad='" + humedad + '\'' +
                '}';
    }
}
