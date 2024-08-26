package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2285 {
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
        long sum = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][1];
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int pos = 0;
        long cnt = 0;

        for(int i=0; i<n; i++) {
            cnt += arr[i][1];
            if(cnt >= (double)sum/2) {
                pos = arr[i][0];
                break;
            }
        }

        bw.write(pos+"");
    }

}
