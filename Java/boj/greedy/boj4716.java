package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj4716 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(n == 0 && a == 0 && b == 0) break;
            solve(n, a, b);
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve(int n, int a, int b) throws Exception {
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o2[1]-o2[2])-Math.abs(o1[1]-o1[2]);
            }
        });

        int answer = 0;
        for(int i=0; i<n; i++) {
            int k = arr[i][0], da = arr[i][1], db = arr[i][2];

            int tmp = (da <= db) ? Math.min(k, a) : k-Math.min(k, b);
            
            answer += tmp*da+(k-tmp)*db;

            a -= tmp;
            b -= k-tmp;
        }

        sb.append(answer).append('\n');
    }
}
