/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ste-PC
 */
public class CD implements Packable{
    private String artist;
    private String title;
    private int pubYear;
    private final double weight;
    
    public CD(String artist, String title, int pubYear){
        this.artist = artist;
        this.title = title;
        this.pubYear = pubYear;
        this.weight = 0.1;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return artist + ": " + title + " (" + pubYear + ")";
    }
}
