package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 일이삼떨어트리기 {
    public int[] solution(int[][] edges, int[] target) {
        int n = edges.length+1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]-1).add(edge[1]-1);
        }

        for (int i=0; i<n; i++) {
            Collections.sort(adj.get(i));
        }

        int T = 0;
        for (int i=0; i<n; i++) {
            if (adj.get(i).isEmpty() && target[i] != 0) T++;
        }

        int[] pos = new int[n];
        int[] cnt = new int[n];
        int[] C = new int[n];

        List<Integer> q = new ArrayList<>();
        while (T != 0) {
            int cur = 0;
            while (!adj.get(cur).isEmpty()) {
                pos[cur]++;
                cur = adj.get(cur).get((pos[cur]-1)%(adj.get(cur).size()));
            }
            cnt[cur]++;
            q.add(cur);
            if (cnt[cur] > target[cur]) return new int[]{-1};
            if (C[cur] == 0 && target[cur] <= 3*cnt[cur]) {
                C[cur] = 1;
                T--;
            }
        }

        int[] answer = new int[q.size()];

        int idx = 0;
        for (Integer i : q) {
            cnt[i]--;
            for (int v=1; v<=3; v++) {
                if (cnt[i] <= target[i]-v && target[i]-v <= 3*cnt[i]) {
                    answer[idx++] = v;
                    target[i] -= v;
                    break;
                }
            }
        }

        return answer;
    }
}
