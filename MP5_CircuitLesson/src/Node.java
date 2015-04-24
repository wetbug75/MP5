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
    static enum Type{
        WIRE, RESISTOR, BATTERY, CAPACITOR;
    }
    //WIRE = 1;
    //RESISTOR = 2;
    //BATTERY = 3;
    //CAPACITOR = 4;
    
    private int volts;
    private int resistance;
    Type type;
    //osciliscope vars?
    
    Node(Type thing, int voltValue, int resistValue/*, osciliscope vars*/)
    {
        type = thing;
        volts = voltValue;
        resistance = resistValue;
        //osciliscope?
    }
    
    public Type getType()
    {
        return type;
    }
    
    public int getVolts()
    {
        return volts;
    }
    
    public int getResistance()
    {
        return resistance;
    }
    
    /*public void graphOsciliscope()
    {
        ???
    }*/
    
    public void setVolts(int v)
    {
        volts = v;
    }
    
    public void setResistance(int r)
    {
        resistance = r;
    }
}
