package game;
import casillaObjetos.casilla;

public class arena extends juego{
    public casilla[][] matrizJuego;
    public String tipoArena;

    public arena(int x,int y, int cantidaPersonajes,String tipo) {
        super(cantidaPersonajes);
        casilla[][] matrizJuego = new casilla[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                matrizJuego[i][j] = new casilla(x,y);
            }
        }
        tipoArena = tipo;
    }

    public String getTipoArena(){
        return tipoArena;
    }
}
