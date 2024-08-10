package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj16288 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());

        bw.flush();
        bw.close();
    }

    private static String solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] room = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            int x = 0;
            while(x < k) {
                if(room[x] < a) {
                    room[x] = a;
                    break;
                }
                x++;
            }
            if(x == k) {
                return "NO";
            }
        }

        return "YES";
    }

}
