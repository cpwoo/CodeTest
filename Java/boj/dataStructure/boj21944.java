package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj21944 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int sft = 100000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer>[] problemSet = new TreeSet[101];
        for(int i=0; i<101; i++) {
            problemSet[i] = new TreeSet<>();
        }
        int[][] problemInfo = new int[100001][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            problemInfo[p][0] = l;
            problemInfo[p][1] = g;

            int calc = l*sft+p-1;
            problemSet[0].add(calc);
            problemSet[g].add(calc);
        }

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(c.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    bw.write(problemSet[g].last()%sft+1+"\n");
                } else {
                    bw.write(problemSet[g].first()%sft+1+"\n");
                }
            }
            else if(c.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    bw.write(problemSet[0].last()%sft+1+"\n");
                } else {
                    bw.write(problemSet[0].first()%sft+1+"\n");
                }
            }
            else if(c.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int findL = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    Integer res = problemSet[0].higher(findL*sft-1);
                    bw.write((res == null) ? "-1\n" : res%sft+1+"\n");
                } else {
                    Integer res = problemSet[0].lower(findL*sft);
                    bw.write((res == null) ? "-1\n" : res%sft+1+"\n");
                }
            }
            else if(c.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                int l = problemInfo[p][0];
                int g = problemInfo[p][1];

                int calc = l*sft+p-1;
                problemSet[0].remove(calc);
                problemSet[g].remove(calc);
            }
            else {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                problemInfo[p][0] = l;
                problemInfo[p][1] = g;

                int calc = l*sft+p-1;
                problemSet[0].add(calc);
                problemSet[g].add(calc);
            }
        }
    }

}
