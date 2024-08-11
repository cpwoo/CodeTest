package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj1027 {
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

        int ret = 0;

        for(int i=0; i<n; i++) {
            int tmp = 0;
            double left = 1_000_000_000, right = -1_000_000_000;

            for(int j=i-1; j>=0; j--) {
                double c = calc(i+1, arr[i], j+1, arr[j]);
                if(c < left) {
                    left = c;
                    tmp++;
                }
            }

            for(int j=i+1; j<n; j++) {
                double c = calc(i+1, arr[i], j+1, arr[j]);
                if(c > right) {
                    right = c;
                    tmp++;
                }
            }

            ret = Math.max(ret, tmp);
        }

        bw.write(ret+"");
    }

    private static double calc(int x1, int y1, int x2, int y2) {
        return (double) (y2-y1)/(x2-x1);
    }

}
