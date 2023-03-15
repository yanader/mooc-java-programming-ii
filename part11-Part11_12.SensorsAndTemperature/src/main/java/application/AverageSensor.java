/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ste-PC
 */
public class AverageSensor implements Sensor {
    
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }
    
    @Override
    public boolean isOn(){
        for(Sensor sensor : sensors){
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void setOn(){
        for(Sensor sensor: sensors){
            sensor.setOn();
        }
    }
    
    @Override
    public void setOff(){
        for(Sensor sensor: sensors){
            sensor.setOff();
        }
    }
    
    @Override
    public int read(){
        double returnAverage;
        if(!this.isOn()){
            throw new IllegalStateException();
        } else {
            returnAverage = this.sensors.stream().filter(s -> s.isOn()).mapToInt(Sensor::read).average().getAsDouble();
        }
        readings.add((int)returnAverage);
        return (int)returnAverage;
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
}
