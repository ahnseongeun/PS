s = list(input().split(','))

cnt = 0
for i in range(len(s)):
    if s[i].isdigit():
        cnt += 1
print(cnt)