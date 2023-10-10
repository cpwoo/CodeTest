import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 1e12

def dist(p1, p2):
    return ((p1[0]-p2[0])**2+(p1[1]-p2[1])**2)**0.5

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

ans = [MAX, 0] # [거리, idx]
for i in range(n): # 가장 가까운 편의시설에서
    m = 0
    for j in range(n): # 가장 먼 편의시설 찾기
        if i == j: continue
        m = max(m, dist(arr[i], arr[j]))
    if m < ans[0]: # ans 갱신
        ans = [m, i]

print(arr[ans[1]][0], arr[ans[1]][1])
