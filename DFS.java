package EightGame;

import java.util.*;

public class DFS {
    private static final int MAX = 20;

    public static void search(Board init, Board end) {
        System.out.println("DFS");
        if (Board.isSolution(init, end)) GeneralSearchAlgorithm(init, end);
        else System.out.println("That's impossible");
    }

    private static void DepthLimitedSearch(Stack<Node> stack, Node cur, Board end, List<Node> visited) {
        if (Board.isEquals(end, cur.getBoard())) return;

        if (cur.getDepth() == MAX) return;

        Node next;
        if (cur.getBoard().CanMoveUp()) {
            next = new Node(cur.getBoard().moveUp(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, end, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveRight()) {
            next = new Node(cur.getBoard().moveRight(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, end, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveDown()) {
            next = new Node(cur.getBoard().moveDown(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, end, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveLeft()) {
            next = new Node(cur.getBoard().moveLeft(), cur, cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, end, visited);
                visited.remove(next);
            }
        }
    }

    private static void GeneralSearchAlgorithm(Board init, Board end) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();

        Node first = new Node(init, 0);

        stack.add(first);
        visited.add(first);
        DepthLimitedSearch(stack, first, end, visited);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            int depth = node.getDepth();
            if (Board.isEquals(end, node.getBoard())) {
                while (node != null) {
                    System.out.println(node.getBoard() + "\n");
                    node = node.getParent();
                }
                System.out.println("Number of iterations: "+depth);
                return;
            }
        }
    }

    private static boolean contains(List<Node> list, Node node) {
        for (Node n : list) {
            if (Board.isEquals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }
}
