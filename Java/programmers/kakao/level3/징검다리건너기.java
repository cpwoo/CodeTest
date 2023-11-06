package CodeTest.Java.programmers.kakao.level3;

public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int left = 1, right = 200_000_000;

        while (left <= right) {
            int mid = (left+right)/2;
            int cnt = 0;
            for (int stone : stones) {
                if (stone <= mid) cnt++;
                else cnt = 0;
                if (cnt >= k) break;
            }
            if (cnt >= k) right = mid-1;
            else left = mid+1;
        }

        return left;
    }
}
