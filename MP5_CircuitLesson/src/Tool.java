/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Tool {
    //static final int WIRE = 1;
    //static final int RESISTOR = 2;
    //static final int BATTERY = 3;
    //static final int CAPACITOR = 4;
    
    int value;
    
    Tool()
    {
        value = 0;
    }
    
    public String display()
    {
        if(value == -1)
            return "ERROR";
        return "" + value;
    }
    
    public void setValue(Node part)
    {
        
    }
}
