import java.util.*;

public class AStar {
    private static int heuristic;

    public static void search(Board init, Board end, Scanner stdin) {
        System.out.println("A STAR");
        if (Board.isSolution(init, end)) {
            System.out.print("Which heuristic do you want to use? Summation of the misplaced pieces (1) or Manhattan distance (2) ");
            heuristic = stdin.nextInt();
            GeneralSearchAlgorithm(init, end);
        }
        else System.out.println("That's impossible");
    }

    public static Node AStarAlgorithm(Node init, Board end) {
        ArrayList<Node> visited = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        minHeap.add(init);

        while (true) {
            Node cur = minHeap.remove();
            visited.add(cur);

            if (Board.isEquals(end, cur.getBoard())) return cur;

            if (cur.getBoard().CanMoveUp()) {
                Node next = new Node(cur.getBoard().moveUp(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    next.setCost(cost(next, end));
                    minHeap.add(next);
                }
            }
            if (cur.getBoard().CanMoveRight()) {
                Node next = new Node(cur.getBoard().moveRight(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    next.setCost(cost(next, end));
                    minHeap.add(next);
                }
            }
            if (cur.getBoard().CanMoveDown()) {
                Node next = new Node(cur.getBoard().moveDown(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    next.setCost(cost(next, end));
                    minHeap.add(next);
                }
            }
            if (cur.getBoard().CanMoveLeft()) {
                Node next = new Node(cur.getBoard().moveLeft(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    next.setCost(cost(next, end));
                    minHeap.add(next);
                }
            }
        }
    }

    private static void GeneralSearchAlgorithm(Board init, Board end) {
        Node first = new Node(init, 0);
        first.setCost(cost(first, end));

        Node node = AStarAlgorithm(first, end);

        int depth = node.getDepth();
        while (node != null) {
            System.out.println(node.getBoard() + "\n");
            node = node.getParent();
        }
        System.out.println("Number of iterations: "+depth);
    }

    private static int cost(Node cur, Board end) {
        if (cur.getParent() == null) return SummationDifferent(cur.getBoard(), end);
        if (heuristic == 1) return Math.max(cost(cur.getParent(), end), cur.getDepth() + SummationDifferent(cur.getBoard(), end));
        else return Math.max(cost(cur.getParent(), end), cur.getDepth() + ManhattanDistance(cur.getBoard(), end));
    }

    private static int SummationDifferent(Board init, Board end) {
        int len = init.getLen();

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (init.getMatrix()[i][j] != end.getMatrix()[i][j]) sum++;
            }
        }

        return sum;
    }

    private static int ManhattanDistance(Board init, Board end) {
        int len = init.getLen();
        int sum = 0;
        for (int i1 = 0; i1 < len; i1++) {
            for (int j1 = 0; j1 < len; j1++) {
                for (int i2 = 0; i2 < len; i2++) {
                    for (int j2 = 0; j2 < len; j2++) {
                        if (init.getMatrix()[i1][j1] == end.getMatrix()[i2][j2]) sum += Math.abs(i1-i2) + Math.abs(j1-j2);
                    }
                }
            }
        }
        return sum;
    }

    private static boolean contains(List<Node> list, Node node) {
        for (Node n : list) {
            if (Board.isEquals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }

}
