package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj8983 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        TreeSet<Integer> ts = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        int x, y, left, right;
        Integer higher;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            left = Math.max(x-(L-y), 0)-1;
            right = Math.min(x+(L-y), 1_000_000_000);

            higher = ts.higher(left);
            if(higher != null && higher <= right) cnt++;
        }

        bw.write(cnt+"");
    }
}
