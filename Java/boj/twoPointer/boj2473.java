package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj2473 {
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

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long ret = Long.MAX_VALUE;
        long a = 0, b = 0, c = 0;

        for(int i=0; i<n-2; i++) {
            int left = i+1, right = n-1;
            while(left < right) {
                long tmp = arr[i]+arr[left]+arr[right];
                if(Math.abs(tmp) <= Math.abs(ret)) {
                    a = arr[i]; b = arr[left]; c = arr[right];
                    ret = tmp;
                }
                if(tmp < 0) left++;
                else if(tmp > 0) right--;
                else {
                    bw.write(a+" "+b+" "+c+"");
                    return;
                }
            }
        }

        bw.write(a+" "+b+" "+c+"");
    }

}
