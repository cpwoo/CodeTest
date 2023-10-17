package CodeTest.Java.programmers.kakao.level2;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int q1 = queue1.length, q2 = queue2.length;
        int[] queue = new int[q1+q2];
        long tmp = 0, total = 0;
        for (int i=0; i<q1; i++) {
            queue[i] = queue1[i];
            tmp += queue1[i];
            total += queue1[i];
        }
        for (int i=0; i<q2; i++) {
            queue[i+q1] = queue2[i];
            total += queue2[i];
        }
        
        int left = 0, right = q1;
        int cnt = 0;
        while (left <= right && right < queue.length) {
            if (tmp < total/2) {
                tmp += queue[right++];
                cnt++;
            } else if (tmp > total/2) {
                tmp -= queue[left++];
                cnt++;
            } else {
                return cnt;
            }
        }
        return -1;
    }
}
