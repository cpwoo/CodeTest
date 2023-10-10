def solution(n, words):
    s = set()
    s.add(words[0])
    for i in range(1, len(words)):
        w = words[i]
        if w in s or len(w) == 1 or words[i-1][-1] != words[i][0]:
            return [(i%n)+1, (i//n)+1]
        s.add(w)
    return [0, 0]


n = 3
words = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]
print(solution(n, words)) # [3,3]

n = 5
words = ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]
print(solution(n, words)) # [0,0]

n = 2
words = ["hello", "one", "even", "never", "now", "world", "draw"]
print(solution(n, words)) # [1,3]
