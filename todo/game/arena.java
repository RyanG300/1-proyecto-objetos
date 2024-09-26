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

    public void colocarPersonaje(int x, int y,String name,boolean queLista) {
        if(queLista){
            for(int i=0;i>jugadoresTeam1.length;i++){
                if (jugadoresTeam1[i].name==name) {
                    matrizJuego[x][y].id=1;
                    matrizJuego[x][y].personajeDentro=jugadoresTeam1[i];
                }
            }
        }
        else{
            for(int i=0;i>jugadoresTeam2.length;i++){
                if (jugadoresTeam2[i].name==name) {
                    matrizJuego[x][y].id=1;
                    matrizJuego[x][y].personajeDentro=jugadoresTeam2[i];
                }
            }
        }
    }
    public void colocarTorre(int x,int y){ //falta

    }
}
