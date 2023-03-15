
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {
        //ArrayList<ArrayList<String>> rows = new ArrayList<>();
        
        try{
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(part -> part.length >= 6)
                    .sorted((p1,p2) -> {
                                    return p1[5].compareTo(p2[5]);
                    })
                    .forEach(p -> System.out.println(p[3] + " (" + p[4] + "), " + p[2].trim().split(" ")[0] + ", " + p[5]));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
