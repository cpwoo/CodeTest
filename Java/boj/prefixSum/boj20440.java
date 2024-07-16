package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj20440 {
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
        int[] enter = new int[n];
        int[] exit = new int[n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            enter[i] = Integer.parseInt(st.nextToken());
            exit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(enter);
        Arrays.sort(exit);

        int e = 0, x = 0, max = 0, cnt = 0;
        int[] gap = new int[2];
        int t = 0;
        while(true) {
            while(e < n && enter[e] == t) {
                cnt++; e++;
            }
            if(gap[1] == 0 && cnt == max) gap[1] = t;

            while(x < n && exit[x] == t) {
                cnt--; x++;
            }
            if(cnt > max) {
                max = cnt; gap[0] = t; gap[1] = 0;
            }

            if(e >= n && x >= n) break;
            if(e < n) t = Math.min(enter[e], exit[x]);
            else t = exit[x];
        }

        bw.write(max+"\n");
        bw.write(gap[0]+" "+gap[1]+"");
    }

}
