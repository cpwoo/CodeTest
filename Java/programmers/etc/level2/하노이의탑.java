package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 하노이의탑 {
    static List<int[]> answer = new ArrayList<>();

    public List<int[]> solution(int n) {
        dfs(n, 1, 2, 3);
        return answer;
    }

    private static void dfs(int n, int fr, int aux, int to) {
        if (n == 1) {
            answer.add(new int[]{fr, to});
            return;
        }
        dfs(n-1, fr, to, aux);
        answer.add(new int[]{fr, to});
        dfs(n-1, aux, fr, to);
    }
}
