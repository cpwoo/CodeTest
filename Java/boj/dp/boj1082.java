package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1082 {
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
        int[] p = new int[n];

        int min = Integer.MAX_VALUE, idx = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if(min >= p[i]) {
                min = p[i];
                idx = i;
            }
        }
        int m = Integer.parseInt(br.readLine());

        int size = m/min;
        int[] tmp = new int[size];
        Arrays.fill(tmp, idx);

        m -= min*size;
        int start = 0;
        for(int i=0; i<size; i++) {
            for(int j=n-1; j>=0; j--) {
                if(p[j] <= m+min) {
                    tmp[i] = j;
                    m += min-p[j];
                    break;
                }
            }
            if(tmp[start] == 0) {
                start++;
                m += min;
            }
        }
        if(start == size) {
            bw.write(0+"");
            return;
        }

        sb = new StringBuilder();
        for(int i=start; i<size; i++) {
            sb.append(tmp[i]);
        }

        bw.write(sb.toString());
    }

}
