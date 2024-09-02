package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj14719 {
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
        st.nextToken();
        int w = Integer.parseInt(st.nextToken());

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++) block[i] = Integer.parseInt(st.nextToken());

        int ret = 0;

        for(int i=1; i<w-1; i++) {
            int left = 0, right = 0;
            for(int j=0; j<i; j++) left = Math.max(left, block[j]);
            for(int j=i+1; j<w; j++) right = Math.max(right, block[j]);

            int compare = Math.min(left, right);

            if(block[i] < compare) ret += compare-block[i];
        }

        bw.write(ret+"");
    }

}
