import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def postorder(first, end):
    if first > end:
        return
    mid = end+1
    for i in range(first+1, end+1):
        if arr[first] < arr[i]:
            mid = i
            break

    postorder(first+1, mid-1)
    postorder(mid, end)
    
    return arr[first]


arr = []
# EOF Error
while True:
    try:
        arr.append(int(input()))
    except:
        break

print(postorder(0, len(arr)-1))
