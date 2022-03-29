n, m = map(str, input().split())

sum1 = 0
sum2 = 0
for i in range(len(n)):
    sum1 += int(n[i])
for i in range(len(m)):
    sum2 += int(m[i])
print(sum1 * sum2)