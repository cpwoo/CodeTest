package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1033 {
    static class Ingredient {
        int nxt, p, q;
        Ingredient(int nxt, int p, int q) {
            this.nxt = nxt;
            this.p = p;
            this.q = q;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Ingredient> graph[];
    private static boolean[] visited;
    private static long[] ratio;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        visited = new boolean[n];
        ratio = new long[n];

        long lcm = 1;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Ingredient(b, p, q));
            graph[b].add(new Ingredient(a, q, p));

            lcm *= (p*q)/gcd(p,q);
        }

        ratio[0] = lcm;
        dfs(0);
        long m = ratio[0];

        for(int i=1; i<n; i++) m = gcd(m, ratio[i]);
        
        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(ratio[i]/m).append(' ');

        bw.write(sb.toString());
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for(Ingredient i : graph[cur]) {
            if(!visited[i.nxt]) {
                ratio[i.nxt] = ratio[cur]*i.q/i.p;
                dfs(i.nxt);
            }
        }
    }

}
