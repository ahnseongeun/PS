inputList = list(map(int, input().split()))
result = 0
for value in inputList:
    result += (value ** 2)
print(result % 10)
