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
public class Herd implements Movable {
    private ArrayList<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList<Movable>();
    }
    
    public String toString(){
        String returnString = "";
        for(Movable movable: herd){
            returnString = returnString + movable.toString() + '\n';
        }
        return returnString;
    }
    
    public void addToHerd(Movable movable){
        herd.add(movable);
    }
    
    public void move(int dx, int dy){
        for(Movable movable: herd){
            movable.move(dx, dy);
        }
    }
    
}
