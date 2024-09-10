package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2617 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static boolean visited[];
    private static int cnt;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> bigger[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) bigger[i] = new ArrayList<>();

        List<Integer> smaller[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) smaller[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bigger[b].add(a);
            smaller[a].add(b);
        }

        int mid = (N+1)/2, ret = 0;

        for(int i=1; i<N+1; i++) {
            visited = new boolean[N+1];

            cnt = 0;
            dfs(bigger, i);
            if(cnt >= mid) ret++;

            cnt = 0;
            dfs(smaller, i);
            if(cnt >= mid) ret++;
        }

        bw.write(ret+"");
    }

    private static void dfs(List<Integer>[] arr, int n) {
        for(int i : arr[n]) {
            if(!visited[i]) {
                visited[i] = true;
                cnt++;
                dfs(arr, i);
            }
        }
    }

}
