
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i = 0; i < this.square.length; i++){
            int sum = 0;
            for(int j = 0; j < this.square[i].length; j++){
                sum += square[i][j];
            }
            returnList.add(sum);
        }
        //loop over every row using this.square.length
            //within that loop, initialise a variable sum and set to 0
            //loop over every column using square[row].length and add them all together...sum += value
            //add the total to the returnList
        //original loop starts again
        //once loop breaks, return the populated list
        return returnList;
    }

    public ArrayList<Integer> sumsOfColumns() {
        // this is exactly the same as the implementation of sumOfRows except we reverse the  use of i and j when adding to sum. 
        // it's possible that this might not work for 2d arrays that have more rows than columns (or vice versa) but it works for a square
        ArrayList<Integer> returnList = new ArrayList<>();
        for(int i = 0; i < this.square.length; i++){
            int sum = 0;
            for(int j = 0; j < this.square[i].length; j++){
                sum += this.square[j][i];
            }
            returnList.add(sum);
        }
        return returnList;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList returnList = new ArrayList<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < this.square.length; i++){
            for(int j = 0; j < this.square[i].length; j++){
                if(i == j){
                    sum1 += this.square[i][j];
                }
                if(i + j == square.length - 1){ //length - 1 because the square is 3 wide but we are used 0 indexing
                    sum2 += this.square[i][j];
                }
            }
        }
        returnList.add(sum1);
        returnList.add(sum2);
        return returnList;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }
    
    public boolean upAndRightIsEmpty(int y, int x){
        int newRow = x - 1;
        int newCol = y + 1;
        if(newRow < 0){
            newRow = this.getWidth() - 1;
        }
        if(newCol > this.getHeight() - 1){
            newCol = 0;
        }
        if(this.readValue(newCol,newRow) == 0){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
