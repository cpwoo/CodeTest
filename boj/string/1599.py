import sys
def input(): return sys.stdin.readline().rstrip()

# a b k d e g h i l m n ng o p r s t u w y
d = {"a":"A", "b":"B", "k":"C", "d":"D",
"e":"E", "g":"F", "h":"G", "i":"H", "l":"I", 
"m":"J", "n":"K", "o":"M", "p":"N", "r":"O", 
"s":"P", "t":"Q", "u":"R", "w":"S", "y":"T"}

def change(word):
    result = word.replace("ng", "L")
    for k, v in d.items():
        result = result.replace(k, v)
    return result

def solution(arr):
    result = dict()
    for a in arr:
        tmp = change(a)
        result[a] = tmp
    result = sorted(result.items(), key=lambda x: x[1])
    return result

n = int(input())
arr = [input() for _ in range(n)]
answer = solution(arr)
for i in answer:
    print(i[0])
