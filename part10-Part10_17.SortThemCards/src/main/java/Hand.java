/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/**
 *
 * @author Ste-PC
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public void add(Card cardToAdd){
        this.hand.add(cardToAdd);
    }
    
    public void print(){
        Iterator<Card> iterator = this.hand.iterator();
        while(iterator.hasNext()){
            Card nextCard = iterator.next();
            System.out.println(nextCard);
        }
    }
    
    public void sort(){
        Comparator<Card> comparator = Comparator
                                        .comparing(Card::getValue)
                                        .thenComparing(Card::getSuit);
        
        Collections.sort(hand, comparator);
    }
    
    public int compareTo(Hand handToCompare){
        int thisHandValue = 0;
        int compareHandValue = 0;
        
        Iterator<Card> iteratorThisHand = this.hand.iterator();
        while(iteratorThisHand.hasNext()){
            thisHandValue = thisHandValue + iteratorThisHand.next().getValue();
        }
        
        Iterator<Card> iteratorCompare = handToCompare.hand.iterator();
        while(iteratorCompare.hasNext()){
            compareHandValue = compareHandValue + iteratorCompare.next().getValue();
        }

        return thisHandValue - compareHandValue;
    }
    
    public void sortBySuit(){
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
}
