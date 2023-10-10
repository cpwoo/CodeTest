import sys
input = lambda: sys.stdin.readline().rstrip()

K = int(input())-1

i = 1
while True:
    if K >= 2**i:
        K -= 2**i
    else:
        break
    i += 1

K = bin(K)[2:].zfill(i).replace("0", "4").replace("1", "7")
print(K)
