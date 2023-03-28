import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())

dic = dict.fromkeys(map(int, input().split()), 0) # 수열 A의 수 각각 value 값 0으로 초기화
q = [] # 정답 담을 코드

for k, i in enumerate(map(int, input().split())):
    dic[i] = k # 수열 A의 수와 그에 맞는 B의 idx 매칭 

# 이분탐색 시작
for k, i in dic.items():
    s = bisect_left(q, i)
    if s != len(q):
        q[s] = i
    else:
        q += [i]

print(len(q))
