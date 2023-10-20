package CodeTest.Java.programmers.etc.level2;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int idx, int cur) {
        if (idx == numbers.length) {
            return cur == target ? 1 : 0;
        }
        return dfs(numbers, target, idx+1, cur+numbers[idx]) + dfs(numbers, target, idx+1, cur-numbers[idx]);
    }
}
