package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj20210 {
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
        int n = Integer.parseInt(br.readLine());
        
        String[][] strs = new String[n][100];
        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            int idx = 0;

            for(int j=0; j<tmp.length(); j++) {
                if('0' <= tmp.charAt(j) && tmp.charAt(j) <= '9') {
                    int end = j+1;

                    while(end < tmp.length() && '0' <= tmp.charAt(end) && tmp.charAt(end) <= '9') end++;

                    strs[i][idx++] = tmp.substring(j, end);
                    
                    j = end-1;
                }
                else strs[i][idx++] = String.valueOf(tmp.charAt(j));
            }
        }

        int[] comp = new int['z'-'0'+1];

        for(int i='0'-'0'; i<='9'-'0'; i++) comp[i] = 0;

        for(int i='A'-'0', j=1; i<='Z'-'0'; i++, j+=2) comp[i] = j;

        for(int i='a'-'0', j=2; i<='z'-'0'; i++, j+=2) comp[i] = j;

        Arrays.sort(strs, (o1, o2) -> {
            int idx;
            for(idx=0; idx<100 && o1[idx] != null && o2[idx] != null; idx++) {
                if('0' <= o1[idx].charAt(0) && o1[idx].charAt(0) <= '9' && '0' <= o2[idx].charAt(0) && o2[idx].charAt(0) <= '9') {
                    int l1 = o1[idx].length();
                    int l2 = o2[idx].length();
                    int zero1 = 0, zero2 = 0;

                    while(zero1 < l1 && o1[idx].charAt(zero1) == '0') zero1++;
                    
                    while(zero2 < l2 && o2[idx].charAt(zero2) == '0') zero2++;

                    if(l1-zero1 == l2-zero2) {
                        for(int i=0; i<l1-zero1; i++) {
                            if(o1[idx].charAt(zero1+i) == o2[idx].charAt(zero2+i)) continue;
                            return o1[idx].charAt(zero1+i)-o2[idx].charAt(zero2+i);
                        }
                        if(l1 == l2) continue;
                        else return l1-l2;
                    }
                    return (l1-zero1)-(l2-zero2);
                }
                if(comp[o1[idx].charAt(0)-'0'] == comp[o2[idx].charAt(0)-'0']) continue;
                return comp[o1[idx].charAt(0)-'0']-comp[o2[idx].charAt(0)-'0'];
            }
            if(idx >= 100) return 0;
            else if(o1[idx] == null && o2[idx] == null) return 0;
            else if(o1[idx] == null) return -1;
            else if(o2[idx] == null) return 1;
            return 0;
        });

        sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            for(int j=0; j<100 && strs[i][j] != null; j++) {
                sb.append(strs[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

}
