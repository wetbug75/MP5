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
    
    //returns value as long as it isn't negative
    public String display()
    {
        if(value < 0)
            return "ERROR";
        return "" + value;
    }
    
    //sets value based on type and element
    public void getValue()
    {
        if(type == Type.VOLTMETER)
            value = element.getVolts();
        else if(type == Type.AMMETER)
            value = element.getCurrent();
        else if(type == Type.OSCILISCOPE)
            value = 0;
    }
    
    //changes element and sets value to appropriate value
    public void setElement(Element e)
    {
        element = e;
        getValue();
    }
    
    //returns element
    public Element getElement()
    {
        return element;
    }
    
    //pretty much emptys the tool stored value
    public void emptyTool()
    {
        element.setAllZero();
    }
}
