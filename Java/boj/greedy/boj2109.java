package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2109 {
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
        
        int[][] lectures = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) lectures[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        Queue<Integer> q = new PriorityQueue<>();
        for(int[] lecture : lectures) {
            q.add(lecture[0]);
            if(lecture[1] < q.size()) q.poll();
        }

        int ret = 0;
        while(!q.isEmpty()) ret += q.poll();

        bw.write(ret+"");
    }

}
