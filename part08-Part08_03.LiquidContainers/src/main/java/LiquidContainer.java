/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class LiquidContainer {
    private int amount;
    
    public LiquidContainer(){
        this.amount = 0;
    }
    
    public void add(int amount){
        if(amount > 0){
            this.amount += amount;
        }
        if(this.amount > 100){
            this.amount = 100;
        }
    }
    
    public void remove(int amount){
        if(amount > 0){
            this.amount -= amount;
        }
        if(this.amount < 0){
            this.amount = 0;
        }
    }
    
    public int getAmount(){
        return this.amount;
    }
}
