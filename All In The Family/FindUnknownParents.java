import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUnknownParents {
    public static void main(String[] args) {
        int[][] pairs = new int[][] {
            {5, 6}, {1, 3}, {2, 3}, {3, 6}, {15, 12}, {5, 7}, 
            {4, 5}, {4, 9}, {9, 12}, {30, 16}
          };

          System.out.println(findNodesWithZeroAndOneParents(pairs));
    }

    private static List<List<Integer>> findNodesWithZeroAndOneParents(int [][] pairs) {
        var result = new ArrayList<List<Integer>>();
        var zeroParentList = new ArrayList<Integer>();
        var oneParentList = new ArrayList<Integer>();
        var dataSet = preprocessAllData(pairs);
        var parentCountMap = new HashMap<Integer, Integer>();

        for(int i=0; i<= pairs.length -1; i++) {
            var child = pairs[i][1];
            var tmpCount = 0;
            if(parentCountMap.containsKey(child)) {
                tmpCount = parentCountMap.get(child);
            }
            parentCountMap.put(child, tmpCount + 1);
        }

        dataSet.forEach(e -> {
            if(!parentCountMap.containsKey(e)) {
                zeroParentList.add(e);
            } else if(parentCountMap.containsKey(e) && parentCountMap.get(e) == 1) {
                oneParentList.add(e);
            }
        });

        result.add(zeroParentList);
        result.add(oneParentList);
        
        return result;
    }

    private static Set<Integer> preprocessAllData(int [][] pairs) {
        var set = new HashSet<Integer>();
        for(int i =0; i<=pairs.length -1; i++) {
            set.add(pairs[i][0]);
            set.add(pairs[i][1]);
        }
        return set;
    }
}
