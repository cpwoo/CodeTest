package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1461 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a > 0) plus.add(a);
            else minus.add(-a);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        Stack<Integer> cnt = new Stack<>();

        for(int i=0; i<plus.size()/M; i++) cnt.add(plus.get(i*M));

        if(plus.size()%M > 0) cnt.add(plus.get((plus.size()/M)*M));

        for(int i=0; i<minus.size()/M; i++) cnt.add(minus.get(i*M));

        if(minus.size()%M > 0) cnt.add(minus.get((minus.size()/M)*M));

        Collections.sort(cnt);

        int ret = cnt.pop();
        for(Integer i : cnt) ret += 2*i;

        bw.write(ret+"");
    }

}
