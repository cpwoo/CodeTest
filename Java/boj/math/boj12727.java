package CodeTest.Java.boj.math;

import java.io.*;

public class boj12727 {
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
        int[] arr = new int[30];
        arr[0] = 5; arr[1] = 27;
        for(int i=2; i<30; i++) arr[i] = (6*arr[i-1]-4*arr[i-2]+1+100000)%1000;

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i=1; i<tc+1; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(String.format("Case #%d: %03d", i, arr[x-1]%1000)).append('\n');
        }

        bw.write(sb.toString());
    }

}
