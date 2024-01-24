import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

def check():
    tot = 4*ord("A")+22

    if ord(star[0])+ord(star[2])+ord(star[5])+ord(star[7]) != tot:
        return False
    if ord(star[1])+ord(star[2])+ord(star[3])+ord(star[4]) != tot:
        return False
    if ord(star[0])+ord(star[3])+ord(star[6])+ord(star[10]) != tot:
        return False
    if ord(star[7])+ord(star[8])+ord(star[9])+ord(star[10]) != tot:
        return False
    if ord(star[1])+ord(star[5])+ord(star[8])+ord(star[11]) != tot:
        return False
    if ord(star[4])+ord(star[6])+ord(star[9])+ord(star[11]) != tot:
        return False

    return True


def solve(cur, cand):
    global ans, flag
    if flag:
        return
    if cur == 12:
        if check():
            flag = True
            ans = cand[:]
        return
    if cand[cur] != "x":
        solve(cur+1, cand)
    else:
        for i in range(12):
            if not visited[alpha[i]]:
                cand[cur] = alpha[i]
                visited[alpha[i]] = True
                solve(cur+1, cand)
                visited[alpha[i]] = False
                cand[cur] = "x"
                if flag:
                    return


board = [list(input()) for _ in range(5)]
star = [""]*12
alpha = [chr(i) for i in range(ord("A"), ord("L")+1)]

idx = 0
visited = defaultdict(bool)

for i in range(5):
    for j in range(9):
        if board[i][j].isalpha():
            star[idx] = board[i][j]
            idx += 1
            if board[i][j] != "x":
                visited[board[i][j]] = True

ans = []
flag = False

solve(0, star)

idx = 0
for i in range(5):
    for j in range(9):
        if board[i][j].isalpha():
            board[i][j] = ans[idx]
            idx += 1

for i in range(5):
    print("".join(board[i]))
