package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj1806 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int ret = 100001;
        int tmp = arr[0];

        while(true) {
            if(tmp >= s) {
                tmp -= arr[left];
                ret = Math.min(ret, right-left+1);
                left++;
            }
            else {
                right++;
                if(right == n) break;
                tmp += arr[right];
            }
        }

        bw.write((ret != 100001) ? ret+"" : "0");
    }

}
