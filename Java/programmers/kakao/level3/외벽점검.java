package CodeTest.Java.programmers.kakao.level3;

public class 외벽점검 {
    private static int[] spread;
    private static int answer;

    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        
        spread = new int[weak.length*2];
        for (int i=0; i<weak.length; i++) {
            spread[i] = weak[i];
            spread[i+weak.length] = weak[i]+n;
        }

        for(int k=0; k<weak.length; k++) {
            dfs(k, 0, dist, new boolean[dist.length], new int[dist.length]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int start, int depth, int[] dist, boolean[] visited, int[] permuted) {
        if(depth == dist.length) {
            answer = Math.min(answer, check(start, start+spread.length/2, permuted));
            return;
        }
        for(int i=0; i<dist.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            permuted[depth] = dist[i];
            dfs(start, depth+1, dist, visited, permuted);
            visited[i] = false;
        }
    }

    private int check(int start, int end, int[] permuted) {
        int friend = 1;
        int pos = spread[start]+permuted[friend-1];

        for(int i=start; i<end; i++) {
            if(pos < spread[i]) {
                friend++;
                if (friend > permuted.length) return Integer.MAX_VALUE;
                pos = spread[i]+permuted[friend-1];
            }
        }
        return friend;
    }
}
