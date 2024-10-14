package inicioDeSesión;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        String fullPath = System.getProperty("user.dir") + File.separator + "todo" + File.separator + "images" + File.separator + imagePath;
        File imageFile = new File(fullPath);
        if (!imageFile.exists()) {
            System.out.println("No se pudo cargar la imagen de fondo");
        }else{
            System.out.println("Imagen de fondo cargada");
        }

        backgroundImage = new ImageIcon(imagePath).getImage();
        if (backgroundImage == null) {
            System.out.println("No se pudo cargar la imagen de fondo");
        }else{
            System.out.println("Imagen de fondo cargada");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null)
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
