package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj20055 {
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

        int[] arr = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[2*n];

        int[] move = new int[2*n];
        move[0] = 2*n-1;
        for(int i=1; i<2*n; i++) move[i] = i-1;

        int ret = 0;

        int start = 0, end = n-1, zero = 0;

        while(true) {
            ret++;

            start--; end--;
            if(start < 0) start = 2*n-1;
            if(end < 0) end = 2*n-1;
            if(visited[end]) visited[end] = false;

            int tmp = end;
            while(tmp != start) {
                int i = move[tmp];
                if(visited[i] && !visited[tmp] && arr[tmp] > 0) {
                    visited[i] = false;
                    visited[tmp] = true;
                    arr[tmp]--;
                    if(arr[tmp] == 0) zero++;
                    if(end == tmp) visited[tmp] = false;
                }
                tmp = i;
            }

            if(arr[start] > 0) {
                visited[start] = true;
                arr[start]--;
                if(arr[start] == 0) zero++;
            }

            if(zero >= k) break;
        }

        bw.write(ret+"");
    }

}
