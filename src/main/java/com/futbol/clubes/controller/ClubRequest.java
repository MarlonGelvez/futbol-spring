package com.futbol.clubes.controller;

import java.util.List;

public class ClubRequest {
    private String nombre;
    private String ciudad;
    private int anioFundacion;
    private String entrenadorId;
    private List<String> jugadoresIds;
    private String asociacionId;
    private List<String> competicionesIds;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public int getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(int anioFundacion) { this.anioFundacion = anioFundacion; }
    public String getEntrenadorId() { return entrenadorId; }
    public void setEntrenadorId(String entrenadorId) { this.entrenadorId = entrenadorId; }
    public List<String> getJugadoresIds() { return jugadoresIds; }
    public void setJugadoresIds(List<String> jugadoresIds) { this.jugadoresIds = jugadoresIds; }
    public String getAsociacionId() { return asociacionId; }
    public void setAsociacionId(String asociacionId) { this.asociacionId = asociacionId; }
    public List<String> getCompeticionesIds() { return competicionesIds; }
    public void setCompeticionesIds(List<String> competicionesIds) { this.competicionesIds = competicionesIds; }
}
