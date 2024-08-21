package CodeTest.Java.boj.string;

import java.io.*;

public class boj5430 {
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
        String p = br.readLine().replace("RR", "");
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arr = str.substring(1, str.length()-1).split(",");

        int r = 0, f = 0, b = 0;

        for(char i : p.toCharArray()) {
            if(i == 'R') r++;
            else if(i == 'D') {
                if(r%2 == 0) f++;
                else b++;
            }
        }

        if(f+b <= n) {
            sb.append('[');
            if(r%2 == 1) {
                for(int i=n-b-1; i>=f; i--) sb.append(arr[i]).append(',');
            }
            else {
                for(int i=f; i<n-b; i++) sb.append(arr[i]).append(',');
            }
            if(sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length()-1);
            sb.append(']').append('\n');
        }
        else {
            sb.append("error\n");
        }
    }
}
