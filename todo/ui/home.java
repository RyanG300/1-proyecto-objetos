package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import casillaObjetos.Character;
import casillaObjetos.Ability;

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
    private JComboBox comboBox1;
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
    //Datos importantes para emepzar la partida
    private int cantidadPersonajes;
    private String tipoArena;
    private Character[] listaJugadoresTeam1;
    private Character[] listaJugadoresTeam2;

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
        setSize(1000, 600);

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

        ButtonEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldX.getText().equals("")) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se digitó el tamaño de la arena.");
                }
                else if (textFieldY.getText().equals("")) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se digitó el tamaño de la arena.");
                }

                if(!aguaCheckBox.isSelected()
                        && !fuegoCheckBox.isSelected()
                        && !aireCheckBox.isSelected()
                        && !tierraCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(ButtonEmpezar,"Error: No se selecionó el tipo de arena.");
                }
                //Aqui iria la inicializacion de la clase arena xdxdxd
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
                    Character t34=new Character("t34",0,600,58,"Tierra",habilidadesT34,250);
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
                    Character t34=new Character("t34",0,600,58,"Tierra",habilidadesT34,250);
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
                if (TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: " + (cantidadPersonajes) + ")")) {
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: " + cantidadPersonajes + ")");
                    //Inicialización del campeón bananirou
                    Ability habilidad1 = new Ability("La pechea", 35, 85);
                    Ability habilidad2 = new Ability("El salto del papu", 120, 120);
                    Ability[] habilidadesBananinou = new Ability[2];
                    habilidadesBananinou[0] = habilidad1;
                    habilidadesBananinou[1] = habilidad2;
                    Character bananinou = new Character("bananinou", 0, 530, 62, "Agua", habilidadesBananinou, 172);
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
                    Character bananinou = new Character("bananinou", 0, 530, 62, "Agua", habilidadesBananinou, 172);
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
                    Character alakazam = new Character("alakazam", 0, 360, 85, "Aire", habilidadesAlakazam, 325);
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
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    Ability habilidad1 = new Ability("Confusión", 120, 150);
                    Ability habilidad2 = new Ability("Psicorrayo", 220, 250);
                    Ability[] habilidadesAlakazam = new Ability[2];
                    habilidadesAlakazam[0] = habilidad1;
                    habilidadesAlakazam[1] = habilidad2;
                    Character alakazam = new Character("alakazam", 0, 360, 85, "Aire", habilidadesAlakazam, 325);
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
                    Character ranniTheWitch = new Character("Ranni the witch", 0, 670, 55, "Fuego", habilidadesRanniTheWitch, 305);
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
                    Character ranniTheWitch = new Character("Ranni the witch", 0, 670, 55, "Fuego", habilidadesRanniTheWitch, 305);
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
                        buttonChampion7.setEnabled(false);
                        buttonChampion8.setEnabled(false);
                        buttonChampion9.setEnabled(false);
                        buttonChampion10.setEnabled(false);
                        TurnoJugadorText.setText("Campeones elegidos, ya se puede empezar la partida.");
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
                    }
                }
            }
        });
    }

    public void pintar(Graphics g){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(System.getProperty("user.dir")+"\\todo\\images\\0000 tucksi.jfif");
        g.drawImage(i, 120,100,this);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String opciones[]={"1","2","3","4","5"};
        String opciones2[]={"3","4","5"};
        comboBox1 = new JComboBox(opciones);
        comboBox1.setBounds(50, 50,90,20);
        comboBoxCantidadP = new JComboBox(opciones2);
        comboBoxCantidadP.setBounds(50, 50,90,20);
        System.out.println(comboBoxCantidadP.getItemAt(2));
        //JPanelTorres.add(comboBox1);
    }

}



