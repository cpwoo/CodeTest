package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1016 {
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
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[] check = new int[(int)(b-a+1)];
        Arrays.fill(check, 1);

        long i = 2;

        while(i*i <= b) {
            long mul = a/(i*i);
            while(mul*i*i <= b) {
                if(0 <= mul*i*i-a && mul*i*i-a <= b-a) {
                    check[(int)(mul*i*i-a)] = 0;
                }
                mul++;
            }
            i++;
        }

        int sum = 0;
        for(int j=0; j<b-a+1; j++) sum += check[j];

        bw.write(sum+"");
    }
}
