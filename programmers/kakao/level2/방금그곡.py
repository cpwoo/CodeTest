def shap_to_lower(tmp):
    tmp = tmp.replace('C#','c').replace('D#','d').replace('F#','f').replace('G#','g').replace('A#','a')
    return tmp

def calc(a, b):
    ha, ma = map(int, a.split(":"))
    hb, mb = map(int, b.split(":"))
    ta = ha*60+ma
    tb = hb*60+mb
    return tb-ta

def solution(m, musicinfos):
    m = shap_to_lower(m)
    answer = []
    for musicinfo in musicinfos:
        start, end, music, st = musicinfo.split(",")
        time = calc(start, end)
        st = shap_to_lower(st)
        tmp = st*(time//len(st))+st[:time%len(st)]
        if m in tmp:
            answer.append([music, time])
    answer.sort(key=lambda t: -t[1])
    return answer[0][0] if answer else "(None)"


m = "ABCDEFG"
musicinfos = ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]
print(solution(m, musicinfos)) # "HELLO"

m = "CC#BCC#BCC#BCC#B"
musicinfos = ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]
print(solution(m, musicinfos)) # "FOO"

m = "ABC"
musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]
print(solution(m, musicinfos)) # "WORLD"
