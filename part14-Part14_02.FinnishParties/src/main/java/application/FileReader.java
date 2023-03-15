/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ste-PC
 */
public class FileReader {
    private ArrayList<Integer> years;
    private Map<String, Map<Integer, Double>> values;
    
    public FileReader(String file){
        this.years = new ArrayList<>();
        populateYears(file);
        this.values = new HashMap<>();
        populateSeries(file);
    }    
    
 
    private void populateYears(String file){
        try(Scanner scanner = new Scanner(Paths.get(file))){
            String[] parts = scanner.nextLine().split("\t");
            for (int i = 1; i < parts.length; i++){
                years.add(Integer.valueOf(parts[i]));
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void populateSeries(String file){
        try(Scanner scanner = new Scanner(Paths.get(file))){
           scanner.nextLine(); //call next line to discard the first line of the file
           while (scanner.hasNextLine()) {
               String nextRow = scanner.nextLine();
               String[] parts = nextRow.split("\t");
               Map<Integer, Double> dataSeries = new HashMap<>();
               for(int i = 1; i < parts.length; i++){
                   if(!parts[i].equals("-")){
                       dataSeries.put(years.get(i-1),Double.valueOf(parts[i]));
                   }
               }
               values.put(parts[0], dataSeries); 
           }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private ArrayList<Integer> getYears(){
        return this.years;
    }
    
    public Map<String, Map<Integer, Double>> getSeries(){
        return this.values;
    }
        
}
