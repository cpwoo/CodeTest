package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj11400 {
    static class Node implements Comparable<Node> {
        int p, q;
        Node(int min, int max) {
            this.p = min;
            this.q = max;
        }

        @Override
        public int compareTo(Node o) {
            if(this.p != o.p) return this.p-o.p;
            return this.q-o.q;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Integer> graph[];
    private static int nums[], num;
    private static List<Node> ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v+1];
        for(int i=0; i<v+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        nums = new int[v+1];
        num = 0;
        ret = new ArrayList<>();
        for(int i=1; i<v+1; i++) {
            if(nums[i] == 0) dfs(i, 1);
        }

        Collections.sort(ret);

        sb = new StringBuilder();
        sb.append(ret.size()).append('\n');

        for(Node r : ret) {
            sb.append(r.p).append(' ').append(r.q).append('\n');
        }

        bw.write(sb.toString());
    }

    private static int dfs(int cur, int parent) {
        num++;
        nums[cur] = num;

        int tmp = nums[cur];

        for(int nxt : graph[cur]) {
            if(nxt == parent) continue;

            if(nums[nxt] == 0) {
                int min = dfs(nxt, cur);
                if(min > nums[cur]) {
                    ret.add(new Node(Math.min(cur, nxt), Math.max(cur, nxt)));
                }
                tmp = Math.min(tmp, min);
            }
            else tmp = Math.min(tmp, nums[nxt]);
        }

        return tmp;
    }
}
