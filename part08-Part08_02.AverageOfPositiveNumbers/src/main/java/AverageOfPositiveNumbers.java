
import java.util.Scanner;
import java.util.ArrayList;
public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            if(input == 0){
                break;
            }
            if(input > 0){
                positiveNumbers.add(input);
            }
        }
        int sum = 0;
        for(int i : positiveNumbers){
            sum += i;
        }
        if(positiveNumbers.size() == 0){
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println((double)sum / positiveNumbers.size());
        }
        
    }
}
