package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame{
    private JPanel panel1;
    private JButton PlayButtonMenu;
    private JButton SalirButtonMenu;

    public home() {
        setContentPane(panel1);
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





        SalirButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        PlayButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}



