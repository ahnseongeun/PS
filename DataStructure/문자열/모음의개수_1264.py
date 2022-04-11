while True:
    s = input().lower()
    if s == '#':
        break
    cnt = 0
    for ch in s:
        if ch == 'a' or ch == 'e' or ch == 'i' or ch == 'o' or ch == 'u':
            cnt += 1
    print(cnt)
