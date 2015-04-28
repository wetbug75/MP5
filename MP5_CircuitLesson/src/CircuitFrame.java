
import java.util.ArrayList;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class CircuitFrame extends javax.swing.JFrame {

    Graph graph;
    CircuitPanel thePanel;//panel containing Elements and Tools
    String[] fileNames; //contains file names for all circuit images
    boolean[] correctAnswers;
    Element[][] elements;
    static final int NUM_CIRCUITS = 4;
    static final int TOOL_WIDTH = 143;
    static final int TOOL_HEIGHT = 77;
    static final int MAX_ELEMENTS = 5;
    final int RC_CIRCUIT = 0;
    final int R_CIRCUIT = 1;
    final int TIMER_CIRCUIT =2;
    ArrayList<Point> f;
    int currentFile;
    boolean voltIsSelected;
    boolean ammIsSelected;
    boolean oscIsSelected;
    Tool voltmeter;
    Tool ammeter;
    Tool osciliscope;

    public CircuitFrame() {
        initComponents();
        
        voltmeter = new Tool(Tool.Type.VOLTMETER);
        ammeter = new Tool(Tool.Type.AMMETER);
        osciliscope = new Tool(Tool.Type.OSCILISCOPE);
        
        voltIsSelected = false;
        ammIsSelected = false;
        oscIsSelected = false;
        
        graph = new Graph();
        graphPanel.add(graph);
        f = new ArrayList<>();
        
        fileNames = new String[NUM_CIRCUITS];
        fileNames[0] = "/imagePackage/series_circuit.png";
        fileNames[1] = "/imagePackage/parallel_circuit.png";
        fileNames[2] = "/imagePackage/rc_circuit.png";
        fileNames[3] = "/imagePackage/555_timer_circuit.png";
        
        currentFile = 0;
        thePanel = new CircuitPanel(fileNames[currentFile]);
        circuitPanel.add(thePanel);
        
        elements = new Element[NUM_CIRCUITS][MAX_ELEMENTS];
        for(int x = 0; x < NUM_CIRCUITS; x++)
        {
            for(int y = 0; y < MAX_ELEMENTS; y++)
                elements[x][y] = null;
        }
        //first page's Element initializations
        elements[0][0] = new Element(10, 0, 0, 39 + thePanel.getCircuitXDistance(), 124 + thePanel.getCircuitYDistance());//battery
        elements[0][1] = new Element(0, -1, 0, 39 + thePanel.getCircuitXDistance(), 338 + thePanel.getCircuitYDistance());//wire
        elements[0][2] = new Element(5, 2, 0, 319 + thePanel.getCircuitXDistance(), 127 + thePanel.getCircuitYDistance());//top resistor
        elements[0][3] = new Element(5, 2, 0, 319 + thePanel.getCircuitXDistance(), 340 + thePanel.getCircuitYDistance());//bottom resistor
        
        //second page's Element initializations
        elements[1][0] = new Element(10, 0, 0, 38 + thePanel.getCircuitXDistance(), 120 + thePanel.getCircuitYDistance());//battery
        elements[1][1] = new Element(0, -1, 0, 38 + thePanel.getCircuitXDistance(), 333 + thePanel.getCircuitYDistance());//wire
        elements[1][2] = new Element(5, 2, 0, 245 + thePanel.getCircuitXDistance(), 123 + thePanel.getCircuitYDistance());//top resistor
        elements[1][3] = new Element(5, 2, 0, 245 + thePanel.getCircuitXDistance(), 336 + thePanel.getCircuitYDistance());//bottom resistor
        elements[1][4] = new Element(10, 3, 0, 444 + thePanel.getCircuitXDistance(), 236 + thePanel.getCircuitYDistance());//right resistor
        
        //third page's Element initializations
        elements[2][0] = new Element(10, 0, 0, 51 + thePanel.getCircuitXDistance(), 125 + thePanel.getCircuitYDistance());//battery
        elements[2][1] = new Element(0, -1, 0, 51 + thePanel.getCircuitXDistance(), 338 + thePanel.getCircuitYDistance());//wire
        elements[2][2] = new Element(5, 2, 0, 331 + thePanel.getCircuitXDistance(), 128 + thePanel.getCircuitYDistance());//resistor
        elements[2][3] = new Element(5, 2,1.0, 331 + thePanel.getCircuitXDistance(), 342 + thePanel.getCircuitYDistance());//capacitor
        
        //fourth page's Element initializations
        elements[3][0] = new Element(10, Double.POSITIVE_INFINITY, 0, 362, 251);//output
        elements[3][1] = new Element(10, 10000, 0, 362, 251);//resistor 1
        elements[3][2] = new Element(10, 10000, 0, 362, 251);//resistor 2
        elements[3][3] = new Element(10, 0, 1.0, 362, 251);//capacitor
        elements[3][4] = new Element(10, 0, 0.01, 362, 251);//Vcc
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();
        circuitPanel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        voltageLabel = new javax.swing.JLabel();
        currentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lessonTextField = new javax.swing.JTextArea();
        answerTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graphPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        graphPanel.setLayout(new java.awt.GridLayout(1, 0));

        circuitPanel.setBackground(new java.awt.Color(255, 255, 255));
        circuitPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        circuitPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                circuitPanelMouseDragged(evt);
            }
        });
        circuitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                circuitPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                circuitPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                circuitPanelMouseReleased(evt);
            }
        });
        circuitPanel.setLayout(new java.awt.GridLayout(1, 0));

        nextButton.setText("next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Voltage:");

        jLabel2.setText("Current:");

        voltageLabel.setText("---");

        currentLabel.setText("---");

        lessonTextField.setColumns(20);
        lessonTextField.setRows(5);
        lessonTextField.setText("Here we have a simple circuit with one \nbattery and two resistors.  Try using the \nvoltmeter to add together the voltage drop \nin each resistor and put your answer below.  \nFeel free to try out the other tools as well.");
        jScrollPane1.setViewportView(lessonTextField);

        answerTextField.setText("0");
        answerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Answer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(circuitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(voltageLabel))
                                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(currentLabel))
                                .addComponent(jScrollPane1)
                                .addComponent(answerTextField))
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circuitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(voltageLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(currentLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previousButton)
                            .addComponent(nextButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clearDataPoints() {
        while(!f.isEmpty())
            f.remove(0);
    }
    
    public void updateGraph(Element e, int circuit) {
        Point p;    //Place holder point
        switch(circuit) {
            case RC_CIRCUIT: 
                int vt = 0; //V as function of time
                double vi = 0; //V initial
                double r = elements[2][2].getResistance();  //R in ohms
                double c = elements[2][3].getCapacitance();  //C Farads
                for(int t = 1; t <= (int)graphPanel.getBounds().getWidth() && vt <= (int)graphPanel.getBounds().getHeight() && vt >= 0; t++) {
                    p = new Point(t, (int) ( vi * (1 - Math.pow(Math.E,( -t/(r*c) ) ))));   //discharging RC circuit
                    //p = new Point(t, (int) ( vi * (Math.pow(Math.E,( -t/(r*c) ) ))));   //charging RC circuit
                    f.add(p);
                }
                break;
            case R_CIRCUIT:
                vt = (int)e.getVolts()*10;
                for(int t = 1; t <= (int)graphPanel.getBounds().getWidth() && vt <= (int)graphPanel.getBounds().getHeight() && vt >= 0; t++) {
                    p = new Point(t, (int) vt);
                    f.add(p);
                }
                break;
            case TIMER_CIRCUIT:
                vt = 0; //V as function of time
                int vcc= (int)elements[3][4].getVolts()*10; //Vcc
                double r1 = elements[3][1].getResistance();  //R1 in ohms
                double r2 = elements[3][2].getResistance();  //R2 in ohms
                c = elements[3][3].getCapacitance();  //C in micro farads
                int freq = (int)(1/(Math.log(2)*c*(r1+2*r2)));
                int tHigh = (int)(Math.log(2)*(r1+r2)*c);
                int tLow = (int)(Math.log(2) * r2*c);
                boolean prevState = true;
                final boolean HIGH = true;
                final boolean LOW = false;
                
                int t = 1;
                while(t <= (int)graphPanel.getBounds().getWidth() && vt <= (int)graphPanel.getBounds().getHeight() && vt >= 0) {
                    for(int t1 = 0; t1 < tLow; t1++) {
                        f.add(new Point(t,1));
                        t++;
                    }
                    for(int t2 = 0; t2 < tHigh; t2++) {
                        f.add(new Point(t,vcc));
                        t++;
                    }
                }
                break;
        }
        for(int i = f.size()-1; i >= 1; i--){
            graph.drawLine(f.get(i), f.get(i-1), (int)graphPanel.getBounds().getHeight());
        }
    }
    
    
    public void updateDisplay()
    {
        voltageLabel.setText(voltmeter.display());
        currentLabel.setText(ammeter.display());
    }
    
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        if(currentFile > 0)
        {
            currentFile--;
            thePanel.reset(fileNames[currentFile]);
            circuitPanel.repaint();
            changeLessonText();
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(currentFile < NUM_CIRCUITS - 1)
        {
            currentFile++;
            thePanel.reset(fileNames[currentFile]);
            circuitPanel.repaint();
            voltageLabel.setText("---");
            currentLabel.setText("---");
            changeLessonText();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    public void changeLessonText()
    {
        switch(currentFile)
        {
            case(0):
                lessonTextField.setText("Here we have a simple circuit with one\nbattery and two resistors.  Try using the\nvoltmeter to add together the voltage drop\nin each resistor and put your answer below.\nFeel free to try out the other tools as well.");
                break;
            case(1):
                lessonTextField.setText("Now the circuit takes two paths.  You’ll notice through\nexperimentation that the current through one path is larger than\nthe other; this is because there is less resistance.  Try to find\nthe resistance of the far right resistor and answer below.\n(Voltage = Current x Resistance)");
                break;
            case(2):
                lessonTextField.setText("This time we have a capacitor.  Much like a battery,\nit stores electrical energy.  However, typically,\ncapacitors disharge their stored energy very quickly.");
                break;
            case(3):
                lessonTextField.setText("THIS IS THE SUPER AWESOME 555 CIRCUIT.\n  A 555 Timer is a simple integrated circuit that uses two \nresistors nand a capacitor to control the state of the output.\n  Resistors R1 and R2 controls rate that the \ncapacitor charges and discharges, hence controlling \nthe frequency of the output squarewave \n( a wave with two values that alternate over time)");
                break;
        }
    }
    
    private void circuitPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseDragged
        if(oscIsSelected)
        {
            thePanel.oscX = evt.getX() - TOOL_WIDTH / 2;
            thePanel.oscY = evt.getY() - TOOL_HEIGHT / 2;
            circuitPanel.repaint();
        }
        else if(ammIsSelected)
        {
            thePanel.ammX = evt.getX() - TOOL_WIDTH / 2;
            thePanel.ammY = evt.getY() - TOOL_HEIGHT / 2;
            circuitPanel.repaint();
        }
        else if(voltIsSelected)
        {
            thePanel.voltX = evt.getX() - TOOL_WIDTH / 2;
            thePanel.voltY = evt.getY() - TOOL_HEIGHT / 2;
            circuitPanel.repaint();
        }
    }//GEN-LAST:event_circuitPanelMouseDragged

    private void circuitPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMousePressed
        if(evt.getX() >= thePanel.oscX && evt.getX() < thePanel.oscX + TOOL_WIDTH && evt.getY() >= thePanel.oscY && evt.getY() < thePanel.oscY + TOOL_HEIGHT)
        {
            oscIsSelected = true;
        }
        else if(evt.getX() >= thePanel.ammX && evt.getX() < thePanel.ammX + TOOL_WIDTH && evt.getY() >= thePanel.ammY && evt.getY() < thePanel.ammY + TOOL_HEIGHT)
        {
            ammIsSelected = true;
        }
        else if(evt.getX() >= thePanel.voltX && evt.getX() < thePanel.voltX + TOOL_WIDTH && evt.getY() >= thePanel.voltY && evt.getY() < thePanel.voltY + TOOL_HEIGHT)
        {
            voltIsSelected = true;
        }
    }//GEN-LAST:event_circuitPanelMousePressed

    private void circuitPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseReleased
        if(oscIsSelected)
        {
            for(int i = 0; i < MAX_ELEMENTS && elements[currentFile][i] != null; i++)
            {
                if(shouldShiftPosition(thePanel.oscX, thePanel.oscY, elements[currentFile][i].getXCoordinate(), elements[currentFile][i].getYCoordinate()))
                {
                    thePanel.oscX = elements[currentFile][i].getXCoordinate() - 8;
                    thePanel.oscY = elements[currentFile][i].getYCoordinate() - 8;
                    osciliscope.setElement(elements[currentFile][i]);
                    i = MAX_ELEMENTS;
                    int circuit = R_CIRCUIT;
                    switch(currentFile) {
                        case 2:
                            circuit = RC_CIRCUIT;
                            break;
                        case 3:
                            circuit = TIMER_CIRCUIT;
                    }
                    graph.clearGraph();
                    updateGraph(osciliscope.getElement(),circuit);
                }
            }
        }
        else if(ammIsSelected)
        {
            for(int i = 0; i < MAX_ELEMENTS && elements[currentFile][i] != null; i++)
            {
                if(shouldShiftPosition(thePanel.ammX, thePanel.ammY, elements[currentFile][i].getXCoordinate(), elements[currentFile][i].getYCoordinate()))
                {
                    thePanel.ammX = elements[currentFile][i].getXCoordinate() - 8;
                    thePanel.ammY = elements[currentFile][i].getYCoordinate() - 8;
                    ammeter.setElement(elements[currentFile][i]);
                    i = MAX_ELEMENTS;
                }
            }
        }
        else if(voltIsSelected)
        {
            for(int i = 0; i < MAX_ELEMENTS && elements[currentFile][i] != null; i++)
            {
                if(shouldShiftPosition(thePanel.voltX, thePanel.voltY, elements[currentFile][i].getXCoordinate(), elements[currentFile][i].getYCoordinate()))
                {
                    thePanel.voltX = elements[currentFile][i].getXCoordinate() - 8;
                    thePanel.voltY = elements[currentFile][i].getYCoordinate() - 8;
                    voltmeter.setElement(elements[currentFile][i]);
                    i = MAX_ELEMENTS;
                }
            }
        }
        circuitPanel.repaint();
        voltIsSelected = false;
        ammIsSelected = false;
        oscIsSelected = false;
        updateDisplay();
        clearDataPoints();
    }//GEN-LAST:event_circuitPanelMouseReleased
  
    public boolean shouldShiftPosition(int toolX, int toolY, int elementX, int elementY)
    {
        toolX += 8;
        toolY += 8;
        if(toolX > elementX - 50 && toolX < elementX + 50)
        {
            if(toolY > elementY - 50 && toolY < elementY + 50)
                return true;
        }
        return false;
    }
    
    private void circuitPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseExited
        voltIsSelected = false;
        ammIsSelected = false;
        oscIsSelected = false;
    }//GEN-LAST:event_circuitPanelMouseExited

    private void answerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerTextFieldActionPerformed
        switch(currentFile)
        {
            case(0):
                if(answerTextField.getText().equals("10"))
                {
                    JOptionPane.showMessageDialog(null, "Good job! Notice how the total voltage drop is equal to the voltage of the battery.\nThis will always happen with circuits that stay connected in one simple loop.\nClick next to continue.", "Correct!", JOptionPane.INFORMATION_MESSAGE);
                    correctAnswers[0] = true;
                } 
                else
                    JOptionPane.showMessageDialog(null, "Sorry, try again. Make sure you're entering just the number.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                break;
            case(1):
                if(answerTextField.getText().equals("3"))
                {
                    JOptionPane.showMessageDialog(null, "Nice Job!  You may have noticed that this resistor has a larger resistance\nthan the two other resistors, but the current is still larger on the far right path.\nThis is because resistances add when in series.\nClick next to continue.", "Correct!", JOptionPane.INFORMATION_MESSAGE);
                    correctAnswers[1] = true;
                } 
                else
                    JOptionPane.showMessageDialog(null, "Sorry, try again. Make sure you're entering just the number.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                break;
            case(2):
                if(answerTextField.getText().equals("IDK"))
                {
                    JOptionPane.showMessageDialog(null, "Congratulatory message!", "Correct!", JOptionPane.INFORMATION_MESSAGE);
                    correctAnswers[2] = true;
                }
                else
                    JOptionPane.showMessageDialog(null, "Sorry, try again. Make sure you're entering just the number.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                break;
            case(3):
                if(answerTextField.getText().equals("IDK"))
                {
                    JOptionPane.showMessageDialog(null, "Congratulatory message!", "Correct!", JOptionPane.INFORMATION_MESSAGE);
                    correctAnswers[3] = true;
                }
                else
                    JOptionPane.showMessageDialog(null, "Sorry, try again. Make sure you're entering just the number.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                break;

        }
        if(allCorrect())
            JOptionPane.showMessageDialog(null, "Congradulations, you have successfully answered all questions! continue experimenting at your leisure.", "Lesson Complete", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_answerTextFieldActionPerformed

    public boolean allCorrect()
    {
        for(int i = 0; i < NUM_CIRCUITS; i++)
        {
            if(!correctAnswers[i])
                return false;
        }
        return true;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CircuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CircuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CircuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CircuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CircuitFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerTextField;
    private javax.swing.JPanel circuitPanel;
    private javax.swing.JLabel currentLabel;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lessonTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel voltageLabel;
    // End of variables declaration//GEN-END:variables
}
