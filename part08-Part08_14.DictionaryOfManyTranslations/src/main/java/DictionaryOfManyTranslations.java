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
public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;
    
    public DictionaryOfManyTranslations(){
        this.dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation){
        this.dictionary.putIfAbsent(word, new ArrayList<String>());
        this.dictionary.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word){
        if(!dictionary.containsKey(word)){
            return new ArrayList<String>();
        } else {
            return dictionary.get(word);
        }
    }
    
    public void remove(String word){
        this.dictionary.remove(word);
    }
}
