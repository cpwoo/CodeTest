package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj16496 {
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
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = st.nextToken();
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(arr[i]);

        bw.write(sb.charAt(0) == '0' ? "0" : sb.toString());
    }

}
