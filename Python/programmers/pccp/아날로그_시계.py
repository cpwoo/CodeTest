def solution(h1, m1, s1, h2, m2, s2):
    def cnt(h, m, s):
        ret = -1
        hd, md, sd = (h*30+m*0.5+s*0.5/60)%360, (m*6+s*0.1)%360, s*6
        if sd >= md: ret += 1
        if sd >= hd: ret += 1

        ret += (h*60+m)*2
        ret -= h
        if h >= 12: ret -= 2
        
        return ret
    
    answer = cnt(h2,m2,s2)-cnt(h1,m1,s1)
    if h1 in [0, 12] and (m1, s1) == (0, 0):
        answer += 1

    return answer
