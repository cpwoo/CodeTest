package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj12931 {
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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(true) {
            int sum = 0;
            for(int i=0; i<n; i++) sum += arr[i];
            if(sum == 0) break;

            boolean chk = false;
            for(int i=0; i<n; i++) {
                if(arr[i] == 0) continue;
                if(arr[i]%2 == 1) {
                    arr[i]--;
                    cnt++;
                    chk = true;
                }
            }
            if(!chk) {
                for(int i=0; i<n; i++) arr[i] /= 2;
                cnt++;
            }
        }

        bw.write(cnt+"");
    }
}
