import os
import sys

# https://jeong-jun.su/boj13701/
# 메모리가 8MB이므로 버퍼를 1000바이트로 제한해서 입력
# 정상적으로 받으면 32bit*5백만 = 20MB가 필요한데 8MB 제한이므로 비트마스킹 사용
# 주석 제거하고 pypy로 제출해야 정답

def setBit(M):
    global bit
    idx = M//32
    sft = (1<<(M%32))

    if not bit[idx]&sft:
        print(M, end=" ")
        bit[idx] |= sft

# 33_554_432 / 32 = 1_048_576
bit = [0]*1048576

reader = os.fdopen(sys.stdin.fileno(), "rb", 1000)
while True:
    M = 0
    while True:
        ch = reader.read(1)
        if b"0" <= ch <= b"9":
            M = 10*M + int(ch)
        elif ch == b" ":
            break
        else:
            setBit(M)
            exit()
    setBit(M)
