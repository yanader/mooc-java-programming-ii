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
public class Pipe<T> {
    private ArrayList<T> contents;
    
    public Pipe(){   
        this.contents = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        this.contents.add(value);
    }
    
    public T takeFromPipe(){
        if(!isInPipe()){
            return null;
        } else {
            T returnT = this.contents.get(0);
            this.contents.remove(0);
            return returnT;
        }
    }
    
    public boolean isInPipe(){
        return !(this.contents.isEmpty());
    }
}
