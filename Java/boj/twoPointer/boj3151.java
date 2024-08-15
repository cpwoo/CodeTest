package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj3151 {
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

        Map<Integer, Integer> counter = new HashMap<>();
        for(int a : arr) {
            counter.put(a, counter.getOrDefault(a, 0)+1);
        }

        long ret = 0;

        for(int i=0; i<n; i++) {
            int left = i+1, right = n-1;
            while(left < right) {
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == 0) {
                    if(arr[left] == arr[right]) ret += right-left;
                    else ret += counter.get(arr[right]);
                    left++;
                }
                else if(sum > 0) right--;
                else left++;
            }
        }
        
        bw.write(ret+"");
    }

}
