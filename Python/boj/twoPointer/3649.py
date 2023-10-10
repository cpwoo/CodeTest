import sys
input = lambda: sys.stdin.readline().rstrip()

while True:
    try:
        x = int(input())*10_000_000
        n = int(input())
        arr = sorted([int(input()) for _ in range(n)])
        left, right = 0, n-1
        flag = False
        while left < right:
            tmp = arr[left]+arr[right]
            if tmp == x:
                print("yes %d %d" %(arr[left], arr[right]))
                flag = True
                break
            elif tmp < x:
                left += 1
            else:
                right -= 1
        if not flag:
            print("danger")
    except:
        break
