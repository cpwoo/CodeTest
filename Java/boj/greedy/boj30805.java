package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj30805 {
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

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) B[i] = Integer.parseInt(st.nextToken());

        int a = 0, b = 0;
        List<Integer> list = new ArrayList<>();
        
        while (a<n && b<m) {
            int max = -1, idxA = -1, idxB = -1;
            for (int i=a; i<n; i++) {
                for (int j=b; j<m; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        max = A[i];
                        idxA = i;
                        idxB = j;
                    }
                }
            }

            if (max == -1) break;
            list.add(max);
            a = idxA+1;
            b = idxB+1;
        }

        sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for(Integer i : list) sb.append(i).append(' ');

        bw.write(sb.toString());
    }
}
