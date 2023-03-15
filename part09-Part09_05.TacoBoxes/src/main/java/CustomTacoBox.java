/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class CustomTacoBox implements TacoBox {
    private int tacoCount;
    
    public CustomTacoBox(int initialTacos){
        this.tacoCount = initialTacos;
    }
    
    public int tacosRemaining(){
        return this.tacoCount;
    }

    public void eat(){
        if (this.tacoCount > 0) {
            this.tacoCount--;
        }
    }
}
