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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JPanel JPanelQuienToca;
    private JPanel JPanelTitulos;
    private JLabel TitulosText;
    private JLabel TurnoJugadorText;
    private JComboBox comboBoxCantidadP;
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
        createUIComponents();

        juego.add(NuevoJuegoItem);
        juego.add(RendirseItem);
        menuBar.add(juego);
        menuBar.add(ayuda);
        this.setJMenuBar(menuBar);


        setVisible(true);
        setSize(800, 600);

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
                //Aqui iria la inicializacion de la clase arena xdxdxd
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
        comboBox1 = new JComboBox(opciones);
        comboBox1.setBounds(50, 50,90,20);
        comboBoxCantidadP = new JComboBox(opciones);
        comboBoxCantidadP.setBounds(50, 50,90,20);
        //JPanelTorres.add(comboBox1);
    }
}



