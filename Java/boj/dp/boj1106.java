package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1106 {
    static class Info implements Comparable<Info> {
        int cost, people;
        Info(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }

        @Override
        public int compareTo(Info info) {
            return this.cost-info.cost;
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
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Info> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Info(x, y));
        }

        Collections.sort(arr);

        int[] cost = new int[c+100];
        Arrays.fill(cost, 100000);
        cost[0] = 0;
        
        for(Info info : arr) {
            for(int i=info.people; i<c+100; i++) {
                cost[i] = Math.min(cost[i], cost[i-info.people]+info.cost);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=c; i<c+100; i++) min = Math.min(min, cost[i]);

        bw.write(min+"");
    }

}
