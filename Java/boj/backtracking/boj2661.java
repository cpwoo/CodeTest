package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj2661 {
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("1");
    }

    private static void dfs(String num) {
        if(num.length() == N) {
            System.out.println(num);
            System.exit(0);
        }

        for(int i=1; i<=3; i++) {
            if(chk(num+String.valueOf(i))) {
                dfs(num+String.valueOf(i));
            }
        }
        return;
    }

    private static boolean chk(String num) {
        int L = num.length();
        for(int idx=1; idx<L/2+1; idx++) {
            if(num.substring(L-idx).equals(num.substring(L-2*idx, L-idx))) {
                return false;
            }
        }
        return true;
    }

}
