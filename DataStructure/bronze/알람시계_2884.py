h, m = map(int, input().split())

if h == 0:
    if m - 45 < 0:
        h = 23
        m = 60 - abs((m - 45))
    else:
        m -= 45

else:
    if m - 45 < 0:
        h -= 1
        m = 60 - abs((m - 45))
    else:
        m -= 45
print(h, m)