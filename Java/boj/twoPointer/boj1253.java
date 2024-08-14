package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj1253 {
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

        int ret = 0;
        for(int i=0; i<n; i++) {
            int target = arr[i];
            int left = 0, right = n-1;
            while(left < right) {
                if(left == i) left++;

                if(right == i) right--;

                if(left == right) break;

                int tmp = arr[left]+arr[right];

                if(tmp == target) {
                    ret++;
                    break;
                }

                if(tmp > target) right--;
                
                else left++;
            }
        }

        bw.write(ret+"");
    }

}
