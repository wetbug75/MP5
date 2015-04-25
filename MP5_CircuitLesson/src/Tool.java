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
    static enum Type
    {
        VOLTMETER, AMMETER, OSCILISCOPE;
    }
    
    private Type type;
    private double value;
    private Element element;
    
    Tool(Type t)
    {
        value = 0;
        type = t;
    }
    
    public String display()
    {
        if(value < 0)
            return "ERROR";
        return "" + value;
    }
    
    public void getValue()
    {
        if(type == Type.VOLTMETER)
            value = element.getVolts();
        else if(type == Type.AMMETER)
            value = element.getCurrent();
        else if(type == Type.OSCILISCOPE)
            value = 0;
    }
    
    public void setElement(Element e)
    {
        element = e;
        getValue();
    }
    
    public Element getElement()
    {
        return element;
    }
}
