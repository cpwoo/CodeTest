package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj1422 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n;
    private static String arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new String[k];
        int maxLen = 0;
        for(int i=0; i<k; i++) {
            arr[i] = br.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }
        Arrays.sort(arr, (s1, s2)->(s2+s1).compareTo(s1+s2));

        sb = new StringBuilder();
        boolean maxChk = false;
        for(int i=0; i<k; i++) {
            if(!maxChk && arr[i].length() == maxLen) {
                maxChk = true;
                for(int j=0; j<n-k+1; j++) {
                    sb.append(arr[i]);
                }
            }
            else sb.append(arr[i]);
        }

        bw.write(sb.toString());
    }

}
