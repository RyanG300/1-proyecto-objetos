package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;
import casillaObjetos.casilla;
import javax.swing.*;
import java.awt.*;



public class arena extends juego{
    public casilla[][] matrizJuego;
    public String tipoArena;
    private int x;
    private int y;

    public arena(int x, int y,String tipo, Character[] jugadoresTeam1, Character[] jugadoresTeam2, Tower[] torres1,Tower[] torres2){
        super(jugadoresTeam1,jugadoresTeam2,torres1,torres2);
        this.x=x;
        this.y=y;
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

    public JLayeredPane dibujarArena(JLayeredPane juego){
        int puntoDibujoX=100;
        int puntoDibujoY=10;
        for(int i=0;i<=this.x;i++){
            for(int j=0;j<=this.y;j++){
                JButton casilla=new JButton();
                casilla.setBounds(puntoDibujoX,puntoDibujoY,30,30);
                casilla.setText(i+" "+j);
                casilla.setBackground(Color.WHITE);
                casilla.setOpaque(true);
                juego.add(casilla,Integer.valueOf(1));
                puntoDibujoX+=30;
            }
            puntoDibujoY+=30;
            puntoDibujoX=100;
        }
        return juego;
    }
}
