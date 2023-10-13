package CodeTest.Java.programmers.etc.level1;

public class 숫자짝꿍 {
    public String solution(String X, String Y) {
        int[] numX = new int[10], numY = new int[10];
        
        for (String x : X.split("")) {
            numX[Integer.parseInt(x)]++;
        }
        for (String y : Y.split("")) {
            numY[Integer.parseInt(y)]++;
        }
        
        StringBuilder tmp = new StringBuilder();

        for (int i=9; i>=0; i--) {
            if (numX[i] > 0 && numY[i] > 0) {
                tmp.append(String.valueOf(i).repeat(Math.min(numX[i], numY[i])));
            }
        }
        
        String answer = tmp.toString();
        
        return answer.startsWith("0") ? "0" : answer.equals("") ? "-1" : answer;
    }
}
