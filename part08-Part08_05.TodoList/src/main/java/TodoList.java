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
public class TodoList {
    private ArrayList<String> list;
    
    
    public TodoList(){
        this.list = new ArrayList<>();
    }
    
    public void add(String task){
        list.add(task);
    }
    
    public void print(){
        for(int i = 0; i < this.list.size(); i++){
            System.out.println((i+1) + ": " + list.get(i));
        }
    }
    
    public void remove(int i){
        list.remove(i-1);
    }
}
