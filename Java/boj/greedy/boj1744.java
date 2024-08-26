package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1744 {
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
        
        int ret = 0;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > 1) positive.add(x);
            else if(x == 1) ret++;
            else negative.add(x);
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        for(int i=0; i<positive.size()-1; i+=2) {
            ret += positive.get(i)*positive.get(i+1);
        }

        if(positive.size()%2 == 1) ret += positive.get(positive.size()-1);

        for(int i=0; i<negative.size()-1; i+=2) {
            ret += negative.get(i)*negative.get(i+1);
        }

        if(negative.size()%2 == 1) ret += negative.get(negative.size()-1);

        bw.write(ret+"");
    }

}
