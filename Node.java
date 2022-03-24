package EightGame;

import java.util.List;

public class Node implements Comparable<Node> {
    private Board board;
    private Node parent;
    private int depth;
    private int cost;

    Node(Board init, int depth) {
        this.board = init;
        this.parent = null;
        this.depth = depth;
        this.cost = 0;
    }

    Node(Board init, int depth, int cost) {
        this.board = init;
        this.parent = null;
        this.depth = depth;
        this.cost = cost;
    }

    Node(Board board, Node parent, int depth) {
        this.board = board;
        this.parent = parent;
        this.depth = depth;
        this.cost = 0;
    }

    Node(Board board, Node parent, int depth, int fcost) {
        this.board = board;
        this.parent = parent;
        this.depth = depth;
        this.cost = cost;
    }

    public Board getBoard() {return board;}
    public Node getParent() {return parent;}
    public int getDepth() {return depth;}

    public int getCost() {return cost;}

    public void setCost(int cost) {this.cost = cost;}

    @Override
    public String toString() {
        return board+"";
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.getCost();
    }
}
