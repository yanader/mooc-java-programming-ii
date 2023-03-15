/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Ste-PC
 */
public class StandardSensor  implements Sensor{
    private final boolean on;
    private int reading;
    
    public StandardSensor(int reading){
        this.on = true;
        this.reading = reading;
    }
    @Override
    public void setOn(){
    }
    @Override
    public void setOff(){
    }
    @Override
    public boolean isOn(){
        return true;
    }
    @Override
    public int read(){
        if (isOn()){
            return this.reading;
        } else {
            throw new IllegalStateException();
        } 
    }
}
