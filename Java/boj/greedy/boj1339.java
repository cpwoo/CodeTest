package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1339 {
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

        int[] arr = new int[26];
        for(int i=0; i<n; i++) {
            char[] word = br.readLine().toCharArray();
            int digit = word.length-1;
            for(char w : word) {
                arr[w-'A'] += Math.pow(10, digit--);
            }
        }
        
        Arrays.sort(arr);

        int ret = 0, m = 9;
        for(int i=25; i>=0; i--) {
            ret += arr[i]*m;
            m--;
        }
        bw.write(ret+"");
    }

}
