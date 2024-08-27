package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj11000 {
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

        Queue<Integer> room = new PriorityQueue<>();
        room.add(arr[0][1]);

        for(int i=1; i<n; i++) {
            if(arr[i][0] < room.peek()) room.add(arr[i][1]);
            else {
                room.poll();
                room.add(arr[i][1]);
            }
        }

        bw.write(room.size()+"");
    }
}
