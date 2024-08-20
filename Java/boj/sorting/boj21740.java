package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj21740 {
    static class Number {
        String ori, rev;
        int len = 0;

        Number(String str) {
            ori = str;
            sb = new StringBuilder();
            for(int i=str.length()-1; i>=0; i--) {
                char c = str.charAt(i);
                switch(c) {
                    case '6': c = '9'; break;
                    case '9': c = '6'; break;
                }
                sb.append(c);
            }
            rev = sb.toString();
            len = sb.length();
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
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

        Number[] arr = new Number[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = new Number(st.nextToken());

        Arrays.sort(arr, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if(o2.len == o1.len) return o2.rev.compareTo(o1.rev);
                return o2.len-o1.len;
            }
        });

        Number dup = arr[0];

        Arrays.sort(arr, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return (o2.rev+o1.rev).compareTo(o1.rev+o2.rev);
            }
        });

        sb = new StringBuilder();

        for(int i=n-1; i>=0; i--) {
            sb.append(arr[i].ori);
            if(arr[i] == dup) sb.append(arr[i].ori);
        }

        bw.write(sb.toString());
    }

}
