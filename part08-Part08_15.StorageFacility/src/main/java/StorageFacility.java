/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author Ste-PC
 */
public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageFacility;
    
    public StorageFacility(){
        this.storageFacility = new HashMap<>();
    }
    
    public void add(String unit, String item){
        this.storageFacility.putIfAbsent(unit, new ArrayList<String>());
        this.storageFacility.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){
        if(!storageFacility.containsKey(storageUnit)){
            return new ArrayList<String>();
        } else {
            return storageFacility.get(storageUnit);
        }
    }
    
    public void remove(String storageUnit, String item){
        this.storageFacility.get(storageUnit).remove(item);
        if(this.storageFacility.get(storageUnit).isEmpty()){
            this.storageFacility.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> returnList = new ArrayList<>();
        for(String unit : storageFacility.keySet()){
            if(!storageFacility.get(unit).isEmpty()){
                returnList.add(unit);
            }
        }
        return returnList;
    }
}
