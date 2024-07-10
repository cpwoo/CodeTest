package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj14003 {
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
        int n = Integer.parseInt(br.readLine());

        int[] ids = new int[n];
        for(int i=0; i<n; i++) {
            ids[i] = i;
        }

        String[] inp = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        int size = 1;
        for(int i=1; i<n; i++) {
            int h = arr[i];
            if(dp[size-1] < h) {
                dp[size++] = h;
                ids[i] = size-1;
            } else {
                int left = 0, right = size, mid = 0;
                while(left < right) {
                    mid = (left+right)/2;
                    if(dp[mid] < h) left = mid+1;
                    else right = mid;
                }
                dp[right] = h;
                ids[i] = right;
            }
        }

        bw.write(size+"\n");

        int tmp = size-1;
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            if(ids[i] == tmp) {
                st.add(arr[i]);
                tmp--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop()+" ");
        }

        bw.write(sb.toString());
    }

}
