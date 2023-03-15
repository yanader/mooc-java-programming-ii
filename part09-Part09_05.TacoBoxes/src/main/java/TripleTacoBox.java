/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class TripleTacoBox implements TacoBox {

    private int tacoCount;

    public TripleTacoBox() {
        this.tacoCount = 3;
    }

    public int tacosRemaining() {
        return this.tacoCount;
    }

    public void eat() {
        if (this.tacoCount > 0) {
            this.tacoCount--;
        }
    }

}
