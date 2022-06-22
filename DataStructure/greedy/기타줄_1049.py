n, m = map(int, input().split())
minPackage = 9999
minCount = 9999
for i in range(m):
    p, v = map(int, input().split())
    if minPackage > p:
        minPackage = p
    if minCount > v:
        minCount = v
print(n // 6 * minPackage + n % 6 * minCount)
