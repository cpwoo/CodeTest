package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj18513 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] lake = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) lake[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> visited = new HashMap<>();

        for(int l : lake) {
            q.add(l);
            visited.put(l, 0);
        }

        while(!q.isEmpty() && k > 0) {
            int x = q.poll();

            for(int nx : new int[]{x-1, x+1}) {
                if(!visited.containsKey(nx) && k > 0) {
                    visited.put(nx, visited.get(x)+1);
                    k--;
                    q.add(nx);
                }
            }
        }

        long ret = 0;
        for(int key : visited.keySet()) ret += visited.get(key);

        bw.write(ret+"");
    }

}
