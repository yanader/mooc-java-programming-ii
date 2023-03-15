/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class Book {
    private String name;
    private int ageRec;
    
    public Book(String name, int ageRec){
        this.name = name;
        this.ageRec = ageRec;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAgeRec(){
        return this.ageRec;
    }
    
    @Override
    public String toString(){
        return this.name + " (recommended for " + this.ageRec + " year-olds or older)";
    }
}   

