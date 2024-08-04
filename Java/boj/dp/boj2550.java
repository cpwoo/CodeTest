package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2550 {
    static class Picture implements Comparable<Picture> {
        int height, cost;
        Picture(int height, int cost) {
            this.height = height;
            this.cost = cost;
        }

        @Override
        public int compareTo(Picture picture) {
            if(this.height != picture.height) {
                return this.height-picture.height;
            }
            return this.cost-picture.cost;
        }
    }

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
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<Picture> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Picture(h, c));
        }

        Collections.sort(arr);

        int[] dp = new int[N];
        dp[0] = arr.get(0).cost;

        int idx = 0, val = 0;
        for(int i=1; i<N; i++) {
            while(arr.get(idx).height <= arr.get(i).height-S) {
                val = Math.max(val, dp[idx]);
                idx++;
            }
            dp[i] = val+arr.get(i).cost;
        }

        int ret = 0;
        for(int i=0; i<N; i++) ret = Math.max(ret, dp[i]);

        bw.write(ret+"");
    }

}
