for _ in range(3):
    s = input()
    cnt = 1
    result = 1
    ch = s[0]
    for i in s[1:]:
        if ch == i:
            cnt += 1
            result = max(result, cnt)
        else:
            cnt = 1
            ch = i
    print(result)

