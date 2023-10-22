import sys
input = lambda: sys.stdin.readline().rstrip()

def calc(i):
    if i >= (1<<n)-1:
        return 0
    left = edges[2*i]+calc(2*i+1)
    right = edges[2*i+1]+calc(2*i+2)
    if left > right:
        edges[2*i+1] += left-right
    else:
        edges[2*i] += right-left
    
    return max(left, right)


n = int(input())
edges = list(map(int, input().split()))
calc(0)

print(sum(edges))
