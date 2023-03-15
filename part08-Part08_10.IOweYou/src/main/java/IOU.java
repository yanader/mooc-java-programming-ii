/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;

/**
 *
 * @author Ste-PC
 */
public class IOU {

    private HashMap<String, Double> oweMap;

    public IOU() {
        this.oweMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        oweMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        double owed = 0.0;
        for(String person:this.oweMap.keySet()){
            if(person.equals(toWhom)){
                owed += this.oweMap.getOrDefault(toWhom,0.0);
            }
        }
        return owed;
    }
}

