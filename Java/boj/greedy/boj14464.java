package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj14464 {
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
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] chicken = new int[C];
        for(int i=0; i<C; i++) chicken[i] = Integer.parseInt(br.readLine());

        Arrays.sort(chicken);

        int[][] cow = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) cow[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cow, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        boolean[] visited = new boolean[C];

        int ret = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<C; j++) {
                if(cow[i][0] <= chicken[j] && chicken[j] <= cow[i][1] && !visited[j]) {
                    ret++;
                    visited[j] = true;
                    break;
                }
            }
        }

        bw.write(ret+"");
    }
}
