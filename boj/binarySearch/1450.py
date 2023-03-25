import sys
input = lambda: sys.stdin.readline().rstrip()

def brute_force(idx, w, things, size, result):
    if idx >= size:
        result.append(w)
        return
    brute_force(idx+1, w, things, size, result)
    brute_force(idx+1, w+things[idx], things, size, result)

def binary_search(start, end, key, arr):
    while start < end:
        mid = (start+end)//2
        if arr[mid] <= key:
            start = mid+1
        else:
            end = mid
    return end

N, C = map(int, input().split())
things = list(map(int, input().split()))
a_things = things[:N//2]
b_things = things[N//2:]
a_result, b_result = [], []

brute_force(0, 0, a_things, len(a_things), a_result)
brute_force(0, 0, b_things, len(b_things), b_result)

b_result.sort()
b_len = len(b_result)
cnt = 0
for i in a_result:
    if C-i < 0:
        continue
    cnt += binary_search(0, b_len, C-i, b_result)

print(cnt)
