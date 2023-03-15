/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ste-PC
 */
public class HashMap<K, V> {
    
    private ArrayList<Pair<K, V>>values;
    private int firstFreeIndex;
    
    public HashMap(){
        this.values = new ArrayList<>();
        this.firstFreeIndex = 0;
    }
    
    public V get(K key){
        for(int i = 0; i < values.size(); i++){
            if(values.get(i).getKey().equals(key)){
                return values.get(i).getValue();
            }
        }
        return null;
    }
    
    public void add(K key, V value){
        this.values.add(new Pair(key, value));
    }
    
    public void remove(K key){
        this.values.remove(key);
    }
}
