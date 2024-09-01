package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj1756 {
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
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] oven = new int[d];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<d; i++) oven[i] = Integer.parseInt(st.nextToken());

        int[] pizza = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) pizza[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<d; i++) {
            if(oven[i] > oven[i-1]) oven[i] = oven[i-1];
        }

        int idx = 0;
        for(int i=d-1; i>=0; i--) {
            if(pizza[idx] <= oven[i]) idx++;

            if(idx == n) {
                bw.write(i+1+"");
                break;
            }
        }
        
        if(idx != n) bw.write(0+"");
    }

}
