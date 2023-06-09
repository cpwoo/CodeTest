import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = input().replace("6", "a").replace("9", "6").replace("a", "9")[::-1].split()
arr.sort()
arr.sort(key=len)
arr.append(arr[-1])
arr.sort()

flag = True
while flag:
    flag = False
    for i in range(N):
        if len(arr[i]) >= len(arr[i+1]):
            continue
        if arr[i]+arr[i+1] > arr[i+1]+arr[i]:
            arr[i], arr[i+1] = arr[i+1], arr[i]
            flag = True

ret = "".join(arr[::-1]).replace("6", "a").replace("9", "6").replace("a", "9")
print(ret[::-1])
