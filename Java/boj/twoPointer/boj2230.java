package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj2230 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = 0;

        int ret = Integer.MAX_VALUE;

        while(left < N && right < N) {
            int tmp = arr[right]-arr[left];

            if(tmp == M) {
                bw.write(M+"");
                return;
            }

            if(tmp < M) {
                right++;
                continue;
            }
            left++;
            ret = Math.min(ret, tmp);
        }

        bw.write(ret+"");
    }

}
