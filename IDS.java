package EightGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IDS {

    public static void search(Board init, Board end) {
        System.out.println("IDS");
        if (Board.isSolution(init, end)) GeneralSearchAlgorithm(init, end);
        else System.out.println("It is impossible to reach a solution");
    }

    private static void DepthLimitedSearch(Stack<Node> stack, Node cur, int depth, List<Node> visited) {
        if (cur.getDepth() == depth) return;

        Node next;
        if (cur.getBoard().CanMoveUp()) {
            next = new Node(cur.getBoard().moveUp(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, depth, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveRight()) {
            next = new Node(cur.getBoard().moveRight(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, depth, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveDown()) {
            next = new Node(cur.getBoard().moveDown(), cur,cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, depth, visited);
                visited.remove(next);
            }
        }
        if (cur.getBoard().CanMoveLeft()) {
            next = new Node(cur.getBoard().moveLeft(), cur, cur.getDepth()+1);
            if (!contains(visited, next)) {
                stack.add(next); visited.add(next);
                DepthLimitedSearch(stack, next, depth, visited);
                visited.remove(next);
            }
        }
    }

    private static void GeneralSearchAlgorithm(Board init, Board end) {
        int depth = 1;
        while (true) {
            Stack<Node> stack = new Stack<>();
            ArrayList<Node> visited = new ArrayList<>();

            Node first = new Node(init, 0);

            stack.add(first);
            visited.add(first);
            DepthLimitedSearch(stack, first, depth, visited);

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (Board.isEquals(end, node.getBoard())) {
                    while (node != null) {
                        System.out.println(node.getBoard() + "\n");
                        node = node.getParent();
                    }
                    System.out.println("Number of iterations: "+depth);
                    return;
                }
            }
            depth++;
        }
    }

    private static boolean contains(List<Node> list, Node node) {
        for (Node n : list) {
            if (Board.isEquals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }
}