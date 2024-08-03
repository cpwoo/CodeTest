package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2096 {
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

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        int[] maxTmp = new int[3];
        int[] minTmp = new int[3];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int j=0; j<3; j++) {
                if(j == 0) {
                    maxTmp[j] = a+Math.max(maxDP[j], maxDP[j+1]);
                    minTmp[j] = a+Math.min(minDP[j], minDP[j+1]);
                }
                else if(j == 1) {
                    maxTmp[j] = b+Math.max(maxDP[j-1], Math.max(maxDP[j], maxDP[j+1]));
                    minTmp[j] = b+Math.min(minDP[j-1], Math.min(minDP[j], minDP[j+1]));
                }
                else if(j == 2) {
                    maxTmp[j] = c+Math.max(maxDP[j-1], maxDP[j]);
                    minTmp[j] = c+Math.min(minDP[j-1], minDP[j]);
                }
            }

            for(int j=0; j<3; j++) {
                maxDP[j] = maxTmp[j];
                minDP[j] = minTmp[j];
            }
        }

        bw.write(Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]))+" ");
        bw.write(Math.min(minDP[0], Math.min(minDP[1], minDP[2]))+"");
    }

}
