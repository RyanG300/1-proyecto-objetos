package casillaObjetos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedImageLabel extends JLabel {
    private int cornerRadius = 10;

    public RoundedImageLabel(ImageIcon icon){
        super(icon);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape clip = g2.getClip();
        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintComponent(g2);
        g2.setClip(clip);
        g2.dispose();
    }
}
