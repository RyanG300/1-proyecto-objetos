package ui;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import casillaObjetos.Character;
import casillaObjetos.Ability;
import casillaObjetos.Tower;
import game.*;

public class home extends JFrame{
    private JPanel Todo;
    private JPanel JPanelEditor;
    private JPanel JPanelChampions;
    private JPanel JPanelAbajoXD;
    private JPanel JPanelTituloEditor;
    private JPanel JPanelTamaño;
    private JPanel JPanelTipo;
    private JPanel JPanelTorres;
    private JLabel JLabelTitulosEditos;
    private JLabel JLabelTamaño;
    private JTextField textFieldX;
    private JLabel LabelX;
    private JLabel LabelY;
    private JTextField textFieldY;
    private JLabel LabelTipo;
    private JCheckBox fuegoCheckBox;
    private JCheckBox aguaCheckBox;
    private JCheckBox tierraCheckBox;
    private JCheckBox aireCheckBox;
    private JLabel LabelTorres;
    private JPanel JPanelTal;
    private JLabel Shit;
    private JLabel tal;
    private JComboBox comboBoxTorres;
    private JLabel imageFuego;
    private JLabel imageAgua;
    private JLabel imageTierra;
    private JLabel imageAire;
    private JPanel Champions;
    private JPanel JPanelEmpezar;
    private JButton ButtonEmpezar;
    private JPanel JPanelCantidadPersonajes;
    private JLabel LabelCantidadP;
    private JPanel Champion1;
    private JPanel Champion2;
    private JPanel Champion3;
    private JPanel Champion4;
    private JPanel Champion5;
    private JButton buttonChampion1;
    private JButton buttonChampion2;
    private JButton buttonChampion3;
    private JButton buttonChampion4;
    private JButton buttonChampion5;
    private JButton buttonChampion6;
    private JButton buttonChampion7;
    private JButton buttonChampion8;
    private JButton buttonChampion9;
    private JButton buttonChampion10;
    private JPanel JPanelQuienToca;
    private JPanel JPanelTitulos;
    private JLabel TitulosText;
    private JLabel TurnoJugadorText;
    private JComboBox comboBoxCantidadP;
    private JButton ConfirmarButton;
    private JButton PlayButtonMenu;
    private JButton SalirButtonMenu;

    //Datos importantes para empezar la partida
    private int cantidadPersonajes;
    private String tipoArena;
    private Character[] listaJugadoresTeam1;
    private Character[] listaJugadoresTeam2;
    public static arena Arena;

    //UI para la parte del juego//UI para la parte del juego//UI para la parte del juego
    //UI para la parte del juego//UI para la parte del juego//UI para la parte del juego
    //UI para la parte del juego//UI para la parte del juego//UI para la parte del juego

    //Paneles
    private static JLayeredPane juegoMain;
    private JPanel interfazJuego;

    //JLabel
    private JLabel imagenJuegoMain;
    public static JLabel textoPorDefectoTurnos=new JLabel();

    //JtextArea
    public static JTextArea eventosPartida=new JTextArea();

    //Variables auxiliares
    public static boolean presionado=false; //Variable para saber si un boton de colocacion de personaje ha sido presionado
    public static int cantidadPersonajesRestantes; //Variable para saber el numero restante de personajes que faltan de colocar en la arena (Para ambos jugadores)
    //Jbutton
    //public static JButton botonPersonaje =new JButton();
    public static JButton pasarTurno=new JButton();

