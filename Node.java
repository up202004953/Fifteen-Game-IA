public class Node implements Comparable<Node> {
    private Board board;
    private Node parent;
    private int depth;
    private int fcost;

    Node(Board init, int depth) {
        this.board = init;
        this.parent = null;
        this.depth = depth;
        this.fcost = 0;
    }

    Node(Board init, int depth, int fcost) {
        this.board = init;
        this.parent = null;
        this.depth = depth;
        this.fcost = fcost;
    }

    Node(Board board, Node parent, int depth) {
        this.board = board;
        this.parent = parent;
        this.depth = depth;
        this.fcost = 0;
    }

    Node(Board board, Node parent, int depth, int fcost) {
        this.board = board;
        this.parent = parent;
        this.depth = depth;
        this.fcost = fcost;
    }

    public Board getBoard() {return board;}
    public Node getParent() {return parent;}
    public int getDepth() {return depth;}
    public int getFcost() {return fcost;}

    public void setFcost(int fcost) { this.fcost = fcost;}

    @Override
    public String toString() {
        return board+"";
    }

    @Override
    public int compareTo(Node o) {
        return fcost - o.getFcost();
    }
}
