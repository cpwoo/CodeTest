package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1644 {
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

        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        check[0] = check[1] = false;

        List<Integer> prime = new ArrayList<>();
        for(int i=2; i<n+1; i++) {
            if(check[i]) {
                prime.add(i);
                for(int j=2*i; j<n+1; j+=i) {
                    check[j] = false;
                }
            }
        }

        int answer = 0, start = 0, end = 0;

        while(end <= prime.size()) {
            long tmp = 0;
            for(int i=start; i<end; i++) tmp += prime.get(i);
            
            if(tmp == n) {
                answer++;
                end++;
            }
            else if(tmp < n) end++;
            else start++;
        }

        bw.write(answer+"");
    }

}