    public home() {
        setContentPane(Todo);
        setTitle("LeagueTEC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu juego = new JMenu("Juego");
        JMenu ayuda = new JMenu("Ayuda");

        JMenuItem NuevoJuegoItem = new JMenuItem("Nuevo Juego");
        JMenuItem RendirseItem = new JMenuItem("Rendirse");
        createUIComponents();

        juego.add(NuevoJuegoItem);
        juego.add(RendirseItem);
        menuBar.add(juego);
        menuBar.add(ayuda);
        this.setJMenuBar(menuBar);

        setVisible(true);
        setResizable(false);
        //setLayout(null);
        setSize(1300, 600);


        //Estos son los checkBox que determinan el tipo de la arena de juego.
        fuegoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fuegoCheckBox.isSelected()) {
                    aguaCheckBox.setSelected(false);
                    aguaCheckBox.setEnabled(false);
                    tierraCheckBox.setSelected(false);
                    tierraCheckBox.setEnabled(false);
                    aireCheckBox.setSelected(false);
                    aireCheckBox.setEnabled(false);
                    tipoArena="Fuego";
                }
                else{
                    aguaCheckBox.setEnabled(true);
                    tierraCheckBox.setEnabled(true);
                    aireCheckBox.setEnabled(true);
                }
            }
        });
        tierraCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tierraCheckBox.isSelected()) {
                    aguaCheckBox.setSelected(false);
                    aguaCheckBox.setEnabled(false);
                    fuegoCheckBox.setSelected(false);
                    fuegoCheckBox.setEnabled(false);
                    aireCheckBox.setSelected(false);
                    aireCheckBox.setEnabled(false);
                    tipoArena="Tierra";
                }
                else{
                    aguaCheckBox.setEnabled(true);
                    fuegoCheckBox.setEnabled(true);
                    aireCheckBox.setEnabled(true);
                }

            }
        });
        aguaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aguaCheckBox.isSelected()) {
                    fuegoCheckBox.setSelected(false);
                    fuegoCheckBox.setEnabled(false);
                    tierraCheckBox.setSelected(false);
                    tierraCheckBox.setEnabled(false);
                    aireCheckBox.setSelected(false);
                    aireCheckBox.setEnabled(false);
                    tipoArena="Agua";
                }
                else{
                    fuegoCheckBox.setEnabled(true);
                    tierraCheckBox.setEnabled(true);
                    aireCheckBox.setEnabled(true);
                }
            }
        });
        aireCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aireCheckBox.isSelected()) {
                    fuegoCheckBox.setSelected(false);
                    fuegoCheckBox.setEnabled(false);
                    tierraCheckBox.setSelected(false);
                    tierraCheckBox.setEnabled(false);
                    aguaCheckBox.setSelected(false);
                    aguaCheckBox.setEnabled(false);
                    tipoArena="Aire";
                }
                else{
                    fuegoCheckBox.setEnabled(true);
                    tierraCheckBox.setEnabled(true);
                    aguaCheckBox.setEnabled(true);
                }
            }
        });

        //Botón empezar partida y confirmar cantidad de campeones
        ButtonEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldX.getText().equals("")) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se digitó el tamaño de la arena.");
                    return;
                }
                else if (textFieldY.getText().equals("")) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se digitó el tamaño de la arena.");
                    return;
                }

                if(!aguaCheckBox.isSelected()
                        && !fuegoCheckBox.isSelected()
                        && !aireCheckBox.isSelected()
                        && !tierraCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se selecionó el tipo de arena.");
                    return;
                }
                if(Integer.parseInt(textFieldX.getText())<10 || Integer.parseInt(textFieldY.getText())<10){
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: Tamaño de la arena no valida (x mín: 10,y mín: 10).");
                    return;
                }
                //Inicialización clase arena
                ButtonEmpezar.setEnabled(false);
                System.out.println(tipoArena+" "+Integer.parseInt(textFieldX.getText())+" "+Integer.parseInt(textFieldY.getText())+" "+Integer.parseInt(comboBoxTorres.getSelectedItem().toString()));
                Tower[] listaTorresTeam1=new Tower[Integer.parseInt(comboBoxTorres.getSelectedItem().toString())];
                int contador=0;
                for(int X=0;X<listaTorresTeam1.length;X++){
                    listaTorresTeam1[X]=new Tower(10000,contador);
                    contador++;
                }
                Tower[]listaTorresTeam2=new Tower[Integer.parseInt(comboBoxTorres.getSelectedItem().toString())];
                for(int X=0;X<listaTorresTeam2.length;X++){
                    listaTorresTeam2[X]=new Tower(10000,contador);
                    contador++;
                }

                Arena=new arena(Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()),tipoArena,listaJugadoresTeam1,listaJugadoresTeam2,listaTorresTeam1,listaTorresTeam2,Integer.parseInt(comboBoxTorres.getSelectedItem().toString()));
                //Todo.setVisible(false);
                Todo.removeAll();
                Todo.validate();
                Todo.repaint();
                //JPanelChampions.setVisible(false);
                //JPanelAbajoXD.setVisible(false);
                juegoMain=new JLayeredPane();
                //interfazJuego=new JLayeredPane();
                juegoMain.setLayout(null);
                juegoMain.setOpaque(true);
                //interfazJuego.setLayout(null);
                juegoMain.setBounds(0,0,1300,600);
                //interfazJuego.setBounds(900,0,400,600);
                if(tipoArena=="Fuego"){
                    juegoMain.setBackground(Color.WHITE);
                    String tipoImagenCasilla=System.getProperty("user.dir")+"\\todo\\images\\texturaLavaTipoArena.png";
                    /*imagenJuegoMain=new JLabel();
                    imagenJuegoMain.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\texturaLavaTipoArena.png"));
                    imagenJuegoMain.setBounds(0,0,1300,400);
                    juegoMain.add(imagenJuegoMain,Integer.valueOf(0)); //JLayeredPane.DEFAULT_LAYER*/
                    //JButton prueba=new JButton();
                    //prueba.setBounds(10,10,15,15);
                    //prueba.setText("Prueba");
                    //juegoMain.add(prueba);

                }
                else if(tipoArena=="Aire"){
                    juegoMain.setBackground(Color.WHITE);
                    //Falta poner imagen
                    String tipoImagenCasilla=System.getProperty("user.dir")+"\\todo\\images\\texturaLavaTipoArena.png";
                }
                else if(tipoArena=="Agua"){
                    juegoMain.setBackground(Color.WHITE);
                    String tipoImagenCasilla=System.getProperty("user.dir")+"\\todo\\images\\texturaAguaTipoArena.png";

                }
                else if(tipoArena=="Tierra"){
                    juegoMain.setBackground(Color.WHITE);
                    //Falta poner imagen y color
                    String tipoImagenCasilla=System.getProperty("user.dir")+"\\todo\\images\\texturaLavaTipoArena.png";

                }
                //interfazJuego.setBackground(Color.GREEN);
                //JLabel textoPorDefectoTurnos=new JLabel();
                textoPorDefectoTurnos.setText("Jugador #1, por favor eliga la ubicación de su torre (Quedan "+listaTorresTeam1.length+")");
                textoPorDefectoTurnos.setLayout(null);
                textoPorDefectoTurnos.setBounds(810,50,500,50);
                textoPorDefectoTurnos.setForeground(Color.BLACK);
                //textoPorDefectoTurnos.setBackground(Color.decode("#d8e390"));
                textoPorDefectoTurnos.setFont(new Font("Arial",Font.BOLD,14));

                interfazJuego=new JPanel();
                interfazJuego.setLayout(null);
                interfazJuego.setBounds(800,0,500,600);
                interfazJuego.setBackground(Color.decode("#c18559"));
                eventosPartida.setFont(new Font("Arial",Font.BOLD,14));
                eventosPartida.setBounds(20,200,430,430);
                eventosPartida.setBackground(Color.decode("#E0E0E0"));
                eventosPartida.setForeground(Color.BLACK);
                eventosPartida.append("La partida aún no ha empezado.\n");
                eventosPartida.setEditable(false);
                eventosPartida.setLineWrap(true);
                JScrollPane scroll=new JScrollPane(eventosPartida);
                //scroll.setBounds(410,200,20,430);
                //scroll.createVerticalScrollBar();
                //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                pasarTurno.setText("Pasar turno");
                pasarTurno.setBounds(20,130,150,30);
                pasarTurno.setForeground(Color.BLACK);
                pasarTurno.setFont(new Font("Arial",Font.BOLD,14));
                pasarTurno.setEnabled(false);
                pasarTurno.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Arena.turno=(Arena.establecerTurno()) ? 1:2;
                        pasarTurno.setEnabled(false);
                    }
                });
                //interfazJuego.add(scroll);
                interfazJuego.add(pasarTurno);
                interfazJuego.add(eventosPartida);
                //interfazJuego.add(textoPorDefectoTurnos);
                juegoMain.add(interfazJuego);
                juegoMain.add(textoPorDefectoTurnos,Integer.valueOf(1));
                juegoMain=Arena.dibujarArena(juegoMain);

                add(juegoMain);

                /*while(true){
                    if(Arena.textoTurnos==1){
                        textoPorDefectoTurnos.setText("Jugador 1#, por favor eliga la ubicación de su torre (Quedan "+Arena.cantidadTorresColocacion+")");
                    }
                    else if(Arena.textoTurnos==2){
                        textoPorDefectoTurnos.setText("Jugador 2#, por favor eliga la ubicación de su torre (Quedan "+Arena.cantidadTorresColocacion+")");
                    }
                    else if(Arena.textoTurnos==3){
                        textoPorDefectoTurnos.setText("Error: No se puede colocar una torre en el lado contrario de la arena");
                    }
                }
               */
            }
        });
        ConfirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(ConfirmarButton./*isSelected()*/) {
                ConfirmarButton.setEnabled(false);
                comboBoxCantidadP.setEnabled(false);
                buttonChampion1.setEnabled(true);
                buttonChampion2.setEnabled(true);
                buttonChampion3.setEnabled(true);
                buttonChampion4.setEnabled(true);
                buttonChampion5.setEnabled(true);
                buttonChampion6.setEnabled(true);
                buttonChampion7.setEnabled(true);
                buttonChampion8.setEnabled(true);
                buttonChampion9.setEnabled(true);
                buttonChampion10.setEnabled(true);
                cantidadPersonajes=Integer.parseInt(comboBoxCantidadP.getSelectedItem().toString());
                System.out.println(cantidadPersonajes);
                TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")" );
                listaJugadoresTeam1=new Character[cantidadPersonajes];
                listaJugadoresTeam2=new Character[cantidadPersonajes];
                //}
                /*else{
                    comboBoxCantidadP.setEnabled(true);
                }*/
            }
        });

        //Botones para seleccionar a los campeones.
        buttonChampion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion1.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón T34
                    Ability habilidad1=new Ability("Disparo de precisión",80,95);
                    Ability habilidad2=new Ability("Disparo a quemarropa",160,180);
                    Ability[] habilidadesT34= new Ability[2];
                    habilidadesT34[0]=habilidad1;
                    habilidadesT34[1]=habilidad2;
                    Character t34=new Character("T-34",0,600,58,"Tierra",habilidadesT34,250);
                    //Colocarlo en la lista del team1
                    if(listaJugadoresTeam1[0]==null){
                        listaJugadoresTeam1[0]=t34;
                    }
                    else if(listaJugadoresTeam1[1]==null){
                        listaJugadoresTeam1[1]=t34;
                    }
                    else if(listaJugadoresTeam1[2]==null){
                        listaJugadoresTeam1[2]=t34;
                    }
                    else if(listaJugadoresTeam1[3]==null){
                        listaJugadoresTeam1[3]=t34;
                    }
                    else if(listaJugadoresTeam1[4]==null){
                        listaJugadoresTeam1[4]=t34;
                    }
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    Ability habilidad1=new Ability("Disparo de precisión",80,95);
                    Ability habilidad2=new Ability("Disparo a quemarropa",160,180);
                    Ability[] habilidadesT34= new Ability[2];
                    habilidadesT34[0]=habilidad1;
                    habilidadesT34[1]=habilidad2;
                    Character t34=new Character("T-34",0,600,58,"Tierra",habilidadesT34,250);
                    //Colocarlo en la lista del team1
                    if(listaJugadoresTeam2[0]==null){
                        listaJugadoresTeam2[0]=t34;
                    }
                    else if(listaJugadoresTeam2[1]==null){
                        listaJugadoresTeam2[1]=t34;
                    }
                    else if(listaJugadoresTeam2[2]==null){
                        listaJugadoresTeam2[2]=t34;
                    }
                    else if(listaJugadoresTeam2[3]==null){
                        listaJugadoresTeam2[3]=t34;
                    }
                    else if(listaJugadoresTeam2[4]==null){
                        listaJugadoresTeam2[4]=t34;
                    }
                    if(cantidadPersonajes==0){
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion2.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if (TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: " + (cantidadPersonajes) +")")) {
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: " + cantidadPersonajes + ")");
                    //Inicialización del campeón bananirou
                    Ability habilidad1 = new Ability("La pechea", 35, 85);
                    Ability habilidad2 = new Ability("El salto del papu", 120, 120);
                    Ability[] habilidadesBananinou = new Ability[2];
                    habilidadesBananinou[0] = habilidad1;
                    habilidadesBananinou[1] = habilidad2;
                    Character bananinou = new Character("Bana", 0, 530, 62, "Agua", habilidadesBananinou, 172);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam1[0] == null) {
                        listaJugadoresTeam1[0] = bananinou;
                    } else if (listaJugadoresTeam1[1] == null) {
                        listaJugadoresTeam1[1] = bananinou;
                    } else if (listaJugadoresTeam1[2] == null) {
                        listaJugadoresTeam1[2] = bananinou;
                    } else if (listaJugadoresTeam1[3] == null) {
                        listaJugadoresTeam1[3] = bananinou;
                    } else if (listaJugadoresTeam1[4] == null) {
                        listaJugadoresTeam1[4] = bananinou;
                    }
                }
                else {
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: " + cantidadPersonajes + ")");
                    Ability habilidad1 = new Ability("La pechea", 35, 85);
                    Ability habilidad2 = new Ability("El salto del papu", 120, 120);
                    Ability[] habilidadesBananinou = new Ability[2];
                    habilidadesBananinou[0] = habilidad1;
                    habilidadesBananinou[1] = habilidad2;
                    Character bananinou = new Character("Bana", 0, 530, 62, "Agua", habilidadesBananinou, 172);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam2[0] == null) {
                        listaJugadoresTeam2[0] = bananinou;
                    } else if (listaJugadoresTeam2[1] == null) {
                        listaJugadoresTeam2[1] = bananinou;
                    } else if (listaJugadoresTeam2[2] == null) {
                        listaJugadoresTeam2[2] = bananinou;
                    } else if (listaJugadoresTeam2[3] == null) {
                        listaJugadoresTeam2[3] = bananinou;
                    } else if (listaJugadoresTeam2[4] == null) {
                        listaJugadoresTeam2[4] = bananinou;
                    }
                    if (cantidadPersonajes == 0) {
                        buttonChampion1.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion3.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón alakazam
                    Ability habilidad1 = new Ability("Confusión", 120, 150);
                    Ability habilidad2 = new Ability("Psicorrayo", 220, 250);
                    Ability[] habilidadesAlakazam = new Ability[2];
                    habilidadesAlakazam[0] = habilidad1;
                    habilidadesAlakazam[1] = habilidad2;
                    Character alakazam = new Character("Alakazam", 0, 360, 85, "Aire", habilidadesAlakazam, 325);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam1[0] == null) {
                        listaJugadoresTeam1[0] = alakazam;
                    } else if (listaJugadoresTeam1[1] == null) {
                        listaJugadoresTeam1[1] = alakazam;
                    } else if (listaJugadoresTeam1[2] == null) {
                        listaJugadoresTeam1[2] = alakazam;
                    } else if (listaJugadoresTeam1[3] == null) {
                        listaJugadoresTeam1[3] = alakazam;
                    } else if (listaJugadoresTeam1[4] == null) {
                        listaJugadoresTeam1[4] = alakazam;
                    }
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    Ability habilidad1 = new Ability("Confusión", 120, 150);
                    Ability habilidad2 = new Ability("Psicorrayo", 220, 250);
                    Ability[] habilidadesAlakazam = new Ability[2];
                    habilidadesAlakazam[0] = habilidad1;
                    habilidadesAlakazam[1] = habilidad2;
                    Character alakazam = new Character("Alakazam", 0, 360, 85, "Aire", habilidadesAlakazam, 325);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam2[0] == null) {
                        listaJugadoresTeam2[0] = alakazam;
                    } else if (listaJugadoresTeam2[1] == null) {
                        listaJugadoresTeam2[1] = alakazam;
                    } else if (listaJugadoresTeam2[2] == null) {
                        listaJugadoresTeam2[2] = alakazam;
                    } else if (listaJugadoresTeam2[3] == null) {
                        listaJugadoresTeam2[3] = alakazam;
                    } else if (listaJugadoresTeam2[4] == null) {
                        listaJugadoresTeam2[4] = alakazam;
                    }
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion4.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón Ranni the witch
                    Ability habilidad1 = new Ability("Espada luz de la noche", 80, 105);
                    Ability habilidad2 = new Ability("Era de las estrellas", 250, 260);
                    Ability[] habilidadesRanniTheWitch = new Ability[2];
                    habilidadesRanniTheWitch[0] = habilidad1;
                    habilidadesRanniTheWitch[1] = habilidad2;
                    Character ranniTheWitch = new Character("RanniTheWitch", 0, 670, 55, "Fuego", habilidadesRanniTheWitch, 305);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam1[0] == null) {
                        listaJugadoresTeam1[0] = ranniTheWitch;
                    } else if (listaJugadoresTeam1[1] == null) {
                        listaJugadoresTeam1[1] = ranniTheWitch;
                    } else if (listaJugadoresTeam1[2] == null) {
                        listaJugadoresTeam1[2] = ranniTheWitch;
                    } else if (listaJugadoresTeam1[3] == null) {
                        listaJugadoresTeam1[3] = ranniTheWitch;
                    } else if (listaJugadoresTeam1[4] == null) {
                        listaJugadoresTeam1[4] = ranniTheWitch;
                    }
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    Ability habilidad1 = new Ability("Espada luz de la noche", 80, 105);
                    Ability habilidad2 = new Ability("Era de las estrellas", 250, 260);
                    Ability[] habilidadesRanniTheWitch = new Ability[2];
                    habilidadesRanniTheWitch[0] = habilidad1;
                    habilidadesRanniTheWitch[1] = habilidad2;
                    Character ranniTheWitch = new Character("RanniTheWitch", 0, 670, 55, "Fuego", habilidadesRanniTheWitch, 305);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam2[0] == null) {
                        listaJugadoresTeam2[0] = ranniTheWitch;
                    } else if (listaJugadoresTeam2[1] == null) {
                        listaJugadoresTeam2[1] = ranniTheWitch;
                    } else if (listaJugadoresTeam2[2] == null) {
                        listaJugadoresTeam2[2] = ranniTheWitch;
                    } else if (listaJugadoresTeam2[3] == null) {
                        listaJugadoresTeam2[3] = ranniTheWitch;
                    } else if (listaJugadoresTeam2[4] == null) {
                        listaJugadoresTeam2[4] = ranniTheWitch;
                    }
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion5.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón freddy
                    Ability habilidad1 = new Ability("Jumpscare", 80, 130);
                    Ability habilidad2 = new Ability("Arararararar", 120, 200);
                    Ability[] habilidadesFreddy = new Ability[2];
                    habilidadesFreddy[0] = habilidad1;
                    habilidadesFreddy[1] = habilidad2;
                    Character Freddy = new Character("Freddy", 0, 320, 72, "Aire", habilidadesFreddy, 120);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam1[0] == null) {
                        listaJugadoresTeam1[0] = Freddy;
                    } else if (listaJugadoresTeam1[1] == null) {
                        listaJugadoresTeam1[1] = Freddy;
                    } else if (listaJugadoresTeam1[2] == null) {
                        listaJugadoresTeam1[2] = Freddy;
                    } else if (listaJugadoresTeam1[3] == null) {
                        listaJugadoresTeam1[3] = Freddy;
                    } else if (listaJugadoresTeam1[4] == null) {
                        listaJugadoresTeam1[4] = Freddy;
                    }
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón freddy
                    Ability habilidad1 = new Ability("Jumpscare", 80, 130);
                    Ability habilidad2 = new Ability("Arararararar", 120, 200);
                    Ability[] habilidadesFreddy = new Ability[2];
                    habilidadesFreddy[0] = habilidad1;
                    habilidadesFreddy[1] = habilidad2;
                    Character Freddy = new Character("Freddy", 0, 320, 72, "Fuego", habilidadesFreddy, 120);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam2[0] == null) {
                        listaJugadoresTeam2[0] = Freddy;
                    } else if (listaJugadoresTeam2[1] == null) {
                        listaJugadoresTeam2[1] = Freddy;
                    } else if (listaJugadoresTeam2[2] == null) {
                        listaJugadoresTeam2[2] = Freddy;
                    } else if (listaJugadoresTeam2[3] == null) {
                        listaJugadoresTeam2[3] = Freddy;
                    } else if (listaJugadoresTeam2[4] == null) {
                        listaJugadoresTeam2[4] = Freddy;
                    }
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion6.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón freddy
                    Ability habilidad1 = new Ability("Jumpscare", 80, 130);
                    Ability habilidad2 = new Ability("Arararararar", 120, 200);
                    Ability[] habilidadesFreddy = new Ability[2];
                    habilidadesFreddy[0] = habilidad1;
                    habilidadesFreddy[1] = habilidad2;
                    Character Freddy = new Character("Prueba", 0, 320, 72, "Aire", habilidadesFreddy, 120);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam1[0] == null) {
                        listaJugadoresTeam1[0] = Freddy;
                    } else if (listaJugadoresTeam1[1] == null) {
                        listaJugadoresTeam1[1] = Freddy;
                    } else if (listaJugadoresTeam1[2] == null) {
                        listaJugadoresTeam1[2] = Freddy;
                    } else if (listaJugadoresTeam1[3] == null) {
                        listaJugadoresTeam1[3] = Freddy;
                    } else if (listaJugadoresTeam1[4] == null) {
                        listaJugadoresTeam1[4] = Freddy;
                    }
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    //Inicialización del campeón freddy
                    Ability habilidad1 = new Ability("Jumpscare", 80, 130);
                    Ability habilidad2 = new Ability("Arararararar", 120, 200);
                    Ability[] habilidadesFreddy = new Ability[2];
                    habilidadesFreddy[0] = habilidad1;
                    habilidadesFreddy[1] = habilidad2;
                    Character Freddy = new Character("Jose", 0, 320, 72, "Fuego", habilidadesFreddy, 120);
                    //Colocarlo en la lista del team1
                    if (listaJugadoresTeam2[0] == null) {
                        listaJugadoresTeam2[0] = Freddy;
                    } else if (listaJugadoresTeam2[1] == null) {
                        listaJugadoresTeam2[1] = Freddy;
                    } else if (listaJugadoresTeam2[2] == null) {
                        listaJugadoresTeam2[2] = Freddy;
                    } else if (listaJugadoresTeam2[3] == null) {
                        listaJugadoresTeam2[3] = Freddy;
                    } else if (listaJugadoresTeam2[4] == null) {
                        listaJugadoresTeam2[4] = Freddy;
                    }
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion7.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion8.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion9.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                        return;
                    }
                }
            }
        });
        buttonChampion10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChampion10.setEnabled(false);
                //System.out.println("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes+1)+")");
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    if(cantidadPersonajes==0){
                        buttonChampion1.setEnabled(false);
                        buttonChampion2.setEnabled(false);
                        buttonChampion3.setEnabled(false);
                        buttonChampion4.setEnabled(false);
                        buttonChampion5.setEnabled(false);
                        buttonChampion6.setEnabled(false);
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
                        ButtonEmpezar.setEnabled(true);
                    }
                }
            }
        });
    }
