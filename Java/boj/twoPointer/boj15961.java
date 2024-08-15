package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj15961 {
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
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[2*n];
        for(int i=0; i<n; i++) arr[i] = arr[i+n] = Integer.parseInt(br.readLine());

        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int ret = 0;
        map.put(c, 1);

        for(int right=0; right<2*n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);

            if(right >= k-1) {
                ret = Math.max(ret, map.size());
                map.put(arr[left], map.getOrDefault(arr[left], 0)-1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
        }

        bw.write(ret+"");
    }

}
