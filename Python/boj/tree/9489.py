import sys
input = lambda: sys.stdin.readline().rstrip()

while True:
    n, k = map(int, input().split())
    if (n, k) == (0, 0): break

    arr = [-1] + list(map(int, input().split()))
    parent = [0]*(n+1)
    parent[0] = -1
    target = 0
    idx = -1
    
    for i in range(1,n+1):
        if arr[i] == k:
            target = i
        if arr[i] != arr[i-1]+1:
            idx += 1
        parent[i] = idx
    
    answer = 0
    for i in range(1,n+1):
        if parent[i] != parent[target] and parent[parent[i]] == parent[parent[target]]:
            answer += 1
    
    print(answer)
