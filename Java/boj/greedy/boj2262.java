package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2262 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> lst;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) lst.add(Integer.parseInt(st.nextToken()));

        int ret = 0;
        
        for(int i=0; i<n-1; i++) {
            int maxIdx = index();

            if(maxIdx == 0) ret += lst.get(maxIdx)-lst.get(maxIdx+1);

            else if(maxIdx == lst.size()-1) ret += lst.get(maxIdx)-lst.get(maxIdx-1);

            else ret += lst.get(maxIdx)-Math.max(lst.get(maxIdx-1), lst.get(maxIdx+1));

            lst.remove(maxIdx);
        }

        bw.write(ret+"");
    }

    private static int index() {
        int max = 0, idx = 0;

        for(int i=0; i<lst.size(); i++) {
            if(max < lst.get(i)) {
                max = lst.get(i);
                idx = i;
            }
        }
        
        return idx;
    }

}
