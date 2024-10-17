package game;
import casillaObjetos.Character;
import casillaObjetos.Tower;
import casillaObjetos.casilla;
import ui.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;


public class arena extends juego{
    public static casilla[][] matrizJuego;
    public static JButton[][] matrizJuegoBottons;
    public String tipoArena;
    private int x;
    private int y;
    private int quienVaTurnos =1;
    //public int textoTurnos;
    public int cantidadTorresColocacion= torresTeam1.length;
    public static boolean estadoColocacionPersonajes=false;
    public static Character guardadoSeleccionado; //Espacio de guardado de un personaje para moverlo como atacar con el
    public static  int[] guardadoCords;

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
        JButton[][] matrizJuegoBottons = new JButton[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matrizJuegoBottons[j][i] = new JButton();
            }
        }
        tipoArena = tipo;
        arena.matrizJuego =matrizJuego;
        arena.matrizJuegoBottons =matrizJuegoBottons;
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
                int finalPuntoDibujoX = puntoDibujoX;
                int finalPuntoDibujoY = puntoDibujoY;
                casilla.addActionListener(new ActionListener() {
                    private int mitadArena=getMitadArena();
                    private int x= finalJ-1;
                    private int y= finalI-1;
                    private int[] cordsDibujo ={finalPuntoDibujoX, finalPuntoDibujoY};
                    //public int p;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println(x+" "+y);
                        if(cantidadTorresColocacion!=0){
                            if(quienVaTurnos ==1){
                                if(x<=mitadArena-1){
                                    if(matrizJuego[x][y].id!=2){
                                        arena.matrizJuego[x][y].id=2;
                                        try{
                                            if(!torresTeam1[0].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam1[0];
                                                torresTeam1[0].colocado=true;
                                            }
                                            else if(!torresTeam1[1].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam1[1];
                                                torresTeam1[1].colocado=true;
                                            }
                                            else if(!torresTeam1[2].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam1[2];
                                                torresTeam1[2].colocado=true;
                                            }
                                        }
                                        catch (Exception ex){
                                            System.out.println(ex.getMessage());
                                        }
                                        ImageIcon iconoBoton =new ImageIcon((x<=mitadArena-1) ? (System.getProperty("user.dir")+"\\todo\\images\\torreIconoRojo.png"):(System.getProperty("user.dir")+"\\todo\\images\\torreIconoAzul.png"));
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
                                if(x>mitadArena-1){
                                    if(matrizJuego[x][y].id!=2){
                                        arena.matrizJuego[x][y].id=2;
                                        try{
                                            if(!torresTeam2[0].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam2[0];
                                                torresTeam2[0].colocado=true;
                                            }
                                            else if(!torresTeam2[1].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam2[1];
                                                torresTeam2[1].colocado=true;
                                            }
                                            else if(!torresTeam2[2].colocado){
                                                arena.matrizJuego[x][y].torreDentro=torresTeam2[2];
                                                torresTeam2[2].colocado=true;
                                            }
                                        }
                                        catch (Exception ex){
                                            System.out.println(ex.getMessage());
                                        }
                                        ImageIcon iconoBoton =new ImageIcon((x<=mitadArena-1) ? System.getProperty("user.dir")+"\\todo\\images\\torreIconoRojo.png":System.getProperty("user.dir")+"\\todo\\images\\torreIconoAzul.png");
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
                                        if(x<=mitadArena-1){
                                            if(arena.matrizJuego[x][y].id==1 || arena.matrizJuego[x][y].id==2){
                                                home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje encima de otro personaje");
                                            }
                                            else{
                                                arena.matrizJuego[x][y].id=1;
                                                arena.matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
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
                                        }
                                        else{
                                            home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje en el lado contrario");
                                        }
                                    }
                                    else if(quienVaTurnos==2){
                                        if(x>mitadArena-1){
                                            if (arena.matrizJuego[x][y].id == 1 || arena.matrizJuego[x][y].id==2) {
                                                home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje encima de otro personaje");
                                            }
                                            else{
                                                arena.matrizJuego[x][y].id=1;
                                                arena.matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
                                                ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\"+"champion"+guardadoSeleccionado.name+".png");
                                                Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                casilla.setIcon(iconBotonDeVerdad);
                                                //casilla.setBackground((x<=this.x/2) ? Color.red:Color.blue);
                                                home.presionado=false;
                                                home.cantidadPersonajesRestantes--;
                                                if(home.cantidadPersonajesRestantes==0) {
                                                    Random rand = new Random();
                                                    boolean que = rand.nextBoolean();
                                                    int turnoPersonaje = establecerTurnoPersonaje((que) ? jugadoresTeam1 : jugadoresTeam2);
                                                    home.textoPorDefectoTurnos.setText("Partida empezada: Turno de: " + ((que) ? "jugador #1" : "jugador #2"));
                                                    home.eventosPartida.append("(Turn character) Es es turno del personaje " + ((que) ? jugadoresTeam1[turnoPersonaje].name : jugadoresTeam2[turnoPersonaje].name) + ".\n");
                                                    guardadoSeleccionado = ((que) ? jugadoresTeam1[turnoPersonaje] : jugadoresTeam2[turnoPersonaje]);
                                                    estadoColocacionPersonajes = false;
                                                    turno = (que) ? 1 : 2;
                                                }
                                            }


                                        }
                                        else{
                                            home.textoPorDefectoTurnos.setText("Error: No se puede colocar un personaje en el lado contrario");
                                        }
                                    }
                                }
                            }
                            else{
                                /*JButton temp =new JButton();
                                JButton temp3=new JButton();
                                JButton temp4=new JButton();
                                JButton temp5=new JButton();
                                temp.setText("ataque");
                                temp3.setText("habilidad1");
                                temp5.setText("habilidad2");
                                temp4.setText("movimiento");*/
                                if(arena.matrizJuego[x][y].bajoAtaque || arena.matrizJuego[x][y].habilidad1BajoAtaque || arena.matrizJuego[x][y].habilidad2BajoAtaque){ //Logica para el ataque
                                    if(arena.matrizJuego[x][y].personajeDentro!=null && arena.matrizJuego[x][y].id==1){
                                        for(int r=0;r<jugadoresTeam1.length;r++){
                                            if(Objects.equals(arena.matrizJuego[x][y].personajeDentro.name, jugadoresTeam1[r].name)){
                                                //Buscamos si la persona a la que se le esta atacando esta en la lista uno, si no luego se ve en la lista 2
                                                //Primero quitamos la etiqueta de bajo ataque a las casillas
                                                boolean ataqueAliado=false;
                                                for(int t=0;t<jugadoresTeam1.length;t++){
                                                    if(Objects.equals(jugadoresTeam1[t].name, guardadoSeleccionado.name)){
                                                        home.eventosPartida.append("(Error) No se puede atacar a un personaje aliado. \n");
                                                        ataqueAliado=true;
                                                        break;
                                                    }
                                                }
                                                if(ataqueAliado){
                                                    for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                        for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                            if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                                arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                                if(matrizJuego[x][y].bajoAtaque){
                                                    double totalDamage=guardadoSeleccionado.getDamage()+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                    jugadoresTeam1[r].TakesDamagePerAttack(totalDamage);
                                                    arena.matrizJuego[x][y].personajeDentro.TakesDamagePerAttack(totalDamage);
                                                    home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam1[r].name+" [Jugador 1] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [jugador 2] quedándose a "+ jugadoresTeam1[r].getLife()+" puntos de vida.\n");
                                                }
                                                else if (matrizJuego[x][y].habilidad1BajoAtaque || matrizJuego[x][y].habilidad2BajoAtaque) {
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1].manaCost){
                                                        double totalDamage=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].damage+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        for(int b=0;b<jugadoresTeam2.length;b++){
                                                            if(jugadoresTeam2[b].name==guardadoSeleccionado.name){
                                                                jugadoresTeam2[b].mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                            }
                                                        }
                                                        arena.matrizJuego[x][y].personajeDentro.TakesDamagePerAttack(totalDamage);
                                                        jugadoresTeam1[r].TakesDamagePerAttack(totalDamage);
                                                        home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam1[r].name+" [Jugador 1] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [jugador 2] quedándose a "+ jugadoresTeam1[r].getLife()+" puntos de vida.\n");
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam1[r].name+" [Jugador 1] ha recibido un ataque por parte de "+guardadoSeleccionado.name+" [jugador 2]. Sin embargo, debido a la falta de maná el ataque no se realizó. \n");
                                                    }
                                                }

                                                /*double totalDamage = guardadoSeleccionado.getDamage()+ ((Objects.equals(tipoArena, guardadoSeleccionado.getElement())) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                (jugadoresTeam1[r]).TakesDamegePerAttack(totalDamage);
                                                matrizJuego[x][y].personajeDentro.TakesDamegePerAttack(totalDamage);
                                                home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam1[r].name+" [Jugador 1] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [jugador 2] quedándose a "+ jugadoresTeam1[r].getLife()+" puntos de vida.\n");*/
                                                for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                    for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                        if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                            arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                    }
                                                }


                                                if(jugadoresTeam1[r].getLife()<=0){ //Si el personaje que recibio daño se queda a cero muere y se elimina de la arena de juego
                                                    arena.matrizJuego[x][y].personajeDentro=null;
                                                    jugadoresTeam1[r].setLife();
                                                    jugadoresTeam1[r].dead=true;
                                                    casilla.setIcon(null);
                                                    home.eventosPartida.append("(Dead) el personaje "+jugadoresTeam1[r].name +" [Jugador 1] ha muerto en combate.\n");
                                                }
                                                else{
                                                    int temp2 =establecerTurnoPersonaje(jugadoresTeam2);
                                                    if(temp2==-5){
                                                        turno=(turno==1)?2:1;
                                                        for(int i=0;i<jugadoresTeam2.length;i++){
                                                            jugadoresTeam2[i].turnoRealizadoPersonaje=false;
                                                            jugadoresTeam2[i].resetMove();
                                                            boolean salir=false;
                                                            if(jugadoresTeam2[i].dead){
                                                                jugadoresTeam2[i].dead=false;
                                                                for(int q=0;q<matrizJuego.length;q++){
                                                                    for(int z=0;z<matrizJuego[q].length;z++){
                                                                        if(matrizJuego[z][q].torreDentro!=null){
                                                                            for(int u=0;u<torresTeam2.length;u++){
                                                                                if(matrizJuego[z][q].torreDentro.id==torresTeam2[u].id){
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        if(salir){
                                                                            break;
                                                                        }
                                                                    }
                                                                    if(salir){
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        temp2 =establecerTurnoPersonaje(jugadoresTeam1);
                                                        home.eventosPartida.append("(Turn player) Es el turno del jugador uno.\n");
                                                        home.textoPorDefectoTurnos.setText("Turno de jugador 1#");
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                        jugadoresTeam1[temp2].turnoRealizadoPersonaje=true;
                                                        guardadoSeleccionado=jugadoresTeam1[temp2];
                                                    }
                                                    else{
                                                        for(int i=0;i<jugadoresTeam2.length;i++){
                                                            if(guardadoSeleccionado.name.equals(jugadoresTeam2[i].name)){
                                                                jugadoresTeam2[i].turnoRealizadoPersonaje=true;
                                                                break;
                                                            }
                                                        }
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                        guardadoSeleccionado=jugadoresTeam2[temp2];
                                                    }
                                                }
                                            }
                                            else if(Objects.equals(arena.matrizJuego[x][y].personajeDentro.name, jugadoresTeam2[r].name)){
                                                //Primero calculamos si no fue daño aliado
                                                //Establecemos de nuevo las casillas a no bajoAtaque
                                                //Primero quitamos la etiqueta de bajo ataque a las casillas
                                                boolean ataqueAliado=false;
                                                for(int t=0;t<jugadoresTeam2.length;t++){
                                                    if(Objects.equals(jugadoresTeam2[t].name, guardadoSeleccionado.name)){
                                                        home.eventosPartida.append("(Error) No se puede atacar a un personaje aliado. \n");
                                                        ataqueAliado=true;
                                                        break;
                                                    }
                                                }
                                                if(ataqueAliado){
                                                    for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                        for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                            if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                                arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }

                                                //Aqui se calcula el daño tanto por ataque común como por habilidad
                                                if(arena.matrizJuego[x][y].bajoAtaque){
                                                    double totalDamage = guardadoSeleccionado.getDamage()+ ((Objects.equals(tipoArena, guardadoSeleccionado.getElement())) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                    (jugadoresTeam2[r]).TakesDamagePerAttack(totalDamage);
                                                    arena.matrizJuego[x][y].personajeDentro.TakesDamagePerAttack(totalDamage);
                                                    home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam2[r].name+" [Jugador 2] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [Jugador 1] quedándose a "+ jugadoresTeam2[r].getLife()+" puntos de vida.\n");
                                                }
                                                else if (arena.matrizJuego[x][y].habilidad1BajoAtaque || arena.matrizJuego[x][y].habilidad2BajoAtaque) {
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].manaCost){
                                                        double totalDamage=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].damage+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        for(int b=0;b<jugadoresTeam1.length;b++){
                                                            if(jugadoresTeam1[b].name==guardadoSeleccionado.name){
                                                                jugadoresTeam1[b].mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                            }
                                                        }
                                                        arena.matrizJuego[x][y].personajeDentro.TakesDamagePerAttack(totalDamage);
                                                        jugadoresTeam2[r].TakesDamagePerAttack(totalDamage);
                                                        home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam2[r].name+" [Jugador 2] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [jugador 1] quedándose a "+ jugadoresTeam2[r].getLife()+" puntos de vida.\n");
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam2[r].name+" [Jugador 2] ha recibido un ataque por parte de "+guardadoSeleccionado.name+" [jugador 1]. Sin embargo, debido a la falta de maná el ataque no se realizó. \n");
                                                    }
                                                }
                                                //Vemos si el tipo de elemento de la arena concuerda con el que esta atacando, si es asi la victima recibe más daño
                                                /*double totalDamage = guardadoSeleccionado.getDamage()+ ((Objects.equals(tipoArena, guardadoSeleccionado.getElement())) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                (jugadoresTeam2[r]).TakesDamagePerAttack(totalDamage);
                                                matrizJuego[x][y].personajeDentro.TakesDamagePerAttack(totalDamage);
                                                home.eventosPartida.append("(Attack) El personaje "+jugadoresTeam2[r].name+" [Jugador 2] ha recibido un total de "+totalDamage+" punto de daño de parte de "+guardadoSeleccionado.name+" [Jugador 1] quedándose a "+ jugadoresTeam2[r].getLife()+" puntos de vida.\n");*/
                                                for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                    for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                        if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                            arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                    }
                                                }

                                                if(jugadoresTeam2[r].getLife()<=0){ //Si el personaje que recibio daño se queda a cero muere y se elimina de la arena de juego
                                                    arena.matrizJuego[x][y].personajeDentro=null;
                                                    jugadoresTeam2[r].setLife();
                                                    jugadoresTeam2[r].dead=true;
                                                    casilla.setIcon(null);
                                                    home.eventosPartida.append("(Dead) el personaje "+jugadoresTeam2[r].name +" [Jugador 2] ha muerto en combate.\n");
                                                }
                                                else{
                                                    int temp2 =establecerTurnoPersonaje(jugadoresTeam1);
                                                    if(temp2==-5){
                                                        turno=(turno==1)?2:1;
                                                        for(int i=0;i<jugadoresTeam1.length;i++){
                                                            jugadoresTeam1[i].turnoRealizadoPersonaje=false;
                                                            jugadoresTeam1[i].resetMove();
                                                            boolean salir=false;
                                                            if(jugadoresTeam1[i].dead){
                                                                jugadoresTeam1[i].dead=false;
                                                                for(int q=0;q<matrizJuego.length;q++){
                                                                    for(int z=0;z<matrizJuego[q].length;z++){
                                                                        if(matrizJuego[z][q].torreDentro!=null){
                                                                            for(int u=0;u<torresTeam1.length;u++){
                                                                                if(matrizJuego[z][q].torreDentro.id==torresTeam1[u].id){
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        if(salir){
                                                                            break;
                                                                        }
                                                                    }
                                                                    if(salir){
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        home.eventosPartida.append("(Turn player) Es el turno del jugador 2.\n");
                                                        home.textoPorDefectoTurnos.setText("Turno de jugador 2#");
                                                        temp2 =establecerTurnoPersonaje(jugadoresTeam2);
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                        jugadoresTeam2[temp2].turnoRealizadoPersonaje=true;
                                                        guardadoSeleccionado=jugadoresTeam2[temp2];
                                                    }
                                                    else{
                                                        for(int i=0;i<jugadoresTeam1.length;i++){
                                                            if(guardadoSeleccionado.name.equals(jugadoresTeam1[i].name)){
                                                                jugadoresTeam1[i].turnoRealizadoPersonaje=true;
                                                                break;
                                                            }
                                                        }
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                        guardadoSeleccionado=jugadoresTeam1[temp2];
                                                    }

                                                }
                                            }
                                        }
                                    } //Si hay un jugador en la casilla atacada
                                    else if(arena.matrizJuego[x][y].torreDentro!=null && arena.matrizJuego[x][y].id==2){
                                        for(int r=0;r<torresTeam1.length;r++){
                                            if(Objects.equals(arena.matrizJuego[x][y].torreDentro.id ,torresTeam1[r].id)){
                                                //Revisamos si la torre atacada esta en la lista torresTeam1
                                                //Establecemos de nuevo las casillas a no bajoAtaque
                                                //Primero quitamos la etiqueta de bajo ataque a las casillas
                                                boolean ataqueAliado=false;
                                                for(int t=0;t<jugadoresTeam1.length;t++){
                                                    if(Objects.equals(jugadoresTeam1[t].name, guardadoSeleccionado.name)){
                                                        home.eventosPartida.append("(Error) No se puede atacar a la torre aliada. \n");
                                                        ataqueAliado=true;
                                                        break;
                                                    }
                                                }
                                                if(ataqueAliado){
                                                    for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                        for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                            if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                                arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                                //Aqui se calcula el daño tanto por ataque común como por habilidad
                                                if(arena.matrizJuego[x][y].bajoAtaque){
                                                    double totalDamage=guardadoSeleccionado.getDamage()+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                    arena.matrizJuego[x][y].torreDentro.receiveDamage(totalDamage);
                                                    torresTeam1[r].receiveDamage(totalDamage);
                                                    home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 1] ha recibido un total de "+totalDamage+" puntos de daño de parte del personaje "+guardadoSeleccionado.name+" [Jugador 2].\n");
                                                }
                                                else if (arena.matrizJuego[x][y].habilidad1BajoAtaque || matrizJuego[x][y].habilidad2BajoAtaque) {
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].manaCost){
                                                        double totalDamage=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].damage+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        for(int b=0;b<jugadoresTeam2.length;b++){
                                                            if(jugadoresTeam2[b].name==guardadoSeleccionado.name){
                                                                jugadoresTeam2[b].mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                            }
                                                        }
                                                        arena.matrizJuego[x][y].torreDentro.receiveDamage(totalDamage);
                                                        torresTeam1[r].receiveDamage(totalDamage);
                                                        home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 1] ha recibido un total de "+totalDamage+" puntos de daño de parte del personaje "+guardadoSeleccionado.name+" [Jugador 2].\n");
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 1] fue atacada con la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1]+" por "+guardadoSeleccionado.name+" [Jugador 2]. Sin embargo, debido a la falta de maná el ataque no se realizó.\n");
                                                    }
                                                }
                                                for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                    for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                        if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                            arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                    }
                                                }

                                                //Calculamos la vida restante de la torre
                                                if(torresTeam1[r].resistence<=0){
                                                    arena.matrizJuego[x][y].torreDentro=null;
                                                    torresTeam1[r].setDestroyed();
                                                    casilla.setIcon(null);
                                                    home.eventosPartida.append("(Tower destroyed) La torre ubicada en ["+x+", "+y+"] [Jugador 1] ha sido destruida por el personaje "+guardadoSeleccionado.name+" [Jugador 2].\n");
                                                    for(int y=0;y<jugadoresTeam2.length;y++){
                                                        if(Objects.equals(guardadoSeleccionado.name, jugadoresTeam2[y].name)){
                                                            jugadoresTeam2[y].levelUp();
                                                            break;
                                                        }
                                                    }
                                                    if(establecerTurno()){
                                                        System.out.println("Pasan cosas");
                                                    }
                                                }
                                                //Establecemos los turnos
                                                else{
                                                    int temp2 =establecerTurnoPersonaje(jugadoresTeam2);
                                                    if(temp2==-5){
                                                        turno=(turno==1)?2:1;
                                                        for(int i=0;i<jugadoresTeam2.length;i++){
                                                            jugadoresTeam2[i].turnoRealizadoPersonaje=false;
                                                            jugadoresTeam2[i].resetMove();
                                                            boolean salir=false;
                                                            if(jugadoresTeam2[i].dead){
                                                                jugadoresTeam2[i].dead=false;
                                                                for(int q=0;q<matrizJuego.length;q++){
                                                                    for(int z=0;z<matrizJuego[q].length;z++){
                                                                        if(matrizJuego[z][q].torreDentro!=null){
                                                                            for(int u=0;u<torresTeam2.length;u++){
                                                                                if(matrizJuego[z][q].torreDentro.id==torresTeam2[u].id){
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        if(salir){
                                                                            break;
                                                                        }
                                                                    }
                                                                    if(salir){
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        temp2 =establecerTurnoPersonaje(jugadoresTeam1);
                                                        home.eventosPartida.append("(Turn player) Es el turno del jugador uno.\n");
                                                        home.textoPorDefectoTurnos.setText("Turno de jugador 1#");
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                        jugadoresTeam1[temp2].turnoRealizadoPersonaje=true;
                                                        guardadoSeleccionado=jugadoresTeam1[temp2];

                                                    }
                                                    else{
                                                        for(int i=0;i<jugadoresTeam2.length;i++){
                                                            if(guardadoSeleccionado.name.equals(jugadoresTeam2[i].name)){
                                                                jugadoresTeam2[i].turnoRealizadoPersonaje=true;
                                                                break;
                                                            }
                                                        }
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                        guardadoSeleccionado=jugadoresTeam2[temp2];
                                                    }

                                                }
                                            }
                                            else if(Objects.equals(arena.matrizJuego[x][y].torreDentro.id ,torresTeam2[r].id)){
                                                //Establecemos de nuevo las casillas a no bajoAtaque
                                                //Primero quitamos la etiqueta de bajo ataque a las casillas
                                                boolean ataqueAliado=false;
                                                for(int t=0;t<jugadoresTeam2.length;t++){
                                                    if(Objects.equals(jugadoresTeam2[t].name, guardadoSeleccionado.name)){
                                                        home.eventosPartida.append("(Error) No se puede atacar a la torre aliada. \n");
                                                        ataqueAliado=true;
                                                        break;
                                                    }
                                                }
                                                if(ataqueAliado){
                                                    for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                        for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                            if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                                arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                            else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                                arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                                if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                                }
                                                                else{
                                                                    matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                                //Aqui se calcula el daño tanto por ataque común como por habilidad
                                                if(matrizJuego[x][y].bajoAtaque){
                                                    double totalDamage=guardadoSeleccionado.getDamage()+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                    matrizJuego[x][y].torreDentro.receiveDamage(totalDamage);
                                                    torresTeam2[r].receiveDamage(totalDamage);
                                                    home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 2] ha recibido un total de "+totalDamage+" puntos de daño de parte del personaje "+guardadoSeleccionado.name+" [Jugador 1].\n");
                                                }
                                                else if (matrizJuego[x][y].habilidad1BajoAtaque || matrizJuego[x][y].habilidad2BajoAtaque) {
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].manaCost){
                                                        double totalDamage=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1 ].damage+((Objects.equals(guardadoSeleccionado.getElement(), tipoArena)) ? guardadoSeleccionado.getDamage()*0.1 : 0);
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        for(int b=0;b<jugadoresTeam1.length;b++){
                                                            if(jugadoresTeam1[b].name==guardadoSeleccionado.name){
                                                                jugadoresTeam1[b].mana-=guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                            }
                                                        }
                                                        matrizJuego[x][y].torreDentro.receiveDamage(totalDamage);
                                                        torresTeam2[r].receiveDamage(totalDamage);
                                                        home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 2] ha recibido un total de "+totalDamage+" puntos de daño de parte del personaje "+guardadoSeleccionado.name+" [Jugador 1].\n");
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Tower attack) La torre ubicada en ["+x+", "+y+"] [Jugador 2] fue atacada con la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque) ? 0:1]+" por "+guardadoSeleccionado.name+" [Jugador 1]. Sin embargo, debido a la falta de maná el ataque no se realizó.\n");
                                                    }
                                                }
                                                for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                                    for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                        if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                            arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                        else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                            arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                            if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena){
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                            }
                                                            else{
                                                                matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                            }
                                                        }
                                                    }
                                                }

                                                //Aqui se revisa si la torre ha sido destruida
                                                if(torresTeam2[r].resistence<=0){
                                                    matrizJuego[x][y].torreDentro=null;
                                                    torresTeam2[r].setDestroyed();
                                                    casilla.setIcon(null);
                                                    home.eventosPartida.append("(Tower destroyed) La torre ubicada en ["+x+", "+y+"] [Jugador 2] ha sido destruida por el personaje "+guardadoSeleccionado.name+" [Jugador 1].\n");
                                                    for(int y=0;y<jugadoresTeam1.length;y++){
                                                        if(Objects.equals(guardadoSeleccionado.name, jugadoresTeam1[y].name)){
                                                            jugadoresTeam1[y].levelUp();
                                                            break;
                                                        }
                                                    }
                                                    if(establecerTurno()){
                                                        System.out.println("Pasan cosas");
                                                    }
                                                }
                                                //Y aqui se revisa los turnos
                                                else{
                                                    int temp2 =establecerTurnoPersonaje(jugadoresTeam1);
                                                    if(temp2==-5){
                                                        turno=(turno==1)?2:1;
                                                        for(int i=0;i<jugadoresTeam1.length;i++){
                                                            jugadoresTeam1[i].turnoRealizadoPersonaje=false;
                                                            jugadoresTeam2[i].resetMove();
                                                            boolean salir=false;
                                                            if(jugadoresTeam1[i].dead){
                                                                jugadoresTeam1[i].dead=false;
                                                                for(int q=0;q<matrizJuego.length;q++){
                                                                    for(int z=0;z<matrizJuego[q].length;z++){
                                                                        if(matrizJuego[z][q].torreDentro!=null){
                                                                            for(int u=0;u<torresTeam1.length;u++){
                                                                                if(matrizJuego[z][q].torreDentro.id==torresTeam1[u].id){
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    try {
                                                                                        if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                            arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    catch (Exception ae){
                                                                                        ae.printStackTrace();
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        if(salir){
                                                                            break;
                                                                        }
                                                                    }
                                                                    if(salir){
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        home.eventosPartida.append("(Turn player) Es el turno del jugador 2.\n");
                                                        home.textoPorDefectoTurnos.setText("Turno de jugador 2#");
                                                        temp2 =establecerTurnoPersonaje(jugadoresTeam1);
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                        jugadoresTeam1[temp2].turnoRealizadoPersonaje=true;
                                                        guardadoSeleccionado=jugadoresTeam1[temp2];
                                                    }
                                                    else{
                                                        for(int i=0;i<jugadoresTeam1.length;i++){
                                                            if(guardadoSeleccionado.name.equals(jugadoresTeam1[i].name)){
                                                                jugadoresTeam1[i].turnoRealizadoPersonaje=true;
                                                                break;
                                                            }
                                                        }
                                                        home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                        guardadoSeleccionado=jugadoresTeam1[temp2];
                                                    }

                                                }

                                            }
                                        }
                                    } //Si hay una torre en la casilla atacada
                                    else{
                                        //Establecemos de nuevo las casillas a no bajoAtaque
                                        //Primero quitamos la etiqueta de bajo ataque a las casillas
                                        for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                            for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                if(arena.matrizJuego[subX][subY].bajoAtaque){
                                                    arena.matrizJuego[subX][subY].bajoAtaque=false;
                                                    if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                    }
                                                    else{
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                    }
                                                }
                                                else if(arena.matrizJuego[subX][subY].habilidad1BajoAtaque){
                                                    arena.matrizJuego[subX][subY].habilidad1BajoAtaque=false;
                                                    if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                    }
                                                    else{
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                    }
                                                }
                                                else if(arena.matrizJuego[subX][subY].habilidad2BajoAtaque){
                                                    arena.matrizJuego[subX][subY].habilidad2BajoAtaque=false;
                                                    if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                    }
                                                    else{
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                    }
                                                }
                                            }
                                        }
                                        if(arena.matrizJuego[x][y].bajoAtaque) {
                                            home.eventosPartida.append("(Attack) El personaje "+guardadoSeleccionado.name+" "+((turno==1)?"[jugador 1]":"[jugador 2]")+ " ha atacado en la casilla ["+x+", "+y+"].\n");
                                        }
                                        else if(arena.matrizJuego[x][y].habilidad1BajoAtaque || arena.matrizJuego[x][y].habilidad2BajoAtaque) {
                                            for(int j=0;j<jugadoresTeam1.length;j++){
                                                if(Objects.equals(guardadoSeleccionado.name, jugadoresTeam1[j].name)){
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost){
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        jugadoresTeam1[j].mana-=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        home.eventosPartida.append("(Ability) El personaje "+guardadoSeleccionado.name+" "+((turno==1)?"[jugador 1]":"[jugador 2]")+" ha usado la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].nombre+" en la casilla ["+x+", "+y+"].\n");
                                                        break;
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Ability)El personaje "+guardadoSeleccionado.name+" "+((turno==1)?"[jugador 1]":"[jugador 2]")+" ha usado la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].nombre+" en la casilla ["+x+", "+y+"]. Sin embargo no se realizo el ataque por falta de maná. \n");
                                                    }
                                                }
                                                else if(Objects.equals(guardadoSeleccionado.name, jugadoresTeam2[j].name)){
                                                    if(guardadoSeleccionado.mana>=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost){
                                                        guardadoSeleccionado.mana-=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        jugadoresTeam2[j].mana-=guardadoSeleccionado.abilities[(arena.matrizJuego[x][y].habilidad1BajoAtaque)?0:1].manaCost;
                                                        home.eventosPartida.append("(Ability) El personaje "+guardadoSeleccionado.name+" "+((turno==1)?"[jugador 1]":"[jugador 2]")+" ha usado la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].nombre+" en la casilla ["+x+", "+y+"].\n");
                                                        break;
                                                    }
                                                    else{
                                                        home.eventosPartida.append("(Ability)El personaje "+guardadoSeleccionado.name+" "+((turno==1)?"[jugador 1]":"[jugador 2]")+" ha usado la habilidad "+guardadoSeleccionado.abilities[(matrizJuego[x][y].habilidad1BajoAtaque)?0:1].nombre+" en la casilla ["+x+", "+y+"]. Sin embargo no se realizo el ataque por falta de maná. \n");
                                                    }
                                                }
                                            }
                                        }

                                        //Establecemos los turnos
                                        int temp2 =establecerTurnoPersonaje((turno==1)?jugadoresTeam1:jugadoresTeam2);
                                        if(temp2==-5){
                                            if(turno==1){
                                                for(int i=0;i<jugadoresTeam1.length;i++){
                                                    jugadoresTeam1[i].turnoRealizadoPersonaje=false;
                                                    jugadoresTeam1[i].resetMove();
                                                    boolean salir=false;
                                                    if(jugadoresTeam1[i].dead){
                                                        jugadoresTeam1[i].dead=false;
                                                        for(int q=0;q<matrizJuego.length;q++){
                                                            for(int z=0;z<matrizJuego[q].length;z++){
                                                                if(matrizJuego[z][q].torreDentro!=null){
                                                                    for(int u=0;u<torresTeam1.length;u++){
                                                                        if(matrizJuego[z][q].torreDentro.id==torresTeam1[u].id){
                                                                            try {
                                                                                if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                if(salir){
                                                                    break;
                                                                }
                                                            }
                                                            if(salir){
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                home.eventosPartida.append("(turn player) Es el turno del jugador 2.\n");
                                                home.textoPorDefectoTurnos.setText("Turno de jugador 2#");
                                                temp2=establecerTurnoPersonaje(jugadoresTeam2);
                                                home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                jugadoresTeam2[temp2].turnoRealizadoPersonaje=true;
                                                guardadoSeleccionado=jugadoresTeam2[temp2];
                                                turno=2;
                                            }
                                            else{
                                                for(int i=0;i<jugadoresTeam2.length;i++){
                                                    jugadoresTeam2[i].turnoRealizadoPersonaje=false;
                                                    jugadoresTeam2[i].resetMove();
                                                    boolean salir=false;
                                                    if(jugadoresTeam2[i].dead){
                                                        jugadoresTeam2[i].dead=false;
                                                        for(int q=0;q<matrizJuego.length;q++){
                                                            for(int z=0;z<matrizJuego[q].length;z++){
                                                                if(matrizJuego[z][q].torreDentro!=null){
                                                                    for(int u=0;u<torresTeam2.length;u++){
                                                                        if(matrizJuego[z][q].torreDentro.id==torresTeam2[u].id){
                                                                            try {
                                                                                if(matrizJuego[z+1][q].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z+1][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z+1][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z+1][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z-1][q].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z-1][q].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z][q+1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z][q+1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            try {
                                                                                if(matrizJuego[z][q-1].personajeDentro==null){
                                                                                    ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+jugadoresTeam1[i].name+".png");
                                                                                    Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                                                                    arena.matrizJuegoBottons[z][q-1].setIcon(iconBotonDeVerdad);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            catch (Exception ae){
                                                                                ae.printStackTrace();
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                if(salir){
                                                                    break;
                                                                }
                                                            }
                                                            if(salir){
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                home.eventosPartida.append("(turn player) Es el turno del jugador 1.\n");
                                                home.textoPorDefectoTurnos.setText("Turno de jugador 1#");
                                                temp2=establecerTurnoPersonaje(jugadoresTeam1);
                                                home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                jugadoresTeam1[temp2].turnoRealizadoPersonaje=true;
                                                guardadoSeleccionado=jugadoresTeam1[temp2];
                                                turno=1;
                                            }
                                        }
                                        else{
                                            if(turno==1){
                                                for(int g=0;g<jugadoresTeam1.length;g++){
                                                    if(guardadoSeleccionado.name.equals(jugadoresTeam1[g].name)){
                                                        jugadoresTeam1[g].turnoRealizadoPersonaje=true;
                                                        break;
                                                    }
                                                }
                                                temp2=establecerTurnoPersonaje(jugadoresTeam1);
                                                home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam1[temp2].name+".\n");
                                                guardadoSeleccionado=jugadoresTeam1[temp2];
                                                jugadoresTeam1[temp2].turnoRealizadoPersonaje=true;
                                            }
                                            else{
                                                for(int g=0;g<jugadoresTeam2.length;g++){
                                                    if(guardadoSeleccionado.name.equals(jugadoresTeam2[g].name)){
                                                        jugadoresTeam2[g].turnoRealizadoPersonaje=true;
                                                        break;
                                                    }
                                                }
                                                temp2=establecerTurnoPersonaje(jugadoresTeam2);
                                                home.eventosPartida.append("(turn character) Es el turno del personaje "+jugadoresTeam2[temp2].name+".\n");
                                                guardadoSeleccionado=jugadoresTeam2[temp2];
                                                jugadoresTeam2[temp2].turnoRealizadoPersonaje=true;
                                            }
                                        }

                                    } //Si no hay nada en la casilla atacada
                                }
                                else if(arena.matrizJuego[x][y].EnMovimiento){
                                    guardadoSeleccionado=arena.matrizJuego[guardadoCords[0]][guardadoCords[1]].personajeDentro;
                                    if(guardadoSeleccionado.move==1){
                                        arena.matrizJuego[guardadoCords[0]][guardadoCords[1]].personajeDentro=null;
                                        arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setIcon(null);
                                        if(guardadoCords[0]<=mitadArena-1){
                                            arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setBackground(Color.red);
                                        }
                                        else{
                                            arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setBackground(Color.blue);
                                        }
                                        arena.matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
                                        ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\champion"+guardadoSeleccionado.name+".png");
                                        Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(widthHeight,widthHeight,Image.SCALE_AREA_AVERAGING));
                                        arena.matrizJuegoBottons[x][y].setIcon(iconBotonDeVerdad);
                                        casilla.setIcon(iconBotonDeVerdad);
                                        casilla.repaint();
                                        casilla.revalidate();
                                        for(int subY=0;subY<arena.matrizJuego.length;subY++){
                                            for(int subX=0;subX<arena.matrizJuego[y].length;subX++){
                                                if(arena.matrizJuego[subX][subY].EnMovimiento){
                                                    arena.matrizJuego[subX][subY].EnMovimiento=false;
                                                    if(arena.matrizJuego[subX][subY].cords[0]<=mitadArena-1){
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.red);
                                                    }
                                                    else{
                                                        matrizJuegoBottons[subX][subY].setBackground(Color.blue);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        home.eventosPartida.append("(not move) Sin puntos de movimiento restante.");
                                    }

                                    arena.matrizJuego[guardadoCords[0]][guardadoCords[1]].personajeDentro=null;
                                    arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setIcon(null);
                                    if(guardadoCords[0]<=mitadArena-1){
                                        arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setBackground(Color.red);
                                    }
                                    else{
                                        arena.matrizJuegoBottons[guardadoCords[0]][guardadoCords[1]].setBackground(Color.blue);
                                    }
                                    arena.matrizJuego[x][y].personajeDentro=guardadoSeleccionado;
                                    //arena.matrizJuegoBottons[x][y].setIcon(System.getProperty("user.dir")+"\\todo\\images\\"+);
                                }
                                menuPersonaje((turno == 1),x,y, cordsDibujo,juego);
                            }
                        }
                    }
                });
                matrizJuegoBottons[j-1][i-1]=casilla;
                juego.add(matrizJuegoBottons[j-1][i-1],Integer.valueOf(1));
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

    public void menuPersonaje(boolean quienJugador,int x,int y,int[] cords,JLayeredPane juego){
        System.out.println(x+" "+y);
        if(matrizJuego[x][y].personajeDentro!=null){ //Aqui se revisa si en el boton presionado hay un personaje
            for(int i=0;i<jugadoresTeam1.length;i++){
                if(matrizJuego[x][y].personajeDentro.name.equals(jugadoresTeam1[i].name)){ //Revisamos en ambas lista de jugadores si concuerda con el nombre
                    if(quienJugador){
                        //menuGeneral todo
                        JPanel menuGeneral = new JPanel();
                        JButton accionPersonaje =new JButton();
                        JButton estadoPersonaje =new JButton();
                        JButton salir =new JButton();
                        menuGeneral.setBounds(cords[0]-10,cords[1]-20,100,100);
                        accionPersonaje.setBounds(cords[0]-5,cords[1]-15,70,40);
                        estadoPersonaje.setBounds(cords[0]-5,cords[1]+10,70,40);
                        salir.setBounds(cords[0]-5,cords[1]+30,70,40);
                        Font tipoLetra=new Font("Arial",Font.BOLD,10);
                        accionPersonaje.setText("Acción");
                        accionPersonaje.setFont(tipoLetra);
                        estadoPersonaje.setText("Estado");
                        estadoPersonaje.setFont(tipoLetra);
                        salir.setText("Salir");
                        salir.setFont(tipoLetra);
                        menuGeneral.add(accionPersonaje);
                        menuGeneral.add(estadoPersonaje);
                        menuGeneral.add(salir);
                        menuGeneral.setBackground(Color.ORANGE);

                        //MenuAcciones
                        JPanel menuAcciones = new JPanel();
                        JButton movimiento = new JButton();
                        JButton atacar = new JButton();
                        JButton habilidad = new JButton();
                        JButton salir2 =new JButton();
                        menuAcciones.setBounds(cords[0]-10,cords[1]-20,110,110);
                        movimiento.setBounds(cords[0]-5,cords[1]-15,60,20);
                        atacar.setBounds(cords[0]-5,cords[1]+10,60,20);
                        habilidad.setBounds(cords[0]-5,cords[1]+30,60,20);
                        salir2.setBounds(cords[0]-5,cords[1]+50,60,20);
                        movimiento.setText("Movimiento");
                        movimiento.setFont(tipoLetra);
                        atacar.setText("Atacar");
                        atacar.setFont(tipoLetra);
                        habilidad.setText("Habilidades");
                        habilidad.setFont(tipoLetra);
                        salir2.setText("Volver");
                        salir2.setFont(tipoLetra);
                        menuAcciones.setBackground(Color.ORANGE);
                        menuAcciones.add(movimiento);
                        menuAcciones.add(atacar);
                        menuAcciones.add(habilidad);
                        menuAcciones.add(salir2);

                        //MenuHabilidades
                        JPanel menuHabilidades =new JPanel();
                        JButton habilidad1 =new JButton();
                        JButton habilidad2 =new JButton();
                        JButton salir4 =new JButton();
                        menuHabilidades.setBounds(cords[0]-10,cords[1]-20,110,110);
                        habilidad1.setBounds(cords[0]-5,cords[1]-15,60,20);
                        habilidad2.setBounds(cords[0]-5,cords[1]+10,60,20);
                        salir4.setBounds(cords[0]-5,cords[1]+30,60,20);
                        habilidad1.setText(matrizJuego[x][y].personajeDentro.abilities[0].nombre);
                        habilidad1.setFont(tipoLetra);
                        habilidad2.setText(matrizJuego[x][y].personajeDentro.abilities[1].nombre);
                        habilidad2.setFont(tipoLetra);
                        salir4.setText("Volver");
                        salir4.setFont(tipoLetra);
                        menuHabilidades.setBackground(Color.ORANGE);
                        menuHabilidades.add(habilidad1);
                        menuHabilidades.add(habilidad2);
                        menuHabilidades.add(salir4);

                        //MenuEstado
                        JPanel menuEstado= new JPanel();
                        JTextArea datosPersonaje =new JTextArea();
                        JButton salir3=new JButton();
                        menuEstado.setBounds(cords[0]-10,cords[1]-20,100,100);
                        datosPersonaje.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir3.setBounds(cords[0]-5,cords[1]+10,60,20);
                        datosPersonaje.setText("Nombre: "+matrizJuego[x][y].personajeDentro.name+"\n"+"Elemento: "+matrizJuego[x][y].personajeDentro.getElement()+"\n"+"Vida: "+matrizJuego[x][y].personajeDentro.getLife());
                        datosPersonaje.setForeground(Color.black);
                        datosPersonaje.setEditable(false);
                        if(matrizJuego[x][y].personajeDentro.name=="RanniTheWitch"){
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,8));
                        }
                        else{
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,10));
                        }
                        menuEstado.setBackground(Color.ORANGE);
                        menuEstado.add(datosPersonaje);
                        salir3.setText("Volver");
                        menuEstado.add(salir3);

                        //Para determinar si es el turno del personaje o no
                        if(Objects.equals(arena.matrizJuego[x][y].personajeDentro.name, guardadoSeleccionado.name)){
                            juego.add(menuGeneral,Integer.valueOf(2));
                        }
                        else{
                            juego.add(menuEstado,Integer.valueOf(2));
                        }

                        //panelAtaque
                        JPanel panelAtaque=new JPanel();
                        JTextArea denegadoAtaque =new JTextArea();
                        JButton salir5 =new JButton();
                        panelAtaque.setBounds(cords[0]-10,cords[1]-20,100,100);
                        denegadoAtaque.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir5.setBounds(cords[0]-5,cords[1]+10,60,20);
                        denegadoAtaque.setText("No hay objetivos en el área de ataque.");
                        denegadoAtaque.setFont(tipoLetra);
                        denegadoAtaque.setForeground(Color.black);
                        denegadoAtaque.setEditable(false);
                        panelAtaque.setBackground(Color.ORANGE);
                        panelAtaque.add(denegadoAtaque);


                        //Listener accionPersonaje
                        accionPersonaje.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                                juego.add(menuAcciones,Integer.valueOf(2));
                            }
                        });
                        habilidad.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                juego.add(menuHabilidades,Integer.valueOf(2));
                            }
                        });
                        estadoPersonaje.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                                juego.add(menuEstado,Integer.valueOf(2));
                            }
                        });
                        atacar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuAcciones.setVisible(false);
                                guardadoSeleccionado=arena.matrizJuego[x][y].personajeDentro;
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                            }
                        });
                        habilidad1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuHabilidades.setVisible(false);
                                guardadoSeleccionado=arena.matrizJuego[x][y].personajeDentro;
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].habilidad1BajoAtaque=true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }

                            }
                        });
                        habilidad2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuHabilidades.setVisible(false);
                                guardadoSeleccionado=matrizJuego[x][y].personajeDentro;
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].habilidad2BajoAtaque=true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                            }
                        });
                        movimiento.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                int contador=0;
                                try{
                                    if(arena.matrizJuego[x+1][y].personajeDentro==null && arena.matrizJuego[x+1][y].torreDentro==null){
                                        arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x+1][y].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x-1][y].personajeDentro==null && arena.matrizJuego[x-1][y].torreDentro==null){
                                        arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x-1][y].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }

                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x][y+1].personajeDentro==null && arena.matrizJuego[x][y+1].torreDentro==null){
                                        arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x][y+1].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x][y-1].personajeDentro==null && arena.matrizJuego[x][y-1].torreDentro==null){
                                        arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x][y-1].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                if(contador==4){
                                    home.eventosPartida.append("(No move) Sin movimientos posibles.");
                                }
                                else{
                                    arena.guardadoCords=new int[]{x,y};
                                }
                            }
                        });
                        salir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                            }
                        });
                        salir2.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir3.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuEstado.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir4.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuHabilidades.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir5.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panelAtaque.setVisible(false);
                                menuAcciones.setVisible(true);

                            }
                        });
                    }
                    else{
                        //MenuEstado
                        JPanel menuEstado= new JPanel();
                        JTextArea datosPersonaje =new JTextArea();
                        JButton salir=new JButton();
                        menuEstado.setBounds(cords[0]-10,cords[1]-20,100,100);
                        datosPersonaje.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir.setBounds(cords[0]-5,cords[1]+10,60,20);
                        datosPersonaje.setText("Nombre: "+matrizJuego[x][y].personajeDentro.name+"\n"+"Elemento: "+matrizJuego[x][y].personajeDentro.getElement()+"\n"+"Vida: "+matrizJuego[x][y].personajeDentro.getLife());
                        datosPersonaje.setForeground(Color.black);
                        datosPersonaje.setEditable(false);
                        if(matrizJuego[x][y].personajeDentro.name=="RanniTheWitch"){
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,8));
                        }
                        else{
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,10));
                        }
                        menuEstado.setBackground(Color.ORANGE);
                        menuEstado.add(datosPersonaje);
                        salir.setText("Salir");
                        salir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuEstado.setVisible(false);
                            }
                        });
                        menuEstado.add(salir);
                        juego.add(menuEstado,Integer.valueOf(2));
                    }
                }
                else if(matrizJuego[x][y].personajeDentro.name.equals(jugadoresTeam2[i].name)){
                    if(!quienJugador){
                        //menuGeneral todo
                        JPanel menuGeneral = new JPanel();
                        JButton accionPersonaje =new JButton();
                        JButton estadoPersonaje =new JButton();
                        JButton salir =new JButton();
                        menuGeneral.setBounds(cords[0]-10,cords[1]-20,100,100);
                        accionPersonaje.setBounds(cords[0]-5,cords[1]-15,70,40);
                        estadoPersonaje.setBounds(cords[0]-5,cords[1]+10,70,40);
                        salir.setBounds(cords[0]-5,cords[1]+30,70,40);
                        Font tipoLetra=new Font("Arial",Font.BOLD,10);
                        accionPersonaje.setText("Acción");
                        accionPersonaje.setFont(tipoLetra);
                        estadoPersonaje.setText("Estado");
                        estadoPersonaje.setFont(tipoLetra);
                        salir.setText("Salir");
                        salir.setFont(tipoLetra);
                        menuGeneral.add(accionPersonaje);
                        menuGeneral.add(estadoPersonaje);
                        menuGeneral.add(salir);
                        menuGeneral.setBackground(Color.ORANGE);


                        //MenuAcciones
                        JPanel menuAcciones = new JPanel();
                        JButton movimiento = new JButton();
                        JButton atacar = new JButton();
                        JButton habilidad = new JButton();
                        JButton salir2 =new JButton();
                        menuAcciones.setBounds(cords[0]-10,cords[1]-20,110,110);
                        movimiento.setBounds(cords[0]-5,cords[1]-15,60,20);
                        atacar.setBounds(cords[0]-5,cords[1]+10,60,20);
                        habilidad.setBounds(cords[0]-5,cords[1]+30,60,20);
                        salir2.setBounds(cords[0]-5,cords[1]+50,60,20);
                        movimiento.setText("Movimiento");
                        movimiento.setFont(tipoLetra);
                        atacar.setText("Atacar");
                        atacar.setFont(tipoLetra);
                        habilidad.setText("Habilidades");
                        habilidad.setFont(tipoLetra);
                        salir2.setText("Volver");
                        salir2.setFont(tipoLetra);
                        menuAcciones.setBackground(Color.ORANGE);
                        menuAcciones.add(movimiento);
                        menuAcciones.add(atacar);
                        menuAcciones.add(habilidad);
                        menuAcciones.add(salir2);

                        //MenuHabilidades
                        JPanel menuHabilidades =new JPanel();
                        JButton habilidad1 =new JButton();
                        JButton habilidad2 =new JButton();
                        JButton salir4 =new JButton();
                        menuHabilidades.setBounds(cords[0]-10,cords[1]-20,110,110);
                        habilidad1.setBounds(cords[0]-5,cords[1]-15,60,20);
                        habilidad2.setBounds(cords[0]-5,cords[1]+10,60,20);
                        salir4.setBounds(cords[0]-5,cords[1]+30,60,20);
                        habilidad1.setText(matrizJuego[x][y].personajeDentro.abilities[0].nombre);
                        habilidad1.setFont(tipoLetra);
                        habilidad2.setText(matrizJuego[x][y].personajeDentro.abilities[1].nombre);
                        habilidad2.setFont(tipoLetra);
                        salir4.setText("Volver");
                        salir4.setFont(tipoLetra);
                        menuHabilidades.setBackground(Color.ORANGE);
                        menuHabilidades.add(habilidad1);
                        menuHabilidades.add(habilidad2);
                        menuHabilidades.add(salir4);

                        //MenuEstado
                        JPanel menuEstado= new JPanel();
                        JTextArea datosPersonaje =new JTextArea();
                        JButton salir3=new JButton();
                        menuEstado.setBounds(cords[0]-10,cords[1]-20,100,100);
                        datosPersonaje.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir3.setBounds(cords[0]-5,cords[1]+10,60,20);
                        datosPersonaje.setText("Nombre: "+matrizJuego[x][y].personajeDentro.name+"\n"+"Elemento: "+matrizJuego[x][y].personajeDentro.getElement()+"\n"+"Vida: "+matrizJuego[x][y].personajeDentro.getLife());
                        datosPersonaje.setForeground(Color.black);
                        datosPersonaje.setEditable(false);
                        if(matrizJuego[x][y].personajeDentro.name=="RanniTheWitch"){
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,8));
                        }
                        else{
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,10));
                        }
                        menuEstado.setBackground(Color.ORANGE);
                        menuEstado.add(datosPersonaje);
                        salir3.setText("Volver");
                        menuEstado.add(salir3);

                        //Para determinar si es el turno del personaje o no
                        if(Objects.equals(matrizJuego[x][y].personajeDentro.name, guardadoSeleccionado.name)){
                            juego.add(menuGeneral,Integer.valueOf(2));
                        }
                        else{
                            juego.add(menuEstado,Integer.valueOf(2));
                        }

                        //panelAtaque
                        JPanel panelAtaque=new JPanel();
                        JTextArea denegadoAtaque =new JTextArea();
                        JButton salir5 =new JButton();
                        panelAtaque.setBounds(cords[0]-10,cords[1]-20,100,100);
                        denegadoAtaque.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir5.setBounds(cords[0]-5,cords[1]+10,60,20);
                        denegadoAtaque.setText("No hay objetivos en el área de ataque.");
                        denegadoAtaque.setFont(tipoLetra);
                        denegadoAtaque.setForeground(Color.black);
                        denegadoAtaque.setEditable(false);
                        panelAtaque.setBackground(Color.ORANGE);
                        panelAtaque.add(denegadoAtaque);


                        //Listener accionPersonaje
                        accionPersonaje.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                                juego.add(menuAcciones,Integer.valueOf(2));
                            }
                        });
                        habilidad.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                juego.add(menuHabilidades,Integer.valueOf(2));
                            }
                        });
                        estadoPersonaje.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                                juego.add(menuEstado,Integer.valueOf(2));
                            }
                        });
                        atacar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuAcciones.setVisible(false);
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].bajoAtaque =true;
                                    guardadoSeleccionado=arena.matrizJuego[x][y].personajeDentro;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].bajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                            }
                        });
                        habilidad1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuHabilidades.setVisible(false);
                                guardadoSeleccionado=arena.matrizJuego[x][y].personajeDentro;
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].habilidad1BajoAtaque=true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].habilidad1BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }

                            }
                        });
                        habilidad2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(x+" "+y);
                                menuHabilidades.setVisible(false);
                                guardadoSeleccionado=arena.matrizJuego[x][y].personajeDentro;
                                try {
                                    arena.matrizJuegoBottons[x+1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y+1].habilidad2BajoAtaque=true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y+1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y+1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y+1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                arena.matrizJuegoBottons[x][y].setBackground(Color.ORANGE);
                                try{
                                    arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try{
                                    arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x-1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x-1][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                                try {
                                    arena.matrizJuegoBottons[x+1][y-1].setBackground(Color.ORANGE);
                                    arena.matrizJuego[x+1][y-1].habilidad2BajoAtaque =true;
                                }
                                catch (Exception ex){
                                    System.out.println("Nada xdxd");
                                }
                            }
                        });
                        movimiento.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                int contador=0;
                                try{
                                    if(arena.matrizJuego[x+1][y].personajeDentro==null && arena.matrizJuego[x+1][y].torreDentro==null){
                                        arena.matrizJuegoBottons[x+1][y].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x+1][y].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x-1][y].personajeDentro==null && arena.matrizJuego[x-1][y].torreDentro==null){
                                        arena.matrizJuegoBottons[x-1][y].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x-1][y].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }

                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x][y+1].personajeDentro==null && arena.matrizJuego[x][y+1].torreDentro==null){
                                        arena.matrizJuegoBottons[x][y+1].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x][y+1].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                try{
                                    if(arena.matrizJuego[x][y-1].personajeDentro==null && arena.matrizJuego[x][y-1].torreDentro==null){
                                        arena.matrizJuegoBottons[x][y-1].setBackground(Color.ORANGE);
                                        arena.matrizJuego[x][y-1].EnMovimiento=true;
                                    }
                                    else{
                                        contador++;
                                    }
                                }
                                catch (Exception ex){
                                    contador++;
                                }
                                if(contador==4){
                                    home.eventosPartida.append("(No move) Sin movimientos posibles.");
                                }
                                else{
                                    arena.guardadoCords=new int[]{x,y};
                                }
                            }
                        });
                        salir.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuGeneral.setVisible(false);
                            }
                        });
                        salir2.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuAcciones.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir3.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuEstado.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir4.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuHabilidades.setVisible(false);
                                menuGeneral.setVisible(true);
                            }
                        });
                        salir5.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panelAtaque.setVisible(false);
                                menuAcciones.setVisible(true);

                            }
                        });
                    }
                    else{
                        //MenuEstado
                        //MenuEstado
                        JPanel menuEstado= new JPanel();
                        JTextArea datosPersonaje =new JTextArea();
                        JButton salir=new JButton();
                        menuEstado.setBounds(cords[0]-10,cords[1]-20,100,100);
                        datosPersonaje.setBounds(cords[0]-5,cords[1]-15,60,60);
                        salir.setBounds(cords[0]-5,cords[1]+10,60,20);
                        datosPersonaje.setText("Nombre: "+matrizJuego[x][y].personajeDentro.name+"\n"+"Elemento: "+matrizJuego[x][y].personajeDentro.getElement()+"\n"+"Vida: "+matrizJuego[x][y].personajeDentro.getLife());
                        datosPersonaje.setForeground(Color.black);
                        datosPersonaje.setEditable(false);
                        if(matrizJuego[x][y].personajeDentro.name=="RanniTheWitch"){
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,8));
                        }
                        else{
                            datosPersonaje.setFont(new Font("Arial",Font.BOLD,10));
                        }
                        menuEstado.setBackground(Color.ORANGE);
                        salir.setText("Salir");
                        menuEstado.add(datosPersonaje);
                        salir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuEstado.setVisible(false);
                            }
                        });
                        menuEstado.add(salir);
                        juego.add(menuEstado,Integer.valueOf(2));
                    }
                }
            }
        }
        else if(matrizJuego[x][y].id==2){
            for(int i=0;i<torresTeam1.length;i++){
                if(matrizJuego[x][y].torreDentro.id==torresTeam1[i].id){
                    //menuTorre
                    JPanel menuTorre = new JPanel();
                    JTextArea textoTorre = new JTextArea();
                    JButton salir = new JButton();
                    menuTorre.setBounds(cords[0]-5,cords[1]-15,90,90);
                    textoTorre.setBounds(cords[0]-5,cords[1]+10,60,20);
                    salir.setBounds(cords[0]-5,cords[1]+10,60,20);
                    Font tipoLetra=new Font("Arial",Font.BOLD,10);
                    textoTorre.setForeground(Color.black);
                    textoTorre.setEditable(false);
                    textoTorre.setFont(tipoLetra);
                    textoTorre.setText("Vida torre: "+String.valueOf((matrizJuego[x][y].torreDentro.resistence)));
                    menuTorre.setBackground(Color.ORANGE);
                    salir.setText("Salir");
                    menuTorre.add(textoTorre);
                    menuTorre.add(salir);
                    juego.add(menuTorre,Integer.valueOf(2));

                    salir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuTorre.setVisible(false);
                        }
                    });
                }
                else if(matrizJuego[x][y].torreDentro.id==torresTeam2[i].id){
                    //menuTorre
                    JPanel menuTorre = new JPanel();
                    JTextArea textoTorre = new JTextArea();
                    JButton salir = new JButton();
                    menuTorre.setBounds(cords[0]-5,cords[1]-15,90,90);
                    textoTorre.setBounds(cords[0]-5,cords[1]+10,60,20);
                    salir.setBounds(cords[0]-5,cords[1]+10,60,20);
                    Font tipoLetra=new Font("Arial",Font.BOLD,10);
                    textoTorre.setForeground(Color.black);
                    textoTorre.setEditable(false);
                    textoTorre.setFont(tipoLetra);
                    textoTorre.setText("Vida torre: "+String.valueOf((matrizJuego[x][y].torreDentro.resistence)));
                    menuTorre.setBackground(Color.ORANGE);
                    salir.setText("Salir");
                    menuTorre.add(textoTorre);
                    menuTorre.add(salir);
                    juego.add(menuTorre,Integer.valueOf(2));

                    salir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuTorre.setVisible(false);
                        }
                    });
                }
            }
        }
    }

}


