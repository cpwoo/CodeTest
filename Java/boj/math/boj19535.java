package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj19535 {
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

        int[][] nodes = new int[n-1][2];
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) nodes[i][j] = Integer.parseInt(st.nextToken());
        }

        long[] degree = new long[n+1];
        for(int i=0; i<n-1; i++) for(int j=0; j<2; j++) {
            degree[nodes[i][j]]++;
        }

        long D = 0, G = 0;

        for(int i=0; i<n-1; i++) {
            D += (degree[nodes[i][0]]-1)*(degree[nodes[i][1]]-1);
        }

        for(int i=1; i<n+1; i++) {
            G += (degree[i] >= 3) ? degree[i]*(degree[i]-1)*(degree[i]-2)/6 : 0;
        }

        if(D > 3*G) bw.write("D");
        else if(D < 3*G) bw.write("G");
        else bw.write("DUDUDUNGA");
    }

}
