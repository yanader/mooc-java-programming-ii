
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        int limit = size * size;
        int row = 0;
        int col = (size-1)/2;
        
        square.placeValue(col, row, 1); 
        
        
        for(int i = 2; i <= limit; i++){
            //next row is row-1
            if(square.upAndRightIsEmpty(col, row)){
                row--;
                col++;
                if(row < 0){
                    row = size-1;
                }
                if(col > size-1){
                    col = 0;
                }
            } else {
                row++;
                if(row > size - 1){
                    row = 0;
                }
            }
        square.placeValue(col, row, i); 
        }
        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }
    
    
}
