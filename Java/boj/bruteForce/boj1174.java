package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1174 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static List<Long> nums;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        n--;
        nums = new ArrayList<>();

        for(int i=0; i<10; i++) {
            combination(i, 1);
        }

        Collections.sort(nums);

        bw.write((n < nums.size()) ? nums.get(n)+"" : -1+"");
    }

    private static void combination(long num, int idx) {
        if(idx > 10) return;

        nums.add(num);
        for(int i=0; i<num%10; i++) {
            combination(num*10+i, idx+1);
        }
    }

}
