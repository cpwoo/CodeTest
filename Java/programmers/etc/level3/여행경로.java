package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 여행경로 {
    private static boolean[] visited;
    private static List<String> candidate;

    public String[] solution(String[][] tickets) {
        int cnt = 0;
        visited = new boolean[tickets.length];
        candidate = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(candidate);
        String[] answer = candidate.get(0).split(" ");
        return answer;
    }

    private void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            candidate.add(route);
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}
