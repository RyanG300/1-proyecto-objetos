package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;
import casillaObjetos.casilla;
import pruebaMovimiento.Arena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class arena extends juego{
    public casilla[][] matrizJuego;
    public String tipoArena;
    private int x;
    private int y;
    private int quienVaTorres=1;
    public int textoTurnos;
    public int cantidadTorresColocacion= torresTeam1.length;

    public arena(int x, int y,String tipo, Character[] jugadoresTeam1, Character[] jugadoresTeam2, Tower[] torres1,Tower[] torres2,int cantidadTorres){
        super(jugadoresTeam1,jugadoresTeam2,torres1,torres2,cantidadTorres);
        if(x%2!=0){
            x-=1;
        }
        this.x=x;
        this.y=y;
        casilla[][] matrizJuego = new casilla[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                matrizJuego[j][i] = new casilla(j,i);
            }
        }
        tipoArena = tipo;
        this.matrizJuego=matrizJuego;
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
    int puntoDibujoX=50;
    int puntoDibujoY=40;
    int widthHeight= (int) (50-((this.x >10) ? Math.round(this.x*0.9): 0));
    for(int i=1;i<=this.y;i++){
        for(int j=1;j<=this.x;j++){
            JButton casilla=new JButton();
            casilla.setBounds(puntoDibujoX,puntoDibujoY,widthHeight,widthHeight);
            //casilla.setFont(new Font("Arial",Font.BOLD,(this.x >10) ? 3:10));
            //casilla.setText(i+" "+j);
            casilla.setBackground(Color.WHITE);
            casilla.setOpaque(true);
            //JLabel imagenCasilla=new JLabel();
            //ImageIcon iconoBoton =new ImageIcon(tipoImagenCasilla);
            //Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
            //imagenCasilla.setIcon(iconBotonDeVerdad);
            //casilla.setIcon(iconBotonDeVerdad);
            if(j<=this.x/2){
                if(this.matrizJuego[i-1][j-1].id==0){
                    casilla.setBackground(Color.red);
                }
                else if(this.matrizJuego[i-1][j-1].id==1){
                    /*ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\torreIcono.png");
                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                    casilla.setIcon(iconBotonDeVerdad);*/
                    casilla.setBackground(Color.red);
                }
                else if(this.matrizJuego[i-1][j-1].id==2){
                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\torreIcono.png");
                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                    casilla.setIcon(iconBotonDeVerdad);
                    casilla.setBackground(Color.red);
                }
            }
            else{
                if(this.matrizJuego[i-1][j-1].id==0){
                    casilla.setBackground(Color.blue);
                }
                else if(this.matrizJuego[i-1][j-1].id==1){
                    /*ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\torreIcono.png");
                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                    casilla.setIcon(iconBotonDeVerdad);*/
                    casilla.setBackground(Color.blue);
                }
                else if(this.matrizJuego[i-1][j-1].id==2){
                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\torreIcono.png");
                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                    casilla.setIcon(iconBotonDeVerdad);
                    casilla.setBackground(Color.blue);
                }
            }
            int finalJ = j;
            int finalI = i;
            casilla.addActionListener(new ActionListener() {
                private int mitadArena=getMitadArena();
                private int x= finalJ-1;
                private int y= finalI-1;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(quienVaTorres==1){
                        if(x<=mitadArena){
                            if(matrizJuego[x][y].id!=2){
                                matrizJuego[x][y].id=2;
                                try{
                                    if(!torresTeam1[0].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam1[0];
                                        torresTeam1[0].colocado=true;
                                    }
                                    else if(!torresTeam1[1].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam1[1];
                                        torresTeam1[1].colocado=true;
                                    }
                                    else if(!torresTeam1[2].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam1[2];
                                        torresTeam1[2].colocado=true;
                                    }
                                }
                                catch (Exception ex){
                                    System.out.println(ex.getMessage());
                                }
                                textoTurnos=2;
                                cantidadTorresColocacion--;
                            }
                            else{
                                textoTurnos=3;
                            }
                        }
                        else{
                            textoTurnos=3;
                        }
                        System.out.println(x+" "+y);
                    }
                    else if(quienVaTorres==2){
                        if(x>mitadArena){
                            if(matrizJuego[x][y].id!=2){
                                matrizJuego[x][y].id=2;
                                try{
                                    if(!torresTeam2[0].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam2[0];
                                        torresTeam2[0].colocado=true;
                                    }
                                    else if(!torresTeam2[1].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam2[1];
                                        torresTeam2[1].colocado=true;
                                    }
                                    else if(!torresTeam2[2].colocado){
                                        matrizJuego[x][y].torreDentro=torresTeam2[2];
                                        torresTeam2[2].colocado=true;
                                    }
                                }
                                catch (Exception ex){
                                    System.out.println(ex.getMessage());
                                }
                                textoTurnos=1;
                                cantidadTorresColocacion--;
                            }
                            else{
                                textoTurnos=3;
                            }
                        }
                        else{
                            textoTurnos=3;
                        }
                        System.out.println(x+" "+y);
                    }
                }
            });
            juego.add(casilla,Integer.valueOf(1));
            puntoDibujoX+=widthHeight;
        }
        puntoDibujoY+=widthHeight;
        puntoDibujoX=50;
    }
    return juego;
    }

    public int getMitadArena(){
        return this.x/2;
    }

}
