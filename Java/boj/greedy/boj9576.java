package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj9576 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int cnt = 0;
        boolean[] visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            for(int j=arr[i][0]; j<arr[i][1]+1; j++) {
                if(!visited[j]) {
                    visited[j] = true;
                    cnt++;
                    break;
                }
            }
        }

        sb.append(cnt).append('\n');
    }
}
