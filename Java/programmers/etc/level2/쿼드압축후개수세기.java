package CodeTest.Java.programmers.etc.level2;

public class 쿼드압축후개수세기 {
    static int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length;
        compress(arr, 0, 0, n);
        return answer;
    }

    private static void compress(int[][] arr, int y, int x, int n) {
        int tg = arr[y][x];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[y+i][x+j] != tg) {
                    compress(arr, y, x, n/2);
                    compress(arr, y+n/2, x, n/2);
                    compress(arr, y, x+n/2, n/2);
                    compress(arr, y+n/2, x+n/2, n/2);
                    return;
                }
            }
        }
        answer[tg]++;
    }    
}
