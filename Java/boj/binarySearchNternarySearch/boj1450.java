package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj1450 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int n, c, arr[];
    private static List<Integer> l, r;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        c = Integer.parseInt(inp[1]);
        
        arr = new int[n];
        inp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        l = new ArrayList<>();
        r = new ArrayList<>();

        comb(l, 0, n/2, 0);
        comb(r, n/2, n, 0);

        r.sort((o1,o2) -> (o1-o2));

        int cnt = 0, idx = 0;
        for(int i=0; i<l.size(); i++) {
            idx = binarySearch(0, r.size()-1, l.get(i));
            cnt += idx+1;
        }

        bw.write(cnt+"");
    }

    private static void comb(List<Integer> list, int start, int end, int sum) {
        if(sum > c) return;
        if(start == end) {
            list.add(sum);
            return;
        }

        comb(list, start+1, end, sum);
        comb(list, start+1, end, sum+arr[start]);
    }

    private static int binarySearch(int s, int e, int val) {
        while(s <= e) {
            int mid = (s+e)/2;
            if(r.get(mid) <= c-val) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return e;
    }

}
