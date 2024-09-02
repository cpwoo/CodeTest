package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj14890 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, L, line[];

    private static boolean slope[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;

        for(int i=0; i<N; i++) {
            slope = new boolean[N];
            line = new int[N];
            for(int j=0; j<N; j++) line[j] = graph[i][j];
            if(chk()) ret++;
        }

        for(int j=0; j<N; j++) {
            slope = new boolean[N];
            line = new int[N];
            for(int i=0; i<N; i++) line[i] = graph[i][j];
            if(chk()) ret++;
        }

        bw.write(ret+"");
    }

    private static boolean chk() {
        for(int i=1; i<N; i++) {
            if(Math.abs(line[i]-line[i-1]) > 1) return false;

            if(line[i] < line[i-1]) {
                for(int j=0; j<L; j++) {
                    if(i+j >= N || line[i] != line[i+j] || slope[i+j]) return false;

                    if(line[i] == line[i+j]) slope[i+j] = true;
                }
            }
            else if(line[i] > line[i-1]) {
                for(int j=0; j<L; j++) {
                    if(i-j-1 < 0 || line[i-1] != line[i-j-1] || slope[i-j-1]) return false;

                    if(line[i-1] == line[i-j-1]) slope[i-j-1] = true;
                }
            }
        }
        return true;
    }

}
