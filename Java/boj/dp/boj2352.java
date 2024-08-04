package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2352 {
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
        arr[0] = Integer.parseInt(st.nextToken());

        int len = 1;
        for(int i=1; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if(arr[len-1] < x) arr[len++] = x;
            else {
                // bisect_left
                int left = 0, right = len;
                while(left < right) {
                    int mid = (left+right)/2;

                    if(arr[mid] < x) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                arr[right] = x;
            }
        }

        bw.write(len+"");
    }

}
