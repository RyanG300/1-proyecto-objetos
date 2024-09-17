package game;
import casillaObjetos.personaje;

public class juego {
    public personaje[] jugadoresTeam1;
    public personaje[] jugadoresTeam2;
    public boolean torresTeam1 = true;
    public boolean torresTeam2 = true;

    public juego(int cantidaPersonajes) {
        jugadoresTeam1 = new personaje[cantidaPersonajes];
        jugadoresTeam2 = new personaje[cantidaPersonajes];
    }

    public void setJugadores(personaje[] jugadoresTeam, int cual) {
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