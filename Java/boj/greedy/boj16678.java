package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj16678 {
    private static BufferedReader br;
    private static BufferedWriter bw;

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
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long ret = 0, defile = 1;

        for(int i=0; i<n; i++) {
            if(arr[i] >= defile) {
                ret += arr[i]-defile;
                defile++;
            }
        }
        
        bw.write(ret+"");
    }
}
