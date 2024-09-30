package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
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
                if(TurnoJugadorText.getText().equals("Jugador 1 elige. (Cantidad restantes: "+(cantidadPersonajes)+")")){
                    TurnoJugadorText.setText("Jugador 2 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
                    if(cantidadPersonajes==0){
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
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
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
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
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
                }
                else{
                    cantidadPersonajes--;
                    TurnoJugadorText.setText("Jugador 1 elige. (Cantidad restantes: "+cantidadPersonajes+")");
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



