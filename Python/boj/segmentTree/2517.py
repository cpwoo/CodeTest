import sys
input = lambda: sys.stdin.readline().rstrip()

# 최대 가능 등수 = 현재 등수 - 자신보다 앞에 있는 사람 중 자신보다 실력이 낮은 사람 수

def query(i):
    ans = 0
    while i>0:
        ans += tree[i]
        i -= (i&-i)
    return ans

def update(i, num):
    while i <= n:
        tree[i] += num
        i += (i&-i)


n = int(input())
info = []
for i in range(n):
    x = int(input())
    info.append([x, i+1]) # 실력, idx
info.sort() # 정렬
for i in range(n):
    info[i][0] = i+1 # 실력을 순위로 대입
    info[i][0], info[i][1] = info[i][1], info[i][0] # swap
info.sort() # 다시 정렬

tree = [0]*500005
for i in range(n):
    tmp = info[i][1]
    print((i+1)-query(tmp-1))
    update(tmp, 1)
