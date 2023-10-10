import re

def solution(files):
    a = sorted(files, key=lambda file : int(re.findall('\d+', file)[0]))
    b = sorted(a, key=lambda file : re.split('\d+', file.lower())[0])
    return b


files = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
print(solution(files)) # ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

files = ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
print(solution(files)) # ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
