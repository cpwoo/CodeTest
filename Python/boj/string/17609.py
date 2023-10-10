import sys
input = lambda: sys.stdin.readline().rstrip()

def check0(word, left, right):
    while (left < right):
        if (word[left] == word[right]):
            left += 1
            right -= 1
        else:
            return False
    return True

def check1(word, left, right):
    while (left < right):
        if (word[left] == word[right]):
            left += 1
            right -= 1
        else:
            if check0(word, left+1, right) or check0(word, left, right-1):
                return 1
            else:
                return 2
    return 0


for _ in range(int(input())):
    word = input()
    left, right = 0, len(word)-1
    print(check1(word, left, right))
