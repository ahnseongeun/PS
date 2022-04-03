n, m, l = map(int, input().split())

cntArr = [0 for _ in range(n)]
cnt = 0
idx = 0
while True:
    if cntArr[idx] % 2 == 1:
        idx = (idx + l) % n
    else:
        idx = (idx + n - l) % n
    cnt += 1
    cntArr[idx] += 1
    if cntArr[idx] == m:
        break
print(cnt - 1)