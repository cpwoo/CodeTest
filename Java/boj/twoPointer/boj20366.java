package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj20366 {
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

        int ret = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=i+3; j<n; j++) {
                int left = i+1, right = j-1;
                while(left < right) {
                    int tmp = (arr[i]+arr[j])-(arr[left]+arr[right]);
                    ret = Math.min(ret, Math.abs(tmp));
                    if(tmp < 0) right--;
                    else left++;
                }
            }
        }

        bw.write(ret+"");
    }

}
