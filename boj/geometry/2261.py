import sys
input = lambda: sys.stdin.readline().rstrip()

# https://casterian.net/algo-prob/boj2261.html

INF = sys.maxsize

# 어차피 거리의 제곱 구하기 때문에 **0.5 필요 없음
def dist(p1, p2):
    return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2

def closest_pair(start, end):
    if start == end:
        return INF
    if end-start == 1:
        return dist(points[start], points[end])
    
    # 분할 정복
    mid = (start+end)//2
    _min = min(closest_pair(start, mid), closest_pair(mid+1, end))

    # x축 기준으로 후보 찾고 y축 정렬
    can = []
    for i in range(start, end+1):
        if (points[mid][0] - points[i][0])**2 < _min:
            can.append(points[i])
    can.sort(key=lambda t: t[1])

    # y축 기준으로 후보 점들 사이 거리 비교 
    # 최소값이 될 리가 없는 경우는 break 해서 시간복잡도 줄이기 (가지치기)
    c = len(can)
    for i in range(c-1):
        for j in range(i+1, c):
            if (can[i][1]-can[j][1])**2 < _min:
                _min = min(_min, dist(can[i], can[j]))
            else:
                break
    
    return _min


n = int(input())
# x축 기준 정렬
points = sorted([list(map(int, input().split())) for _ in range(n)])

print(closest_pair(0, n-1))
