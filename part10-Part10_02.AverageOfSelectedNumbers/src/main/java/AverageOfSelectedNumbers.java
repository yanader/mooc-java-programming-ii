
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> inputs = new ArrayList<>();
        
        while(true){
            String input = scanner.nextLine();
            if(input.equals("end")){
                break;
            }
            inputs.add(input);
        }
        
        System.out.println("Print the average of the negative numbers of the positive numbers? (n/p)");
        String response = scanner.nextLine();
        
        double average;
        String textOutput;
        
        if(response.equals("n")){
            average = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(s -> s < 0).average().getAsDouble();
            textOutput = "negative";
        } else {
            average = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(s -> s > 0).average().getAsDouble();
            textOutput = "positive";
        }
        
        System.out.println("Average of the " + textOutput + " numbers: " + average);
    }
}
