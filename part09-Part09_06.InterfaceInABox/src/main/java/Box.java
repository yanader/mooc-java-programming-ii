/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author Ste-PC
 */
public class Box implements Packable{
    private final double maximumCapacity;
    private ArrayList<Packable> boxContents;
    
    public Box(double maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.boxContents = new ArrayList<>();
    }
    
    public void add(Packable packable){
        if(!(this.weight() + packable.weight() > this.maximumCapacity)){
            boxContents.add(packable);
        }
    }
    
    public double weight(){
        double weight = 0.0;
        for(Packable packable : boxContents)        {
            weight += packable.weight();
        }
        return weight;
    }
    
    public String toString(){
        return "Box: " + boxContents.size() + " items, total weight " + weight() + " kg";
    }
}
