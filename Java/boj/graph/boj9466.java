package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj9466 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int numbers[], cnt;
    private static boolean visited[];
    private static List<Integer> cycle;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        numbers = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) numbers[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        visited[0] = true;

        cnt = 0;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                cycle = new ArrayList<>();
                dfs(i);
            }
        }

        sb.append(n-cnt).append('\n');
    }

    private static void dfs(int x) {
        visited[x] = true;
        cycle.add(x);
        
        int number = numbers[x];

        if(visited[number]) {
            if(cycle.contains(number)) {
                cnt += cycle.size()-cycle.indexOf(number);
            }
            return;
        }
        else dfs(number);
    }

}
