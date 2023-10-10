def solution(cap, n, deliveries, pickups):
    answer = 0

    deliver, pickup = 0, 0
    for i in range(n-1, -1, -1):
        deliver += deliveries[i]
        pickup += pickups[i]

        while deliver > 0 or pickup > 0:
            deliver -= cap
            pickup -= cap
            answer += (i+1)*2

    return answer


cap, n = 4, 5
deliveries = [1, 0, 3, 1, 2]
pickups = [0, 3, 0, 4, 0]
print(solution(cap, n, deliveries, pickups)) # 16

cap, n = 2, 7
deliveries = [1, 0, 2, 0, 1, 0, 2]
pickups = [0, 2, 0, 1, 0, 2, 0]
print(solution(cap, n, deliveries, pickups)) # 30
