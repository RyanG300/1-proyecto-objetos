package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;
import casillaObjetos.casilla;
import ui.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class arena extends juego{
    public casilla[][] matrizJuego;
    public String tipoArena;
    private int x;
    private int y;
    private int quienVaTurnos =1;
    //public int textoTurnos;
    public int cantidadTorresColocacion= torresTeam1.length;
    public boolean estadoColocacionPersonajes=false;
    public Character guardadoSeleccionado;

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

    public JLayeredPane dibujarArena(JLayeredPane juego){ //JLabel TEXTO
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
                casilla.setLayout(null);
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
                }  //Para establecer los límites de la arena
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
                }   //Para establecer los límites de la arena
                int finalJ = j;
                int finalI = i;
                casilla.addActionListener(new ActionListener() {
                    private int mitadArena=getMitadArena();
                    private int x= finalJ-1;
                    private int y= finalI-1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cantidadTorresColocacion!=0){
                            if(quienVaTurnos ==1){
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
                                        ImageIcon iconoBoton =new ImageIcon((x<=mitadArena) ? (System.getProperty("user.dir")+"\\todo\\images\\torreIconoRojo.png"):(System.getProperty("user.dir")+"\\todo\\images\\torreIconoAzul.png"));
                                        Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                        casilla.setIcon(iconBotonDeVerdad);
                                        home.textoPorDefectoTurnos.setText("Jugador 2#, por favor eliga la ubicación de su torre (Quedan "+cantidadTorresColocacion+")");
                                        quienVaTurnos =2;
                                    }
                                    else{
                                        home.textoPorDefectoTurnos.setText("Error: No se puede colocar una torre en el lado contrario de la arena");
                                    }
                                }
                                else{
                                    home.textoPorDefectoTurnos.setText("Error: No se puede colocar una torre en el lado contrario de la arena");
                                }
                                System.out.println(x+" "+y);
                            }
                            else if(quienVaTurnos ==2){
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
                                        ImageIcon iconoBoton =new ImageIcon((x<=mitadArena) ? System.getProperty("user.dir")+"\\todo\\images\\torreIconoRojo.png":System.getProperty("user.dir")+"\\todo\\images\\torreIconoAzul.png");
                                        Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                        casilla.setIcon(iconBotonDeVerdad);
                                        cantidadTorresColocacion--;
                                        quienVaTurnos =1;
                                        if(cantidadTorresColocacion==0){
                                            home.textoPorDefectoTurnos.setText("Torres colocadas. Ahora el jugador #1 debe colocar sus personajes.");
                                            home.colocarBotonesDesdeArena(jugadoresTeam1.length,true);
                                            estadoColocacionPersonajes=true;
                                            /*JButton prueba=new JButton("Prueba");
                                            prueba.setBounds(820,90,30,30);
                                            prueba.addActionListener(new ActionListener() {

                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    System.out.println("Pingas");
                                                }
                                            });
                                            juego.add(prueba);*/
                                        }
                                        else{
                                            home.textoPorDefectoTurnos.setText("Jugador #1, por favor eliga la ubicación de su torre (Quedan "+cantidadTorresColocacion+")");
                                        }
                                    }
                                    else{
                                        home.textoPorDefectoTurnos.setText("Error: No se puede colocar una torre en el lado contrario de la arena");
                                    }
                                }
                                else{
                                    home.textoPorDefectoTurnos.setText("Error: No se puede colocar una torre en el lado contrario de la arena");
                                }
                                System.out.println(x+" "+y);
                            }
                        }
                        else {
                            if(estadoColocacionPersonajes){
                                if(!home.presionado){
                                    home.textoPorDefectoTurnos.setText("Personaje no seleccionado, por favor seleccione un personaje para colocar en la arena");
                                }
                                else{
                                    if(quienVaTurnos==1){
                                        if(x<=mitadArena){
                                            matrizJuego[x][y].id=1;
                                            matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\"+"champion"+guardadoSeleccionado.name+".png");
                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                            casilla.setIcon(iconBotonDeVerdad);
                                            //casilla.setBackground((x<=this.x/2) ? Color.red:Color.blue);
                                            home.presionado=false;
                                            home.cantidadPersonajesRestantes--;
                                            if(home.cantidadPersonajesRestantes==0){
                                                home.cantidadPersonajesRestantes=jugadoresTeam1.length;
                                                home.textoPorDefectoTurnos.setText("Jugador #2 coloque sus personajes en su parte de la Arena");
                                                quienVaTurnos=2;
                                                home.colocarBotonesDesdeArena(jugadoresTeam1.length,false);
                                            }
                                        }
                                        else{
                                            home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje en el lado contrario");
                                        }
                                    }
                                    else if(quienVaTurnos==2){
                                        if(x>mitadArena){
                                            matrizJuego[x][y].id=1;
                                            matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\"+"champion"+guardadoSeleccionado.name+".png");
                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                            casilla.setIcon(iconBotonDeVerdad);
                                            //casilla.setBackground((x<=this.x/2) ? Color.red:Color.blue);
                                            home.presionado=false;
                                            home.cantidadPersonajesRestantes--;
                                            if(home.cantidadPersonajesRestantes==0){
                                                home.textoPorDefectoTurnos.setText("Jugador #2 coloque sus personajes en su parte de la Arena");
                                                home.colocarBotonesDesdeArena(jugadoresTeam1.length,false);
                                            }
                                        }
                                        else{
                                            home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje en el lado contrario");
                                        }
                                    }
                                }
                            }
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
