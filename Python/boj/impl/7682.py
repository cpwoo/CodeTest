import sys
input = lambda: sys.stdin.readline().rstrip()

def win(a):
    for i in range(3):
        if st[i] == st[i+3] == st[i+6] == a:
            return True
        if st[3*i] == st[3*i+1] == st[3*i+2] == a:
            return True
    if st[0] == st[4] == st[8] == a:
        return True
    if st[2] == st[4] == st[6] == a:
        return True
    return False


while True:
    st = input()
    
    if st == "end":
        break
    
    flagX, flagO = win("X"), win("O")
    cntX, cntO = st.count("X"), st.count("O")

    if flagX and flagO:
        print("invalid")
    elif flagX:
        if cntX == cntO+1:
            print("valid")
        else:
            print("invalid")
    elif flagO:
        if cntX == cntO:
            print("valid")
        else:
            print("invalid")
    else:
        if (cntX, cntO) == (5, 4):
            print("valid")
        else:
            print("invalid")
