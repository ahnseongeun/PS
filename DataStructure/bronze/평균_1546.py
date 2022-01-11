n = int(input())
scores = list(map(int, input().split()))
maxValue = max(scores)
sumValue = 0
for score in scores:
    sumValue += (score / maxValue * 100)
print(sumValue / n)


