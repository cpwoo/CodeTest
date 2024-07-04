package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj1477 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);
        int L = Integer.parseInt(inp[2]);

        inp = br.readLine().split(" ");
        int[] arr = new int[N+2];
        for(int i=0; i<N; i++) {
            arr[i+1] = Integer.parseInt(inp[i]);
        }
        arr[N+1] = L;

        Arrays.sort(arr);

        int start = 1, end = L-1, result = 0;

        while(start <= end) {
            int cnt = 0;
            int mid = (start+end)/2;
            for(int i=1; i<arr.length; i++) {
                if(arr[i]-arr[i-1] > mid) {
                    cnt += (arr[i]-arr[i-1]-1)/mid;
                }
            }
            if(cnt > M) {
                start = mid+1;
            } else {
                end = mid-1;
                result = mid;
            }
        }

        bw.write(result+"");
    }

}
