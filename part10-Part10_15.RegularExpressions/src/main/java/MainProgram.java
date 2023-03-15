

public class MainProgram {

    public static void main(String[] args) {
        Checker checker = new Checker();
        
        //boolean result = checker.isDayOfWeek("sun");
        //boolean result = checker.allVowels("oi");
        boolean result = checker.timeOfDay("15:23:05");
        System.out.println(result);
    }
}
