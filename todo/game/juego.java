package game;
import casillaObjetos.Character;

public class juego {
    public Character[] jugadoresTeam1;
    public Character[] jugadoresTeam2;
    public boolean torresTeam1 = true;
    public boolean torresTeam2 = true;

    public juego(int cantidaPersonajes) {
        jugadoresTeam1 = new Character[cantidaPersonajes];
        jugadoresTeam2 = new Character[cantidaPersonajes];
    }

    public void setJugadores(Character[] jugadoresTeam, int cual) {
        if (cual == 1) {
            jugadoresTeam1 = jugadoresTeam;
        } else {
            jugadoresTeam2 = jugadoresTeam;
        }
    }


    public void revivirJugadores(int x, int y) {
        System.out.println(x + " " + y); //Esto evidentemete no, falta codigo
    }

    public void establecerGanador(){
        //tal
    }

    public void  establecerTurno(){
    }
}