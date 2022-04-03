n, m = map(int, input().split())

basket = [0] * n

for i in range(m):
    s, e, num = map(int, input().split())
    for j in range(s - 1, e):
        basket[j] = num
print(' '.join(str(i) for i in basket))