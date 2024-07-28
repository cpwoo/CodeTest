package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj16938 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, L, R, X, ret, arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        ret = 0;

        pick();
        
        bw.write(ret+"");
    }

    private static void pick() {
        int cnt, left, right, sum;
        for(int i=1; i<(1<<N); i++) {
            cnt = 0; 
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
            sum = 0;
            for(int j=0; j<N; j++) {
                if((i&(1<<j)) > 0) {
                    cnt++;
                    left = Math.min(left, arr[j]);
                    right = Math.max(right, arr[j]);
                    sum += arr[j];
                }
            }

            if(cnt < 2 || sum<L || sum>R || right-left<X) continue;

            ret++;
        }
    }

}
