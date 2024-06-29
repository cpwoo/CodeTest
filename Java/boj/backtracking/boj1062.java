package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj1062 {
    private static int N, K;
    private static int answer = 0;
    private static String[] words = new String[50];
    private static boolean[] learn = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inp = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        K = Integer.parseInt(inp[1]);

        if(K < 5) {
            System.out.println(0);
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            line = line.replaceAll("[acint]", "");
            words[i] = line;
        }

        learn['a'-'a'] = true;
        learn['c'-'a'] = true;
        learn['i'-'a'] = true;
        learn['n'-'a'] = true;
        learn['t'-'a'] = true;

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int cnt) {
        if(cnt == K-5) {
            int tmp = 0;
            for(int i=0; i<N; i++) {
                boolean chk = true;
                for(int j=0; j<words[i].length(); j++) {
                    if(!learn[words[i].charAt(j)-'a']) {
                        chk = false;
                        break;
                    }
                }
                if(chk) tmp++;
            }
            answer = Math.max(answer, tmp);
            return;
        }

        for(int i=idx; i<26; i++) {
            if(!learn[i]) {
                learn[i] = true;
                dfs(i, cnt+1);
                learn[i] = false;
            }
        }
    }

}
