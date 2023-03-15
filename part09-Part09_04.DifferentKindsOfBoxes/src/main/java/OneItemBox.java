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
public class OneItemBox extends Box{
    private boolean full;
    private ArrayList<Item> box;
    
    public OneItemBox(){
        this.full = false;
        box = new ArrayList<>();
    }
    
    public void add(Item item){
        if(!full){
            this.box.add(item);
        }
        this.full = true;
    }
    
    public boolean isInBox(Item item){
        return box.contains(item);
    }
}
