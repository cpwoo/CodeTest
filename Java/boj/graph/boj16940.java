package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj16940 {
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
        int n = Integer.parseInt(br.readLine());

        List<Integer> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] d = new int[n];
        d[0] = 1;

        int last = 1, t = 2;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int cur = Integer.parseInt(st.nextToken())-1;

            if(i == 0 && cur != 0 || d[cur] < last) {
                bw.write("0");
                return;
            }

            last = d[cur];

            for(int nxt : graph[cur]) {
                if(d[nxt] == 0) d[nxt] = t;
            }

            t++;
        }

        bw.write("1");
    }

}
