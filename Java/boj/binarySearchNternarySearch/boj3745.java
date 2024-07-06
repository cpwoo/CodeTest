package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj3745 {
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
        String s;

        while((s=br.readLine()) != null) {
            int n = Integer.parseInt(s.trim());
            int[] arr = new int[n+1];
            int[] q = new int[n+1];

            // StringTokenizer 사용하니 NumberFormatException 발생 X
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            q[0] = arr[0];
            int cnt = 0;
            for(int i=0; i<n; i++) {
                int idx = binarySearch(q, 1, cnt+1, arr[i]);
                q[idx] = arr[i];
                if(idx == cnt+1) cnt++;
            }
            bw.write(cnt+"\n");
        }
    }

    private static int binarySearch(int[] q, int start, int end, int key) {
        while(start < end) {
            int mid = (start+end)/2;
            if(q[mid] < key) start = mid+1;
            else end = mid;
        }
        return end;
    }

}
