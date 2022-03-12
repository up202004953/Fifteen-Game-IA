import java.util.ArrayList;

public class Board {
    private int[][] matrix;
    private int posX; int posY; //(PosX, PosY) represents the blank's position
    private final int len;

    public Board(int[][] matrix, int posX, int posY, int len) {
        this.matrix = matrix;
        this.posX = posX;
        this.posY = posY;
        this.len = len;
    }

    public int[][] getMatrix() {return matrix;}
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public int getLen() {return len;}
    
    private boolean moveLeft() {
        if (posX == 0) return false;

        int aux = matrix[posY][posX];
        matrix[posY][posX] = matrix[posY][posX-1];
        matrix[posY][--posX] = aux;

        return true;
    }

    private boolean moveRight() {
        if (posX == len-1) return false;

        int aux = matrix[posY][posX];
        matrix[posY][posX] = matrix[posY][posX+1];
        matrix[posY][++posX] = aux;
        return true;
    }

    private boolean moveUp() {
        if (posY == 0) return false;

        int aux = matrix[posY][posX];
        matrix[posY][posX] = matrix[posY-1][posX];
        matrix[--posY][posX] = aux;
        return true;
    }

    private boolean moveDown() {
        if (posY == len-1) return false;

        int aux = matrix[posY][posX];
        matrix[posY][posX] = matrix[posY+1][posX];
        matrix[++posY][posX] = aux;
        return true;
    }

    public int inversion() {
        int sum = 0;

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (matrix[i][j] != 0) array.add(matrix[i][j]);

        for (int i = 0; i < array.size()-1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) > array.get(j)) sum++;
            }
        }

        return sum;
    }

    static boolean isSolution(Board init, Board end) {
        return ((init.inversion()%2 == 0) == init.isOdd()) == ((end.inversion()%2 == 0) == end.isOdd());
    }

    public boolean isOdd() {
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (matrix[i][j] == 0) return (len - i) % 2 == 1;

        return false;
    }

    @Override
    public String toString() {
        StringBuilder bfr = new StringBuilder("");

        for (int i = 0; i < len; i++) {
           for (int j = 0; j < len; j++) {
               bfr.append(" ").append(matrix[i][j]);
           }
           bfr.append("\n");
        }

        return bfr.toString();
    }
}
