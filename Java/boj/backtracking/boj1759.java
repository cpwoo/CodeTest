package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj1759 {
    private static int L, C;
    private static int co, vo;
    private static String[] arr;
    private static List<Character> consonant = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static List<Character> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inp = br.readLine().split(" ");
        L = Integer.parseInt(inp[0]);
        C = Integer.parseInt(inp[1]);

        arr = br.readLine().split(" ");
        Arrays.sort(arr);

        dfs(0, 0);
    }

    private static void dfs(int cnt, int idx) {
        if(cnt == L) {
            co = 0; vo = 0;

            for(int i=0; i<L; i++) {
                if(consonant.contains(answer.get(i))) co++;
                else vo++;
            }
            
            if(co >= 1 && vo >= 2) {
                StringBuilder sb = new StringBuilder();
                for(char c: answer) {
                    sb.append(c);
                }
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i=idx; i<C; i++) {
            answer.add(arr[i].charAt(0));
            dfs(cnt+1, i+1);
            answer.remove(answer.size()-1);
        }
    }

}
