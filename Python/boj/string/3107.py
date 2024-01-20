import sys
input = lambda: sys.stdin.readline().rstrip()

st = input().split(":")

# ::1 이나 1:: 같은 저격 데이터 방지
if not st[0]:
    st = st[1:]
if not st[-1]:
    st = st[:-1]

ret = ""
for s in st:
    # 2번째 규칙은 1번만 사용하기 때문에 할 수 있는 코드
    # 콜론 2개가 있는 구간은 1번만 나타나므로 안전하게 사용할 수 있다
    if not s:
        ret += "0000:"*(8-len(st)+1)
    else:
        ret += s.zfill(4)+":"

print(ret[:-1])
