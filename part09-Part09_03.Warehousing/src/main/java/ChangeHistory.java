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
public class ChangeHistory {
    private ArrayList<Double> changeHistory;
    
    public ChangeHistory(){
        this.changeHistory = new ArrayList<>();
    }
    
    public void add (double status){
        this.changeHistory.add(status);
    }
    
    public void clear(){
        this.changeHistory.clear();
    }
    
    public String toString(){
        return changeHistory.toString();
    }
    
    public double maxValue(){
        double returnValue = 0.0;
        for(int i = 0; i < this.changeHistory.size(); i++){
            if(changeHistory.get(i) > returnValue){
                returnValue = changeHistory.get(i);
            }
        }
        return returnValue;
    }
    
    public double minValue(){
        if(this.changeHistory.isEmpty()){
            return 0.0;
        }
        double returnValue = this.maxValue();
        for(int i = 0; i < changeHistory.size(); i++){
            if(changeHistory.get(i) < returnValue){
                returnValue = changeHistory.get(i);
            }
        }
        return returnValue;
    }
    
    public double average(){
        if(this.changeHistory.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        for(int i = 0; i < changeHistory.size(); i++){
            sum += changeHistory.get(i);
        }
        return sum / changeHistory.size();
    }
}
