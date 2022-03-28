n = int(input())

arr = {}
maxValue = 0
minValue = 99999999
maxName = ""
minName = ""
for _ in range(n):
    name, day, month, year = input().split(" ")
    arr[name] = int(year + month.zfill(2) + day.zfill(2))
    if maxValue < arr[name]:
        maxValue = arr[name]
        maxName = name
    if minValue > arr[name]:
        minValue = arr[name]
        minName = name
print(maxName)
print(minName)