/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Ste-PC
 */
public class Warehouse {

    private Map<String, Integer> warehousePrices;
    private Map<String, Integer> warehouseStock;

    public Warehouse() {
        this.warehousePrices = new HashMap<>();
        this.warehouseStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        warehousePrices.put(product, price);
        warehouseStock.put(product, stock);
    }

    public int price(String product) {
        if (warehousePrices.containsKey(product)) {
            return warehousePrices.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (warehouseStock.containsKey(product)) {
            return warehouseStock.get(product);
        } else {
            return 0;
        }
    }
    
    public boolean take(String product){
        if(!(warehouseStock.containsKey(product))){
            return false;
        }
        if (warehouseStock.get(product) == 0) {
            return false;
        } else {
            warehouseStock.put(product, warehouseStock.get(product) - 1);
            return true;
        }
    }
    
    public Set<String> products(){
        Set returnSet = warehouseStock.keySet();
        return returnSet;
    }
}
