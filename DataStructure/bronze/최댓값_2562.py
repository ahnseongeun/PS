idx = 1
maxValue = -1
for i in range(9):
    value = int(input())
    if value > maxValue:
        maxValue = value
        idx = i + 1
print(maxValue)
print(idx)