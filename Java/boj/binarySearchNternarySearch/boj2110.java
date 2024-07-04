package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj2110 {
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
        int n = Integer.parseInt(inp[0]);
        int c = Integer.parseInt(inp[1]);
        
        int[] house = new int[n];
        for(int i=0; i<n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int start = 1, end = house[n-1]-house[0];
        int result = 0;

        while(start <= end) {
            int mid = (start+end)/2;
            int old = house[0];
            int cnt = 1;

            for(int i=1; i<n; i++) {
                if(house[i] >= old+mid) {
                    cnt++;
                    old = house[i];
                }
            }
            
            if(cnt >= c) {
                start = mid+1;
                result = mid;
            } else {
                end = mid-1;
            }
        }

        bw.write(result+"");
    }

}
