import java.util.*;

public class BFS {
    public static void search(Board init, Board end) {
        System.out.println("BFS");
        if (Board.isSolution(init, end)) GeneralSearchAlgorithm(init, end);
        else System.out.println("That's impossible");
    }

    private static Node BreadthFirstSearch(Node init, Board end) {
        Deque<Node> queue = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();

        queue.add(init);
        visited.add(init);

        while (true) {
            Node cur = queue.removeFirst();

            if (Board.isEquals(end, cur.getBoard())) return cur;

            if (cur.getBoard().CanMoveUp()) {
                Node next = new Node(cur.getBoard().moveUp(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    queue.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveRight()) {
                Node next = new Node(cur.getBoard().moveRight(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    queue.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveDown()) {
                Node next = new Node(cur.getBoard().moveDown(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    queue.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveLeft()) {
                Node next = new Node(cur.getBoard().moveLeft(), cur,cur.getDepth()+1);
                if (!contains(visited, next)) {
                    queue.add(next); visited.add(next);
                }
            }
        }
    }

    private static void GeneralSearchAlgorithm(Board init, Board end) {
        Node node = BreadthFirstSearch(new Node(init, 0), end);

        int depth = node.getDepth();
        while (node != null) {
            System.out.println(node.getBoard() + "\n");
            node = node.getParent();
        }
        System.out.println("Number of iterations: "+depth);
    }

    private static boolean contains(List<Node> list, Node node) {
        for (Node n : list) {
            if (Board.isEquals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }
}
