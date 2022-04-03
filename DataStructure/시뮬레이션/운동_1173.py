n, m, M, T, R = map(int, input().split())

time = 0
healthTime = int(0)
X = m
while healthTime != n:
    if m + T > M:
        time = -1
        break
    if X + T <= M:
        X += T
        healthTime += 1
    elif X - R >= m:
        X -= R
    else:
        X = m

    time += 1
print(time)


