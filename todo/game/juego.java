package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;
import ui.home;

import java.util.Random;
import java.util.random.*;

public class juego {
    public Character[] jugadoresTeam1;
    public Character[] jugadoresTeam2;
    public Tower[] torresTeam1;
    public Tower[] torresTeam2;
    public boolean torresTeam1Estado = true;
    public boolean torresTeam2Estado = true;
    public int cantidadTorres;
    public int turno;


    public juego(Character[] jugadoresTeam1, Character[] jugadoresTeam2, Tower[] torresTeam1, Tower[] torresTeam2,int cantidadTorres) {
        this.jugadoresTeam1 = jugadoresTeam1;
        this.jugadoresTeam2 = jugadoresTeam2;
        this.torresTeam1 = torresTeam1;
        this.torresTeam2 = torresTeam2;
        this.cantidadTorres=cantidadTorres;
    }

/*
    public void setJugadores(Character[] jugadoresTeam, int cual) {
        if (cual == 1) {
            jugadoresTeam1 = jugadoresTeam;
        } else {
            jugadoresTeam2 = jugadoresTeam;
        }
    }*/

    public void revivirJugadores(int x, int y) {
        System.out.println(x + " " + y); //Esto evidentemete no, falta codigo
    }

    public boolean establecerGanador(){
        int contador=0;
        for(int a=0;a<torresTeam1.length;a++){
            if(torresTeam1[a].destroyed){
                contador++;
            }
        }
        if(contador==torresTeam1.length){
            home.eventosPartida.append("El ganador es el jugador 2.");
            home.textoPorDefectoTurnos.setText("El ganador es el jugador 2.");
            return true;
        }
        contador=0;
        for(int a=0;a<torresTeam2.length;a++){
            if(torresTeam2[a].destroyed){
                contador++;
            }
        }
        if(contador==torresTeam2.length){
            home.eventosPartida.append("El ganador es el jugador 1.");
            home.textoPorDefectoTurnos.setText("El ganador es el jugador 1.");
            return true;
        }
        return false;
    }

    public boolean establecerTurno(){
        Random rand = new Random();
        return (rand.nextBoolean());
    }

    public int establecerTurnoPersonaje(Character[] jugadoresTeam){
        int contador=0;
        for(int a=0;a<jugadoresTeam.length;a++){
            if(jugadoresTeam[a].turnoRealizadoPersonaje){
                contador++;
            }
        }
        if(contador==jugadoresTeam.length){
            home.eventosPartida.setText("");
            return -5;
        }
        while(true){
            Random rand = new Random();
            int randomJugador=rand.nextInt(jugadoresTeam.length);
            if(!jugadoresTeam[randomJugador].turnoRealizadoPersonaje){
                //jugadoresTeam[randomJugador].turnoRealizadoPersonaje=true;
                return randomJugador;
            }
        }
    }
}