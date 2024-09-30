package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;

public class juego {
    public Character[] jugadoresTeam1;
    public Character[] jugadoresTeam2;
    public Tower[] torresTeam1;
    public Tower[] torresTeam2;
    public boolean torresTeam1Estado = true;
    public boolean torresTeam2Estado = true;


    public juego(Character[] jugadoresTeam1, Character[] jugadoresTeam2, Tower[] torresTeam1, Tower[] torresTeam2) {
        this.jugadoresTeam1 = jugadoresTeam1;
        this.jugadoresTeam2 = jugadoresTeam2;
        this.torresTeam1 = torresTeam1;
        this.torresTeam2 = torresTeam2;
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

    public void establecerGanador(){
        //tal
    }

    public void  establecerTurno(){
    }
}