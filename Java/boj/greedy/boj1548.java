package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1548 {
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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int ret = 1;
        for(int x=0; x<n-1; x++) for(int y=n-1; y>=0; y--) {
            if(y < x+1) continue;
            if(arr[x]+arr[x+1] > arr[y]) ret = Math.max(ret, y-x+1);
        }

        bw.write(ret+"");
    }

}
