
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LiquidContainer first = new LiquidContainer();
        LiquidContainer second = new LiquidContainer();

        while (true) {
            //System.out.print("> ");
            System.out.println("First: " + first.getAmount() + "/100");
            System.out.println("Second: " + second.getAmount() + "/100");

            String input = scan.nextLine();
            String[] commandParts = input.split(" ");
            if (input.equals("quit")) {
                break;
            } else if (commandParts[0].equals("add")) {
                first.add(Integer.valueOf(commandParts[1]));
            } else if (commandParts[0].equals("move")) {
                int moveAmount = Integer.valueOf(commandParts[1]);
                if (moveAmount > first.getAmount()){
                    moveAmount = first.getAmount();
                }
                first.remove(moveAmount);
                second.add(moveAmount);
            } else if (commandParts[0].equals("remove")){
                second.remove(Integer.valueOf(commandParts[1]));
            }
        }

    }
}