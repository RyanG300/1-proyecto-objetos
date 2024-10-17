package inicioDeSesión;


import casillaObjetos.SelectCharacter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField1;
    private JTextField usernameField2;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel(System.getProperty("user.dir")+"/todo/images/HomeScreen.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        JLabel label1 = new JLabel("Jugador 1 ");
        label1.setBounds(360, 330, 150, 25);
        label1.setFont(new Font("Georgia", Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);
        backgroundPanel.add(label1);  // Add to backgroundPanel

        usernameField1 = new JTextField();
        usernameField1.setBounds(330, 360, 150, 25);

        usernameField1.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField1.setBackground(Color.BLACK);
        usernameField1.setForeground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        usernameField1.setBorder(border);
        backgroundPanel.add(usernameField1);  // Add to backgroundPanel

        JLabel label2 = new JLabel("Jugador 2");
        label2.setBounds(360, 390, 150, 25);
        label2.setFont(new Font("Georgia", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE);
        backgroundPanel.add(label2);  // Add to backgroundPanel

        usernameField2 = new JTextField();
        usernameField2.setBounds(330, 420, 150, 25);
        usernameField2.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField2.setBackground(Color.BLACK);
        usernameField2.setForeground(Color.WHITE);
        usernameField2.setBorder(border);
        backgroundPanel.add(usernameField2);  // Add to backgroundPanel


        loginButton = new JButton("Login");
        loginButton.setBounds(330, 470, 150, 25);
        loginButton.setFont(new Font("Georgia", Font.PLAIN, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(Color.BLACK);

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.BLACK);
            }
        });
        backgroundPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = usernameField1.getText().toLowerCase();
                String name2 = usernameField2.getText().toLowerCase();


                if (name1.isEmpty() || name2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese los nombres de ambos jugadores");
                    return;
                }

                if (name1.equals(name2)) {
                    JOptionPane.showMessageDialog(null, "Usuarios repetidos, por favor ingrese nombres diferentes");
                    return;
                }

                // Obtener o crear usuario
                User user1 = null;
                user1 = User.loadOrCreateUser(name1);


                User user2 = null;
                user2 = User.loadOrCreateUser(name2);

                // Mostrar la ventana de selección de personaje
                new SelectCharacter(user1, user2, 3).setVisible(true);
                dispose(); // Cerramos la ventana de login
            }
        });
    }
}



