a, b, c, m = map(int,input().split())
sum = 0
limit = 0
for _ in range(0, 24):
    if a > m:
        break
    elif limit + a > m:
        limit -= c
        if limit < 0:
            limit = 0
    else:
        limit += a
        sum += b
print(sum)