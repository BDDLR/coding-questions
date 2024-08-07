import java.util.*;

public class OneDimensionalCheckers {

    public static void validMoves(String[] startArray, String[] endArray) {
        //Switch to lists to make it easier
        var start = List.of(startArray);
        var end = List.of(endArray);
        Queue<List<String>> queue = new LinkedList<>();
        Set<List<String>> visited = new HashSet<>();
        Map<List<String>, List<String>> parentMap = new HashMap<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> current = queue.poll();

            if (current.equals(end)) {
                printSolution(parentMap, current);
                return;
            }

            List<List<String>> nextMoves = generateNextMoves(current);
            for (List<String> nextMove : nextMoves) {
                if (!visited.contains(nextMove)) {
                    queue.offer(nextMove);
                    visited.add(nextMove);
                    parentMap.put(nextMove, current);
                }
            }
        }

        System.out.println("None");

    }

    private static List<List<String>> generateNextMoves(List<String> current) {
        List<List<String>> nextMoves = new ArrayList<>();

        for (int i = 0; i < current.size(); i++) {
            String tile = current.get(i);
            if (tile.equals("R")) {
                if (i < current.size() - 1 && current.get(i + 1).equals("_")) {
                    List<String> nextMove = new ArrayList<>(current);
                    nextMove.set(i, "_");
                    nextMove.set(i + 1, "R");
                    nextMoves.add(nextMove);
                } else if (i < current.size() - 2 && current.get(i + 1).equals("B") && current.get(i + 2).equals("_")) {
                    List<String> nextMove = new ArrayList<>(current);
                    nextMove.set(i, "_");
                    nextMove.set(i + 2, "R");
                    nextMoves.add(nextMove);
                }
            } else if (tile.equals("B")) {
                if (i > 0 && current.get(i - 1).equals("_")) {
                    List<String> nextMove = new ArrayList<>(current);
                    nextMove.set(i, "_");
                    nextMove.set(i - 1, "B");
                    nextMoves.add(nextMove);
                } else if (i > 1 && current.get(i - 1).equals("R") && current.get(i - 2).equals("_")) {
                    List<String> nextMove = new ArrayList<>(current);
                    nextMove.set(i, "_");
                    nextMove.set(i - 2, "B");
                    nextMoves.add(nextMove);
                }
            }
        }

        return nextMoves;
    }

    private static void printSolution(Map<List<String>, List<String>> parentMap, List<String> end) {
        List<List<String>> path = new ArrayList<>();
        List<String> current = end;

        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);

        if(path.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (List<String> p : path) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        String[] start_1 = { "R", "_", "B", "B" };
        String[] end_1 = { "B", "_", "B", "R" };

        String[] start_2 = { "R", "R", "_", "_" };
        String[] end_2 = { "_", "_", "R", "R" };

        String[] start_3 = { "R", "B", "_" };
        String[] end_3 = { "B", "R", "_" };

        String[] start_4 = { "_", "B", "B" };
        String[] end_4 = { "B", "B", "_" };

        String[] start_5 = { "R", "R", "B" };
        String[] end_5 = { "B", "R", "_" };

        String[] start_6 = { "_", "R", "_" };
        String[] end_6 = { "B", "R", "_" };

        String[] start_7 = { "B", "_", "R" };
        String[] end_7 = { "R", "_", "B" };

        String[] start_8 = { "_", "R", "R", "B" };
        String[] end_8 = { "B", "R", "R", "_" };

        System.out.println("\nTest case #1");
        validMoves(start_1, end_1);
        System.out.println("\nTest case #2");
        validMoves(start_2, end_2);
        System.out.println("\nTest case #3");
        validMoves(start_3, end_3);
        System.out.println("\nTest case #4");
        validMoves(start_4, end_4);
        System.out.println("\nTest case #5");
        validMoves(start_5, end_5);
        System.out.println("\nTest case #6");
        validMoves(start_6, end_6);
        System.out.println("\nTest case #7");
        validMoves(start_7, end_7);
        System.out.println("\nTest case #8");
        validMoves(start_8, end_8);
        
    }
}
