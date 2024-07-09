package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj13711 {
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = map.get(Integer.parseInt(st.nextToken()));
        }

        Vector<Integer> v = new Vector<>();
        for(int a: arr) {
            if(v.isEmpty()) v.add(a);
            else if(v.lastElement() < a) v.add(a);
            else v.set(-Collections.binarySearch(v,a)-1, a);
        }

        bw.write(v.size()+"");
    }

}
