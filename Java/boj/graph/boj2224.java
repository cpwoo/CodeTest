package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2224 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int x = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[58][58];
        int cnt = 0;

        for(int i=0; i<x; i++) {
            st = new StringTokenizer(br.readLine(), " => ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            if(a == b) continue;
            if(!arr[a-65][b-65]) {
                arr[a-65][b-65] = true;
                cnt++;
            }
        }

        for(int k=0; k<58; k++) for(int i=0; i<58; i++) for(int j=0; j<58; j++) {
            if(i != j && !arr[i][j] && arr[i][k] && arr[k][j]) {
                arr[i][j] = true;
                cnt++;
            }
        }

        sb = new StringBuilder();
        sb.append(cnt).append('\n');

        for(int i=0; i<58; i++) for(int j=0; j<58; j++) {
            if(arr[i][j]) sb.append(String.format("%c => %c", i+65, j+65)).append('\n');
        }

        bw.write(sb.toString());
    }

}
