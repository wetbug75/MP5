/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author mtbjj
 */
public class Graph extends Canvas{
    
    Graph() {
         
    }
    
    void drawLine(Point p1, Point p2, int graphHeight) {
        Graphics g = getGraphics();
        g.drawLine(p1.getX(), graphHeight -p1.getY(), p2.getX(), graphHeight -p2.getY());
    }
    
    void clearGraph(){
        Graphics g = getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
    }
}
