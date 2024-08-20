package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj1599 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i=0; i<n; i++) arr[i] = br.readLine().replace("k", "c").replace("ng", "n|");

        Arrays.sort(arr);

        sb = new StringBuilder();

        for(String a : arr) {
            a = a.replace("c", "k").replace("n|", "ng");
            sb.append(a).append('\n');
        }

        bw.write(sb.toString());
    }

}
