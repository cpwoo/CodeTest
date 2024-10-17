package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj9024 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE, cnt = 0, left = 0, right = n-1;

        while(left < right) {
            int tmp = arr[left]+arr[right];

            if(Math.abs(k-tmp) < min) {
                min = Math.abs(k-tmp);
                cnt = 1;
            }
            else if(Math.abs(k-tmp) == min) cnt++;

            if(k <= tmp) right--;
            else left++;
        }

        sb.append(cnt).append('\n');
    }

}
