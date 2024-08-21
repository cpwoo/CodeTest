package CodeTest.Java.boj.string;

import java.io.*;

public class boj15927 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static char[] arr;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        arr = br.readLine().toCharArray();
        int n = arr.length;

        if(!chk(0, n-1)) bw.write(n+"");
        else if(!chk(0, n-2)) bw.write(n-1+"");
        else bw.write("-1");
    }

    private static boolean chk(int left, int right) {
        while(left < right) {
            if(arr[left] != arr[right]) return false;
            left++; right--;
        }
        return true;
    }

}
