package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj16637 {
    private static int answer, first, second;
    private static int[] nums;
    private static char[] op;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        nums = new int[n/2+1];
        op = new char[n/2];

        for(int i=0; i<n/2+1; i++) {
            nums[i] = expression.charAt(i*2)-'0';
        }

        for(int i=0; i<n/2; i++) {
            op[i] = expression.charAt(i*2+1);
        }
        
        answer = Integer.MIN_VALUE;
        dfs(0, nums[0]);

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int subTotal) {
        if(idx == op.length) {
            answer = Math.max(answer, subTotal);
            return;
        }

        first = solve(subTotal, op[idx], nums[idx+1]);
        dfs(idx+1, first);

        if(idx+1 < op.length) {
            second = solve(nums[idx+1], op[idx+1], nums[idx+2]);
            second = solve(subTotal, op[idx], second);
            dfs(idx+2, second);
        }
    }

    private static int solve(int a, char op, int b) {
        if(op == '+') {
            return a+b;
        } else if(op == '-') {
            return a-b;
        }
        return a*b;
    }

}
