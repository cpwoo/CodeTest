package CodeTest.Java.programmers.etc.level2;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        int l = 0, r = 0;
        for (int t : topping) right[t]++;
        for (int i : right) r += i>0 ? 1 : 0;
    
        for (int t : topping) {
            right[t]--;
            if (right[t] == 0) r--;
            if (left[t] == 0) l++;
            left[t]++;
            if (l == r) answer++;
        }
        
        return answer;
    }
}
