package CodeTest.Java.programmers.kakao.level3;

public class 양과늑대 {
    private static boolean[] visited;
    private static int answer = 0;

    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        dfs(info, edges, 1, 0);   
        return answer;
    }

    private static void dfs(int[] info, int[][] edges, int sheep, int wolf) {
        if (sheep > wolf) answer = Math.max(answer, sheep);
        else return;
        
        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                int x = info[child] == 0 ? 1 : 0;
                int y = info[child] == 1 ? 1 : 0;
                dfs(info, edges, sheep+x, wolf+y);
                visited[child] = false;
            }
        }
    }
}
