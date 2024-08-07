import java.util.*;

public class FindCommonAncestor {

    public static void main(String[] args) {
        int[][] pairs = new int[][] {
                { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 15, 21 },
                { 4, 8 }, { 4, 9 }, { 9, 11 }, { 14, 4 }, { 13, 12 }, { 12, 9 },
                { 15, 13 }
        };

        System.out.println(hasCommonAncestor(pairs, 3, 8)); // false
        System.out.println(hasCommonAncestor(pairs, 5, 8)); // true
        System.out.println(hasCommonAncestor(pairs, 6, 8)); // true
        System.out.println(hasCommonAncestor(pairs, 6, 9)); // true
        System.out.println(hasCommonAncestor(pairs, 1, 3)); // false
        System.out.println(hasCommonAncestor(pairs, 3, 1)); // false
        System.out.println(hasCommonAncestor(pairs, 7, 11)); // true
        System.out.println(hasCommonAncestor(pairs, 6, 5)); // true
        System.out.println(hasCommonAncestor(pairs, 5, 6)); // true
        System.out.println(hasCommonAncestor(pairs, 3, 6)); // true
        System.out.println(hasCommonAncestor(pairs, 21, 11)); // true
    }

    private static boolean hasCommonAncestor(int[][] pairs, int node1, int node2) {
        var graph = buildGraph(pairs);
        var ancestors1 = getAllAncestors(graph, node1);
        var ancestors2 = getAllAncestors(graph, node2);

        ancestors1.retainAll(ancestors2);

        if(ancestors1.size() > 0) {
            return true;
        }

        return false;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] pairs) {
        var graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i <= pairs.length - 1; i++) {
            var parent = pairs[i][0];
            var child = pairs[i][1];
            if (graph.containsKey(child)) {
                graph.get(child).add(parent);
            } else {
                graph.put(child, new ArrayList<Integer>());
                graph.get(child).add(parent);
            }
        }
        return graph;
    }

    private static Set<Integer> getAllAncestors(Map<Integer, List<Integer>> graph, int node) {
        Set<Integer> ancestors = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (graph.containsKey(current)) {
                for (int parent : graph.get(current)) {
                    ancestors.add(parent);
                    stack.push(parent);
                }
            }
        }

        return ancestors;
    }

}
