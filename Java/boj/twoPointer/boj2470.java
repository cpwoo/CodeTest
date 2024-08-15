package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj2470 {
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

        int left = 0, right = n-1;
        int answer = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while(left < right) {
            int tmp = arr[left]+arr[right];

            if(Math.abs(tmp) < answer) {
                answer = Math.abs(tmp);
                ansLeft = arr[left]; ansRight = arr[right];
            }

            if(tmp < 0) left++;
            else right--;
        }

        bw.write(ansLeft+" "+ansRight+"");
    }

}
