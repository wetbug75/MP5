/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Node {
    /*static enum Type{
        WIRE, RESISTOR, BATTERY, CAPACITOR;
    }*/
    
    private int volts;
    private int resistance;
    //public Type type;
    
    
    Node(/*Type thing,*/ int voltValue, int resistValue)
    {
        //type = thing;
        volts = voltValue;
        resistance = resistValue;
    }
    
    /*public Type getType()
    {
        return type;
    }*/
    
    public int getVolts()
    {
        return volts;
    }
    
    public double getCurrent()
    {
        return volts / resistance;
    }
    
    public int getResistance()
    {
        return resistance;
    }
    
    public void setVolts(int v)
    {
        volts = v;
    }
    
    public void setResistance(int r)
    {
        resistance = r;
    }
}
