package EightGame;

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
        Board init = new Board(matrix_init, posX_init, posY_init,len);
        Board end = new Board(matrix_end, posX_end, posY_end,len);

        System.out.println("A* (1), BFS (2), DFS (3), IDS (4), GREEDY (5)");
        int n = stdin.nextInt();

        if (n == 1) AStar.search(init, end, stdin);
        else if (n == 2) BFS.search(init, end);
        else if (n == 3) DFS.search(init, end);
        else if (n == 4) IDS.search(init, end);
        else if (n == 5) Greedy.search(init, end, stdin);
    }
}