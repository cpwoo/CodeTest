import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))

ret = "YES"
room = [0]

for a in arr:
    room.sort(reverse=True)
    for i in range(len(room)):
        if room[i] < a:
            room[i] = a
            break
    else:
        room.append(a)
        if len(room) > k:
            ret = "NO"
            break

print(ret)
