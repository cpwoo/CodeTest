package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1781 {
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
        
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        Queue<Integer> q = new PriorityQueue<>();
        for(int[] a : arr) {
            q.add(a[1]);
            if(a[0] < q.size()) q.poll();
        }

        int ret = 0;
        while(!q.isEmpty()) ret += q.poll();

        bw.write(ret+"");
    }

}
