import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
crane = sorted(list(map(int, input().split())), reverse=True)
m = int(input())
box = sorted(list(map(int, input().split())), reverse=True)

if box[0] > crane[0]:
    print(-1)
    exit()
else:
    time = 0
    while box:
        for c in crane:
            for b in box:
                if c >= b:
                    box.remove(b)
                    break
        time += 1
    print(time)
