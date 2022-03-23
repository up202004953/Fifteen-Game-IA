import java.util.ArrayList;

public class Board {
    private final int[][] matrix;
    private final int posX; private final int posY; //(PosX, PosY) represents the blank's position
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

    public boolean CanMoveLeft() { return posX != 0; }

    public EightGame.Board moveLeft() {
        int[][] curMatrix = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                curMatrix[i][j] = matrix[i][j];

        int aux = curMatrix[posY][posX];
        curMatrix[posY][posX] = curMatrix[posY][posX-1];
        curMatrix[posY][posX-1] = aux;

        return new EightGame.Board(curMatrix, posX-1, posY, len);
    }

    public boolean CanMoveRight() {
        return posX != len - 1;
    }

    public EightGame.Board moveRight() {
        int[][] curMatrix = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                curMatrix[i][j] = matrix[i][j];

        int aux = curMatrix[posY][posX];
        curMatrix[posY][posX] = curMatrix[posY][posX+1];
        curMatrix[posY][posX+1] = aux;

        return new EightGame.Board(curMatrix, posX+1, posY, len);
    }

    public boolean CanMoveUp() {
        return posY != 0;
    }

    public EightGame.Board moveUp() {
        int[][] curMatrix = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                curMatrix[i][j] = matrix[i][j];

        int aux = curMatrix[posY][posX];
        curMatrix[posY][posX] = curMatrix[posY-1][posX];
        curMatrix[posY-1][posX] = aux;

        return new EightGame.Board(curMatrix, posX, posY-1, len);
    }

    public boolean CanMoveDown() {
        return posY != len-1;
    }

    public EightGame.Board moveDown() {
        int[][] curMatrix = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                curMatrix[i][j] = matrix[i][j];

        int aux = curMatrix[posY][posX];
        curMatrix[posY][posX] = curMatrix[posY+1][posX];
        curMatrix[posY+1][posX] = aux;

        return new EightGame.Board(curMatrix, posX, posY+1, len);
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

    static boolean isSolution(EightGame.Board init, EightGame.Board end) {
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

    public static Boolean isEquals(EightGame.Board a, EightGame.Board b) {
        if (a.getLen() != b.getLen()) return false;

        for (int i = 0; i < a.getLen(); i++)
            for (int j = 0; j < a.getLen(); j++)
                if (a.getMatrix()[i][j] != b.getMatrix()[i][j]) return false;

        return true;
    }
}
