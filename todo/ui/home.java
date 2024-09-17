package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame{
    private JPanel Todo;
    private JPanel JPanelJuego;
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
    private JTextField textField1;
    private JPanel JPanelTal;
    private JLabel Shit;
    private JLabel tal;
    private JButton PlayButtonMenu;
    private JButton SalirButtonMenu;

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

        juego.add(NuevoJuegoItem);
        juego.add(RendirseItem);
        menuBar.add(juego);
        menuBar.add(ayuda);
        this.setJMenuBar(menuBar);


        setVisible(true);
        setSize(800, 600);

    }
}



