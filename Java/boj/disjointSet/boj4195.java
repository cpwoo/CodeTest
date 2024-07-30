package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj4195 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static Map<String, String> parent;
    private static Map<String, Integer> number;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            solve();
        }

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int num = Integer.parseInt(br.readLine());
        parent = new HashMap<>();
        number = new HashMap<>();
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            parent.put(a, parent.getOrDefault(a, a));
            number.put(a, number.getOrDefault(a, 1));
            String b = st.nextToken();
            parent.put(b, parent.getOrDefault(b, b));
            number.put(b, number.getOrDefault(b, 1));

            union(a, b);
        }
    }

    private static String find(String x) {
        if(!parent.get(x).equals(x)) parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    private static void union(String a, String b) throws Exception {
        a = find(a); b = find(b);

        if(!a.equals(b)) {
            parent.put(b, a);
            number.put(a, number.get(a)+number.get(b));
        }

        bw.write(number.get(a)+"\n");
    }

}
