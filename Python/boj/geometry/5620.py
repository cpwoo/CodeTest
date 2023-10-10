import sys
input = lambda: sys.stdin.readline().rstrip()

# 2261번과 완전히 똑같은 문제 => Not Rating

INF = sys.maxsize

def dist(p1, p2):
    return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2

def closest_pair(start, end):
    if start == end:
        return INF
    if end-start == 1:
        return dist(points[start], points[end])
    
    mid = (start+end)//2
    _min = min(closest_pair(start, mid), closest_pair(mid+1, end))

    can = []
    for i in range(start, end+1):
        if (points[mid][0] - points[i][0])**2 < _min:
            can.append(points[i])
    can.sort(key=lambda t: t[1])

    c = len(can)
    for i in range(c-1):
        for j in range(i+1, c):
            if (can[i][1]-can[j][1])**2 < _min:
                _min = min(_min, dist(can[i], can[j]))
            else:
                break
    
    return _min


n = int(input())
points = sorted([list(map(int, input().split())) for _ in range(n)])

print(closest_pair(0, n-1))
