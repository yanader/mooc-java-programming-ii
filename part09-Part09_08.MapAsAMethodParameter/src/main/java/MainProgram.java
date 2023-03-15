import java.util.Map;
import java.util.HashMap;

public class MainProgram {

    public static void main(String[] args) {
        Map<String, String> names = new HashMap<>();
        names.put("1", "first");
        names.put("2", "second");

        System.out.println(returnSize(names));

    }

    private static int returnSize(Map map){
        return map.size();
    }
}
