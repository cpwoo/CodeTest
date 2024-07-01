package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj7490 {
    private static BufferedWriter bw;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            dfs(0, 1, 1, 1, "1");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int total, int sign, int num, int n, String st) throws Exception {
        if(n == N) {
            total += sign*num;
            if(total == 0) {
                bw.write(st);
                bw.newLine();
            }
        } else {
            dfs(total, sign, num*10+(n+1), n+1, st+" "+String.valueOf(n+1));
            dfs(total+sign*num, 1, (n+1), n+1, st+"+"+String.valueOf(n+1));
            dfs(total+sign*num, -1, (n+1), n+1, st+"-"+String.valueOf(n+1));
        }
    }

}
