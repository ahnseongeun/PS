n, m = map(int, input().split())
minPackage = 9999
minCount = 9999
for i in range(m):
    p, v = map(int, input().split())
    if minPackage > p:
        minPackage = p
    if minCount > v:
        minCount = v

if minPackage < minCount * 6:
    if minPackage < n % 6 * minCount:
        print(n//6 * minPackage + minPackage)
    else:
        print(n//6 * minPackage + n%6 * minCount)
elif minPackage >= minCount * 6:
    print(n * minCount)
