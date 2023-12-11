import sys
input = lambda: sys.stdin.readline().rstrip()

L, K, C = map(int, input().split())
pos = [0] + sorted(list(map(int, input().split()))) + [L]
dist = [pos[i]-pos[i-1] for i in range(1, len(pos))]

left, right = 1, L

while left <= right:
    mid = (left+right)//2
    if max(dist) > mid:
        left = mid+1
    else:
        tot, cnt = 0, 0
        for d in dist[::-1]:
            tot += d
            if tot > mid:
                tot = d
                cnt += 1
        if cnt > C:
            left = mid+1
        else:
            right = mid-1
            answer = mid
            start = tot if cnt == C else dist[0]

print(answer, start)
