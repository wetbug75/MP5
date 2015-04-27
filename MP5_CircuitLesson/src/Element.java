/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Element {
    private double volts;
    private double resistance;
    private int xCoord;
    private int yCoord;
    
    Element(double voltValue, double resistValue, int x, int y)
    {
        volts = voltValue;
        resistance = resistValue;
        xCoord = x;
        yCoord = y;
    }
    
    public int getXCoordinate()
    {
        return xCoord;
    }
    
    public int getYCoordinate()
    {
        return yCoord;
    }
    
    public double getVolts()
    {
        return volts;
    }
    
    public double getCurrent()
    {
        return volts / resistance;
    }
    
    public double getResistance()
    {
        return resistance;
    }
    
    public void setVolts(double v)
    {
        volts = v;
    }
    
    public void setResistance(int r)
    {
        resistance = r;
    }
}
