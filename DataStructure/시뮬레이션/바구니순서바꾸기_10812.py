n, m = map(int, input().split())

basket = [i for i in range(n + 1)]

for i in range(m):
    s, e, m = map(int, input().split())
    new_basket = basket[m:e + 1] + basket[s:m]
    basket[s:e + 1] = new_basket
print(*basket[1:])


