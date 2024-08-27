package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj28709 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        char[] arr = br.readLine().toCharArray();

        int min = 0, max = 0;
        boolean flag = false;

        for(char a : arr) {
            if(a == '(') {
                min++; max++;
            }
            else if(a == ')') {
                if(max == 0) {
                    sb.append("NO\n");
                    return;
                }
                min = Math.max(min-1, 0);
                max--;
            }
            else if(a == '?') {
                min = Math.max(min-1, 0);
                max++;
            }
            else if(a == '*') {
                min = 0; max = 500001; flag = true;
            }
        }

        sb.append(((!flag && (max-min)%2 == 1) || min != 0) ? "NO\n" : "YES\n");
    }
}
