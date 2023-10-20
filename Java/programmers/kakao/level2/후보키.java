package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 후보키 {
    static List<String> cand = new ArrayList<>();

    public int solution(String[][] relation) {
        for (int i=0; i<relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i+1, relation);
        }
        return cand.size();
    }

    private static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> arr = new ArrayList<>();
            String key = "";
            
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    arr.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (int i=0; i<relation.length; i++) {
                String s = "";
                for (Integer j : arr) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) return;
                else map.put(s, 0);
            }

            for (String c : cand) {
                int cnt = 0;
                for (int i=0; i<key.length(); i++) {
                    String sub = String.valueOf(key.charAt(i));
                    if (c.contains(sub)) cnt++;
                }
                if (cnt == c.length()) return;
            }
            cand.add(key);
            return;
        }

        for (int i=start; i<visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth+1, end, relation);
            visited[i] = false;
        }
    }
}
