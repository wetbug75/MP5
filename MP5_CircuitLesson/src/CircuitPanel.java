
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class CircuitPanel extends javax.swing.JPanel {

    public int voltX;
    public int voltY;
    public int ammX;
    public int ammY;
    public int oscX;
    public int oscY;
    private String circuitFileName;
    
    public CircuitPanel(String circuitFileName) {
        initComponents();
        reset(circuitFileName);
        this.setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        BufferedImage circuitImage = null;
        BufferedImage voltmeterImage = null;
        BufferedImage ammeterImage = null;
        BufferedImage osciliscopeImage = null;
        try {
            circuitImage = ImageIO.read(getClass().getResource(circuitFileName));
            voltmeterImage = ImageIO.read(getClass().getResource("/imagePackage/voltmeter.png"));
            ammeterImage = ImageIO.read(getClass().getResource("/imagePackage/ammeter.png"));
            osciliscopeImage = ImageIO.read(getClass().getResource("/imagePackage/osciliscope.png"));
        } catch (IOException ex) {
            Logger.getLogger(CircuitPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("didn't work");
        }
        g2D.drawImage(circuitImage, 30, 60, this);
        g2D.drawImage(voltmeterImage, voltX, voltY, this);
        g2D.drawImage(ammeterImage, ammX, ammY, this);
        g2D.drawImage(osciliscopeImage, oscX, oscY, this);
    }
    
    public void reset(String fileName)
    {
        voltX = 600;
        voltY = 50;
        ammX = 600;
        ammY = 150;
        oscX = 600;
        oscY = 250;
        circuitFileName = fileName;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
