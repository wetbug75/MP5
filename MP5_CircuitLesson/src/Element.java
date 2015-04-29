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
    private double capacitance;
    private int xCoord;//x-coordinate of Element
    private int yCoord;//y-coordinate of Element
    
    Element(double voltage, double resistance, double capacitance, int x, int y)
    {
        volts = voltage;
        this.resistance = resistance;
        this.capacitance = capacitance;
        xCoord = x;
        yCoord = y;
    }
    
    //returns xCoord
    public int getXCoordinate()
    {
        return xCoord;
    }
    
    //return yCoord
    public int getYCoordinate()
    {
        return yCoord;
    }
    
    //return volts
    public double getVolts()
    {
        return volts;
    }
    
    //return capacitance
    public double getCapacitance()
    {
        return capacitance;
    }
    
    //returns volt / resistance, wich is current
    public double getCurrent()
    {
        return volts / resistance;
    }
    
    //returns resistance
    public double getResistance()
    {
        return resistance;
    }
    
    //change volts
    public void setVolts(double v)
    {
        volts = v;
    }
    
    //change resistance
    public void setResistance(int r)
    {
        resistance = r;
    }
    
    //changes non-coordinage values to zero
    public void setAllZero()
    {
        volts = 0;
        resistance = 0;
        capacitance = 0;
    }
}
