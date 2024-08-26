package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1826 {
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
        
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q.add(new int[]{a, b});
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });

        while(P < L) {
            while(!q.isEmpty() && q.peek()[0] <= P) heap.add(q.poll());

            if(heap.isEmpty()) {
                cnt = -1;
                break;
            }

            P += heap.poll()[1];
            cnt++;
        }

        bw.write(cnt+"");
    }

}
