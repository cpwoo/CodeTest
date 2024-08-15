package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj13422 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        if(n == m) {
            int sum = 0;
            for(int i=0; i<n; i++) sum += arr[i];
            sb.append((sum < k) ? 1 : 0).append('\n');
            return;
        }

        int cnt = 0;
        
        int money = 0;
        for(int i=0; i<m; i++) money += arr[i];
        if(money < k) cnt++;

        for(int i=1; i<n; i++) {
            money += arr[(i+m-1)%n]-arr[i-1];
            if(money < k) cnt++;
        }

        sb.append(cnt).append('\n');
    }

}
