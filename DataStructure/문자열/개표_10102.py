n = int(input())
s = input()
cnt1 = 0
cnt2 = 0

for i in range(n):
    if s[i] == 'A':
        cnt1 += 1
    else:
        cnt2 += 1
if cnt1 > cnt2:
    print('A')
elif cnt1 < cnt2:
    print('B')
else:
    print('Tie')