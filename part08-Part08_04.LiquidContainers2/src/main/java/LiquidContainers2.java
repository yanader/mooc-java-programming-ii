
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();
        
        while (true) {
            System.out.println("First: " + first.contains() + "/100");
            System.out.println("Second: " + second.contains() + "/100");
            
            String input = scan.nextLine();
            String[] command = input.split(" ");
            if (input.equals("quit")) {
                break;
            } else if (command[0].equals("add")){
                first.add(Integer.valueOf(command[1]));
            } else if (command[0].equals("move")){
                int moveAmount = Integer.valueOf(command[1]);
                if(moveAmount > first.contains()){
                    moveAmount = first.contains();
                }
                first.remove(moveAmount);
                second.add(moveAmount);
            } else if (command[0].equals("remove")){
                second.remove(Integer.valueOf(command[1]));
            }

        }
    }

}
