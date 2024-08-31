package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj27172 {
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
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] loc = new int[1000001];
        Arrays.fill(loc, -1);

        int[] cnt = new int[n];

        for(int i=0; i<n; i++) loc[arr[i]] = i;

        for(int i=0; i<n; i++) {
            for(int j=arr[i]; j<1000001; j+=arr[i]) {
                if(loc[j] != -1) {
                    cnt[loc[j]]--;
                    cnt[i]++;
                }
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(cnt[i]).append(' ');

        bw.write(sb.toString());
    }

}
