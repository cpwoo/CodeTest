package CodeTest.Java.boj.string;

import java.io.*;

public class boj3107 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String str = br.readLine();
        int L = str.length();

        if(str.charAt(L-1) == ':') str += '0';

        int cnt = 0;
        for(int i=0; i<L; i++) if(str.charAt(i) == ':') cnt++;

        for(int i=0; i<L-1; i++) {
            if(str.charAt(i) == ':' && str.charAt(i+1) == ':') {
                if(cnt == 8) str = str.replace("::", ":");
                else {
                    String rep = ":";
                    for (int j=0; j<8-cnt; j++) {
                        rep += "0:";
                    }
                    str = str.replace("::", rep);
                }
                break;
            }
        }

        String[] arr = str.split(":");

        sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<4-arr[i].length(); j++) sb.append("0");
            sb.append(arr[i]).append(":");
        }

        sb.delete(sb.length()-1, sb.length());

        bw.write(sb.toString());
    }

}
