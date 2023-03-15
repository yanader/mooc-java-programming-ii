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
public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> box;
    
    public BoxWithMaxWeight(int capacity){
        super();
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }
    
    public boolean isInBox(Item item){
        return box.contains(item);
    }
    
    public void add(Item item){
        int totalWeight = 0;
        for(Item boxItem: this.box){
            totalWeight += boxItem.getWeight();
        }
        if(!(totalWeight + item.getWeight() > this.capacity)){
            this.box.add(item);
        }
        
    }
    
    
}
