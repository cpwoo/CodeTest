package CodeTest.Java.programmers.etc.level1;

public class 행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length, M = arr1[0].length;
        int[][] answer = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                answer[i][j] = arr1[i][j]+arr2[i][j];
            }
        }
        
        return answer;
    }
}
