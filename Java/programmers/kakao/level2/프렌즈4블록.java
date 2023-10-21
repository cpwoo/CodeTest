package CodeTest.Java.programmers.kakao.level2;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];

        for (int i=0; i<m; i++) {
            table[i] = board[m-i-1].toCharArray();
        }
        
        while (true) {
            boolean flag = true;
            boolean[][] chk = new boolean[m][n];

            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (table[i][j]=='-') continue;
                    char a = table[i][j];
                    if (table[i][j+1] == a && table[i+1][j] == a && table[i+1][j+1] == a) {
                        chk[i][j] = true;
                        chk[i][j+1] = true;
                        chk[i+1][j] = true;
                        chk[i+1][j+1] = true;
                        flag = false;
                    }
                }
            }
            
            if (flag) break;

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (chk[i][j]) {
                        table[i][j] = '-';
                        answer++;
                    }
                }
            }

            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (table[i][j] == '-') {
                        for (int k=i; k<m; k++) {
                            if (table[k][j] == '-') {
                                continue;
                            }
                            table[i][j] = table[k][j];
                            table[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
