package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        
        int[] parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1,o2) -> o1[2]-o2[2]);

        for (int[] c : costs) {
            int a = c[0], b = c[1], cost = c[2];
            if (find(parent, a) != find(parent, b)) {
                answer += cost;
                union(parent, a, b);
                cnt++;
            }
            if (cnt == n-1) break;
        }

        return answer;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        int pa = find(parent, a), pb = find(parent, b);
        parent[Math.max(pa,pb)] = Math.min(pa,pb);
    }
}
