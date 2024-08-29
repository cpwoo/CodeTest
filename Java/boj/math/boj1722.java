package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1722 {
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

        boolean[] visited = new boolean[n+1];
        long[] fact = new long[n];
        fact[0] = 1;
        for(int i=1; i<n; i++) fact[i] = fact[i-1]*i;

        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        if(st.nextToken().equals("1")) {
            long k = Long.parseLong(st.nextToken())-1;
            for(int i=n; i>0; i--) {
                long order = k/fact[i-1]+1;
                k %= fact[i-1];
                long cnt = 0;
                int idx = 0;
                while(cnt != order) {
                    idx++;
                    if(!visited[idx]) cnt++;
                }
                visited[idx] = true;
                sb.append(idx).append(' ');
            }
        }
        else {
            long k = 1;
            for(int i=n; i>0; i--) {
                int num = Integer.parseInt(st.nextToken());
                int cnt = 0, idx = 0;
                while(idx != num) {
                    idx++;
                    if(!visited[idx]) cnt++;
                }
                visited[idx] = true;
                k += (cnt-1)*fact[i-1];
            }
            sb.append(k);
        }

        bw.write(sb.toString());
    }

}
