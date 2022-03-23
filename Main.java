import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Reading Boards
        Scanner stdin = new Scanner(System.in);

        System.out.println("What's the line's length of the game?");
        int len = stdin.nextInt();

        int[][] matrix_init = new int[len][len];
        int posX_init = -1; int posY_init = -1;
        System.out.println("Write the numbers in a line of the initial state and represent the blank piece as a 0");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix_init[i][j] = stdin.nextInt();
                if (matrix_init[i][j] == 0) {posX_init = j; posY_init = i;}
            }
        }

        int[][] matrix_end = new int[len][len];
        int posX_end = -1; int posY_end = -1;
        System.out.println("Write the numbers in a line of the final state and represent the blank piece as a 0");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix_end[i][j] = stdin.nextInt();
            }
        }

        //Board Creation
        Board init = new Board(matrix_init, posX_init, posY_init,4);
        Board end = new Board(matrix_end, posX_end, posY_end,4);

        //AStar
        AStar.search(init, end, stdin);
        //BFS
        BFS.search(init, end);
        //DFS
        DFS.search(init, end);
        //IDS
        IDS.search(init, end);
        //Greedy
        Greedy.search(init, end, stdin);
    }
}