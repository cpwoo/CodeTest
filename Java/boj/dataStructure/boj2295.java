package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj2295 {
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
        long[] arr = new long[n];
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        Set<Long> can = new HashSet<>();
        for(long i: arr) {
            for(long j: arr) {
                can.add(i+j);
            }
        }

        Map<Long, Long> map = new HashMap<>();
        for(long i: arr) {
            for(long j: arr) {
                if(can.contains(i-j)) {
                    map.put(i, i-j);
                }
            }
        }

        long _max = 0;
        for(long key: map.keySet()) {
            _max = Math.max(_max, key);
        }

        bw.write(_max+"");
    }

}
