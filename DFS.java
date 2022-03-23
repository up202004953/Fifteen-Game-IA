import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    private static final int MAX = 20;

    public static void search(Board init, Board end) {
        System.out.println("DFS");
        if (Board.isSolution(init, end)) GeneralSearchAlgorithm(init, end);
        else System.out.println("That's impossible");
    }

    private static Node SearchDFS(Node init, Board end) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();

        stack.add(init);
        visited.add(init);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            if (cur.getDepth() == MAX) continue;

            if (Board.isEquals(end, cur.getBoard())) return cur;

            if (cur.getBoard().CanMoveLeft()) {
                Node next = new Node(cur.getBoard().moveLeft(), cur, cur.getDepth() + 1);
                if (!contains(visited, next)) {
                    stack.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveDown()) {
                Node next = new Node(cur.getBoard().moveDown(), cur, cur.getDepth() + 1);
                if (!contains(visited, next)) {
                    stack.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveRight()) {
                Node next = new Node(cur.getBoard().moveRight(), cur, cur.getDepth() + 1);
                if (!contains(visited, next)) {
                    stack.add(next); visited.add(next);
                }
            }
            if (cur.getBoard().CanMoveUp()) {
                Node next = new Node(cur.getBoard().moveUp(), cur, cur.getDepth() + 1);
                if (!contains(visited, next)) {
                    stack.add(next); visited.add(next);
                }
            }
        }

        return null;
    }

    private static void GeneralSearchAlgorithm(Board init, Board end) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();

        Node last = SearchDFS(new Node(init, 0), end);

        if (last == null)  {
            System.out.println("Not found");
            return;
        }

        int depth = last.getDepth();

        while (last != null) {
            System.out.println(last);
            last = last.getParent();
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
