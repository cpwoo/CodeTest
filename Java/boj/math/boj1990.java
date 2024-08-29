package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1990 {
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
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        b = Math.min(10_000_000, b);

        sb = new StringBuilder();
        for(int i=a; i<b+1; i++) {
            if(chk(i)) sb.append(i).append('\n');
        }

        sb.append(-1);

        bw.write(sb.toString());
    }

    private static boolean chk(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for(int i=0; i<arr.length/2; i++) {
            if(arr[i] != arr[arr.length-1-i]) return false;
        }

        for(int i=2; i<(int)Math.sqrt(num)+1; i++) {
            if(num%i == 0) return false;
        }

        return true;
    }

}
