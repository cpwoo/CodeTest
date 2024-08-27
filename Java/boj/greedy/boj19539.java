package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj19539 {
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

        long s = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s += arr[i];
        }

        long turn = s/3;
    
        if(s%3 != 0) bw.write("NO");
        else {
            for(int a : arr) {
                turn -= a/2;
            }
            bw.write((turn > 0) ? "NO" : "YES");
        }
    }
}
