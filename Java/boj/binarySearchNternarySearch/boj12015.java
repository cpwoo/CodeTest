package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj12015 {
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
        
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[n];
        arr[0] = Integer.parseInt(inp[0]);
        
        int size = 1;
        for(int i=1; i<n; i++) {
            int h = Integer.parseInt(inp[i]);
            if(arr[size-1] < h) {
                arr[size++] = h;
            } else {
                int left = 0, right = size, mid = 0;
                while(left < right) {
                    mid = (left+right)/2;
                    if(arr[mid] < h) left = mid+1;
                    else right = mid;
                }
                arr[right] = h;
            }
        }

        bw.write(size+"");
    }

}
