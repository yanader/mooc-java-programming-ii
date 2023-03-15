/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }
    
    public String history(){
        return changeHistory.toString();
    }
    
    @Override
    public void addToWarehouse(double amount){
        if (amount < 0) {
            return;
        }
        super.addToWarehouse(amount);
        changeHistory.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount){
        if (amount < 0) {
            return 0.0;
        }
        double taken = super.takeFromWarehouse(amount);
        changeHistory.add(super.getBalance());
        return taken;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.changeHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.changeHistory.minValue());
        System.out.println("Average: " + this.changeHistory.average());
        
        
    }
}
