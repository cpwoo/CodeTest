package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1114 {
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
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] pos = new int[K+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<K+1; i++) pos[i] = Integer.parseInt(st.nextToken());
        pos[K+1] = L;

        Arrays.sort(pos);

        int[] dist = new int[K+1];
        int maxDist = 0;
        for(int i=0; i<K+1; i++) {
            dist[i] = pos[i+1]-pos[i];
            maxDist = Math.max(maxDist, dist[i]);
        }

        int left = 1, right = L;

        int ret = 0, start = 0;

        while(left <= right) {
            int mid = (left+right)/2;
            if(maxDist > mid) left = mid+1;
            else {
                int tot = 0, cnt = 0;
                for(int i=K; i>=0; i--) {
                    tot += dist[i];
                    if(tot > mid) {
                        tot = dist[i];
                        cnt++;
                    }
                }
                if(cnt > C) left = mid+1;
                else {
                    right = mid-1;
                    ret = mid;
                    start = (cnt == C) ? tot : dist[0];
                }
            }
        }
        
        bw.write(ret+" "+start+"");
    }

}
