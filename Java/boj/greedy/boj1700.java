package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1700 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int INF = 1000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] tab = new int[n];
        int[] item = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) item[i] = Integer.parseInt(st.nextToken());

        int used = 0, cnt = 0;
        for(int i=0; i<k; i++) {
            int idx = index(tab, 0, n, item[i]);
            
            if(idx != INF) continue;
            
            if(used < n) {
                tab[used++] = item[i];
                continue;
            }

            cnt++;
            int max = -1, p = -1;
            for(int j=0; j<n; j++) {
                idx = index(item, i+1, k, tab[j]);
                if(max < idx) {
                    max = idx;
                    p = j;
                }
            }
            tab[p] = item[i];
        }

        bw.write(cnt+"");
    }

    private static int index(int[] arr, int start, int end, int val) {
        for(int i=start; i<end; i++) {
            if(arr[i] == val) return i;
        }
        return INF;
    }

}