/*
    public void pintar(Graphics g){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(System.getProperty("user.dir")+"\\todo\\images\\0000 tucksi.jfif");
        g.drawImage(i, 120,100,this);
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String opciones[]={"1","2","3","4","5"};
        String opciones2[]={"3","4","5"};
        comboBoxTorres = new JComboBox(opciones);
        comboBoxTorres.setBounds(50, 50,90,20);
        comboBoxCantidadP = new JComboBox(opciones2);
        comboBoxCantidadP.setBounds(50, 50,90,20);
        System.out.println(comboBoxCantidadP.getItemAt(2));
        //JPanelTorres.add(comboBoxTorres);
    }

    public static void colocarBotonesDesdeArena(int largoListaPersonajes,boolean quienListaJugadores){
        int xCords=820;
        for(int i=0;i<largoListaPersonajes;i++){
            JButton botonPersonaje=new JButton((quienListaJugadores) ? Arena.jugadoresTeam1[i].name : Arena.jugadoresTeam2[i].name);
            System.out.println(System.getProperty("user.dir")+"\\todo\\images\\"+((quienListaJugadores) ? Arena.jugadoresTeam1[i].name:Arena.jugadoresTeam2[i].name)+".png");
            ImageIcon iconoBoton =new ImageIcon(System.getProperty("user.dir")+"\\todo\\images\\"+"champion"+((quienListaJugadores) ? Arena.jugadoresTeam1[i].name:Arena.jugadoresTeam2[i].name)+".png");
            Icon iconBotonDeVerdad =new ImageIcon(iconoBoton.getImage().getScaledInstance(70,70,Image.SCALE_AREA_AVERAGING));
            botonPersonaje.setIcon(iconBotonDeVerdad);
            botonPersonaje.setBounds(xCords,90,70,70);
            juegoMain.add(botonPersonaje,Integer.valueOf(2));
            xCords+=100;
            int finalI = i;
            botonPersonaje.addActionListener(new ActionListener() {
                private Character personajeBoton=(quienListaJugadores)? Arena.jugadoresTeam1[finalI]:Arena.jugadoresTeam2[finalI];
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!presionado){
                        botonPersonaje.setVisible(false);
                        textoPorDefectoTurnos.setText((quienListaJugadores) ? "Jugador #1 Coloque a su personaje en la arena de juego" : "jugador #2 Coloque a su personaje en la arena de juego");
                        presionado=true;
                        Arena.guardadoSeleccionado=personajeBoton;
                    }
                    else{
                        textoPorDefectoTurnos.setText("No se puede seleccionar otro personaje para colocar, primero coloque a su personaje en la arena");
                    }

                }
            });
        }
        cantidadPersonajesRestantes=Arena.jugadoresTeam1.length;
    }
}



