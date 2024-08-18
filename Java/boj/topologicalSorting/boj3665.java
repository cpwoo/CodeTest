package CodeTest.Java.boj.topologicalSorting;

import java.io.*;
import java.util.*;

public class boj3665 {
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
        int n = Integer.parseInt(br.readLine());
        int[] first = new int[n+1];
        int[] last = new int[n+1];
        int[] sorting = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            int x = Integer.parseInt(st.nextToken());
            first[x] = last[x] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(first[a] < first[b]) {
                last[a]++; last[b]--;
            }
            else {
                last[a]--; last[b]++;
            }
        }

        boolean flag = true;
        for(int i=1; i<n+1; i++) {
            if(sorting[last[i]] == 0) sorting[last[i]] = i;
            else {
                flag = false;
                sb.append("IMPOSSIBLE").append('\n');
                break;
            }
        }

        if(flag) {
            for(int i=1; i<n+1; i++) sb.append(sorting[i]).append(' ');
            sb.append('\n');
        }
    }

}
