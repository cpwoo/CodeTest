package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2655 {
    static class Info implements Comparable<Info> {
        int idx, a, h, m;
        Info(int idx, int a, int h, int m) {
            this.idx = idx;
            this.a = a;
            this.h = h;
            this.m = m;
        }

        @Override
        public int compareTo(Info info) {
            return this.m-info.m;
        }
    }

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
        
        List<Info> arr = new ArrayList<>();
        arr.add(new Info(0, 0, 0, 0));
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr.add(new Info(i, a, h, m));
        }

        Collections.sort(arr);

        int[] dp = new int[n+1];

        for(int i=1; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                if(arr.get(j).a < arr.get(i).a) {
                    dp[i] = Math.max(dp[i], dp[j]+arr.get(i).h);
                }
            }
        }

        int max = 0, index = 0;
        for(int i=0; i<n+1; i++) {
            if(dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        Stack<Integer> ret = new Stack<>();
        while(index != 0) {
            if(max == dp[index]) {
                ret.add(arr.get(index).idx);
                max -= arr.get(index).h;
            }
            index--;
        }

        sb = new StringBuilder();
        sb.append(ret.size()).append('\n');
        while(!ret.isEmpty()) {
            sb.append(ret.pop()).append('\n');
        }

        bw.write(sb.toString());
    }

}
