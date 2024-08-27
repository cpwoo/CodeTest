package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj13904 {
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
        int[] answer = new int[1001];

        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            q.add(new int[]{d, w});
        }

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i=tmp[0]; i>0; i--) {
                if(answer[i] == 0) {
                    answer[i] = tmp[1];
                    break;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<1001; i++) sum += answer[i];

        bw.write(sum+"");
    }
}
