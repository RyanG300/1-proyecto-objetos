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

    public void colocarPersonaje(int x, int y,String name) {
        matrizJuego[x][y].id=1;
        for(int i=0;i>jugadoresTeam1.length;i++){

        }
        matrizJuego[x][y].personajeDentro=

    }

}
