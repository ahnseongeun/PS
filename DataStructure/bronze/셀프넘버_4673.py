"""

"""
s = set()
for i in range(1, 10001):
    num = 0
    num += int(i)
    strNum = str(i)
    for j in range(len(strNum)):
        num += int(strNum[j])
    s.add(num)
for i in range(1, 10001):
    if i not in s:
        print(i)