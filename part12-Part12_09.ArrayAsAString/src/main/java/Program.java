
public class Program {

    public static void main(String[] args) {
        //int rows = 2;
        //int columns = 3;
        //int[][] matrix = new int[rows][columns];

        //matrix[0][1] = 5;
        //matrix[1][0] = 3;
        //matrix[1][2] = 7;
        
        int[][] matrix = {
        {3, 2, 7, 6},
        {2, 4, 1, 0},
        {3, 2, 1, 0}};
        
        //System.out.println(arrayAsString(matrix));
        System.out.println(matrix);
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                sb.append(array[row][col]);
            }
            sb.append("\n");
            
        }
        return sb.toString();
    }
}
