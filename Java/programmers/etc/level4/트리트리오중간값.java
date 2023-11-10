package CodeTest.Java.programmers.etc.level4;

import java.util.*;

public class 트리트리오중간값 {
    private static Map<Integer, List<Integer>> tree;
    private static List<int[]> distance;
    private static Queue<int[]> q;
    private static Map<Integer, Boolean> visited;

    public int solution(int n, int[][] edges) {
        tree = new HashMap<>();
        for (int i=0; i<n; i++) {
            tree.put(i+1, new ArrayList<>());
        }

        for (int[] edge : edges) {
            List<Integer> u = tree.get(edge[0]);
            u.add(edge[1]);
            tree.put(edge[0], u);

            List<Integer> v = tree.get(edge[1]);
            v.add(edge[0]);
            tree.put(edge[1], v);
        }

        List<int[]> d1 = bfs(1);
        List<int[]> d2 = bfs(d1.get(d1.size()-1)[0]);

        boolean flag = d1.get(d1.size()-1)[1] == d1.get(d1.size()-2)[1];

        return flag ? d2.get(d2.size()-1)[1] : d2.get(d2.size()-2)[1];
    }

    private static List<int[]> bfs(int start) {
        distance = new ArrayList<>();

        q = new LinkedList<>();
        q.add(new int[]{start, 0});
        
        visited = new HashMap<>();
        visited.put(start, true);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            distance.add(cur);

            int cur_node = cur[0], cur_dist = cur[1];
            for (Integer nxt_node : tree.get(cur_node)) {
                if (!visited.containsKey(nxt_node)) {
                    q.add(new int[]{nxt_node, cur_dist+1});
                    visited.put(nxt_node, true);
                }
            }
        }

        return distance;
    }
}
