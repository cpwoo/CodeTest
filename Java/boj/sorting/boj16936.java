package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj16936 {
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

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());

        List<long[]> ans = new ArrayList<>();
        for(long a : arr) {
            long cnt = 0;
            long tmp = a;
            while(tmp%3 ==0) {
                cnt++;
                tmp /= 3;
            }
            ans.add(new long[]{cnt, a});
        }

        ans.sort((t1, t2) -> {
            if (t1[0] != t2[0]) return Long.compare(t2[0], t1[0]);
            return Long.compare(t1[1], t2[1]);
        });

        sb = new StringBuilder();
        for(int i=0; i<ans.size(); i++) sb.append(ans.get(i)[1]).append(' ');

        bw.write(sb.toString());
    }

}
