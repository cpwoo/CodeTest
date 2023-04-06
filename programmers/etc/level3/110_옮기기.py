def solution(s):
    def f(st):
        left, I, IIO = "", 0, 0
        for i in st:
            if i == "1":
                I += 1
            elif I > 1:
                I -= 2
                IIO += 1
            else:
                left += "10" if I > 0 else "0"
                I = 0
        return left + "110" * IIO + "1" * I

    return [f(st) for st in s]


s = ["1110","100111100","0111111010"]
print(solution(s)) # ["1101","100110110","0110110111"]
