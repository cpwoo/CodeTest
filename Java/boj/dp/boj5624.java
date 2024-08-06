package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj5624 {
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

        Set<Integer> set = new HashSet<>();

        int ret = 0;
        set.add(arr[0]+arr[0]);

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(set.contains(arr[i]-arr[j])) {
                    ret++;
                    break;
                }
            }
            for(int j=0; j<i+1; j++) set.add(arr[i]+arr[j]);
        }

        bw.write(ret+"");
    }

}
