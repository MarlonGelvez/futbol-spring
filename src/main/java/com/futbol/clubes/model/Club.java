package com.futbol.clubes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "clubes")
public class Club {

    @Id
    private String id;
    private String nombre;
    private String ciudad;
    private int anioFundacion;

    @DocumentReference
    private Entrenador entrenador;

    @DocumentReference
    private List<Jugador> jugadores;

    @DocumentReference
    private Asociacion asociacion;

    @DocumentReference
    private List<Competicion> competiciones;

    public Club() {}

    public Club(String id, String nombre, String ciudad, int anioFundacion,
                Entrenador entrenador, List<Jugador> jugadores,
                Asociacion asociacion, List<Competicion> competiciones) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.anioFundacion = anioFundacion;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.asociacion = asociacion;
        this.competiciones = competiciones;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public int getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(int anioFundacion) { this.anioFundacion = anioFundacion; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }
    public Asociacion getAsociacion() { return asociacion; }
    public void setAsociacion(Asociacion asociacion) { this.asociacion = asociacion; }
    public List<Competicion> getCompeticiones() { return competiciones; }
    public void setCompeticiones(List<Competicion> competiciones) { this.competiciones = competiciones; }
}
