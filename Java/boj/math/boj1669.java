package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1669 {
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
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long d = 0, D = Y-X;

        int cnt = 0, move = 1;

        while(d < D) {
            cnt++;
            d += move;
            if(cnt%2 == 0) move++;
        }

        bw.write(cnt+"");
    }

}
