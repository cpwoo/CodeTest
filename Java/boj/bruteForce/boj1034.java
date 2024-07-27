package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1034 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] lamp = new int[n][m];
        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            for(int j=0; j<m; j++) {
                lamp[i][j] = inp.charAt(j)-'0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int[] i: lamp) {
            int tmp = 0;
            for(int idx=0; idx<m; idx++) {
                if(i[idx] == 0) tmp++;
            }
            if(tmp <= k && (tmp%2) == (k%2)) {
                int cnt = 0;
                for(int[] j: lamp) {
                    int p = 0;
                    for(int idx=0; idx<m; idx++) {
                        if(i[idx] == j[idx]) p++;
                    }
                    if(p == m) cnt++;
                }
                answer = Math.max(answer, cnt);
            }
        }

        bw.write(answer+"");
    }

}
