package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2300 {
    static class building implements Comparable<building> {
        int x, y;
        building(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(building other) {
            if(this.x != other.x) {
                return this.x-other.x;
            }
            return this.y-other.y;
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
        int n = Integer.parseInt(br.readLine());
        List<building> buildings = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            buildings.add(new building(a, Math.abs(b)));
        }

        Collections.sort(buildings);

        long[] dp = new long[n];
        dp[0] = buildings.get(0).y*2;

        for(int i=1; i<n; i++) {
            int maxHeight = buildings.get(i).y;
            dp[i] = dp[i-1]+maxHeight*2;
            for(int j=i-1; j>=0; j--) {
                maxHeight = Math.max(maxHeight, buildings.get(j).y);
                if(j > 0) {
                    dp[i] = Math.min(dp[i], Math.max(2*maxHeight, buildings.get(i).x-buildings.get(j).x)+dp[j-1]);
                }
                else {
                    dp[i] = Math.min(dp[i], Math.max(2*maxHeight, buildings.get(i).x-buildings.get(j).x));
                }
            }
        }

        bw.write(dp[n-1]+"");
    }

}
