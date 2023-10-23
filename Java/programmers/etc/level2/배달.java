package CodeTest.Java.programmers.etc.level2;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] matrix = new int[N][N];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i != j) matrix[i][j] = 500001;
            }
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            matrix[a-1][b-1] = Math.min(matrix[a-1][b-1], c);
            matrix[b-1][a-1] = Math.min(matrix[b-1][a-1], c);
        }
        
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (matrix[i][k]+matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
        
        for (int i=0; i<N; i++) {
            if (matrix[0][i] <= K) answer++;
        }

        return answer;
    }
}
