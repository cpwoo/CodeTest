package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1041 {
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
        long n = Long.parseLong(br.readLine());
        
        int[] dice = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) dice[i] = Integer.parseInt(st.nextToken());

        if(n == 1) {
            int sum = 0, max = 0;
            for(int i=0; i<6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            bw.write(sum-max+"");
            return;
        }

        int[] arr = new int[3];
        arr[0] = Math.min(dice[0], dice[5]);
        arr[1] = Math.min(dice[1], dice[4]);
        arr[2] = Math.min(dice[2], dice[3]);

        Arrays.sort(arr);

        long n1 = (n-2)*(n-2)+(n-1)*(n-2)*4;
        long n2 = (n-2)*4+(n-1)*4;
        long n3 = 4;

        bw.write(n1*arr[0]+n2*(arr[0]+arr[1])+n3*(arr[0]+arr[1]+arr[2])+"");
    }

}
