package CodeTest.Java.programmers.etc.level1;

public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] stk = new int[ingredient.length];

        int j = 0;
        for (int i : ingredient) {
            stk[j++] = i;
            if (j >= 4 && stk[j-1]==1 && stk[j-2]==3 && stk[j-3]==2 && stk[j-4]==1) {
                j -= 4;
                answer++;
            }
        }
        
        return answer;
    }
}
