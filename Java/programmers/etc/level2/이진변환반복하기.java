package CodeTest.Java.programmers.etc.level2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            answer[0]++;
            int n = 0;
            for (char i : s.toCharArray()) {
                if (i == '0') answer[1]++;
                else n++;
            }
            s = Integer.toBinaryString(n);
        }
        
        return answer;
    }
}
