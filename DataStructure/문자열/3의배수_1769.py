n = input()

s = n
sum = 0
cnt = 0
while sum == 1:
    sum = 0
    cnt += 1
    for i in range(len(s)):
        sum += int(n[i])
    if sum == 3 or sum == 6 or sum == 9:
        print("YES")
        break
    s = sum


