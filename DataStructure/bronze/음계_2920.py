arr = list(map(int, input().split()))
firstValue = arr[0]
flag = 0
if firstValue == 1:
    flag = 0
    for i in range(1, 8):
        if i == arr[i - 1]:
            continue
        flag = 2
        break
elif firstValue == 8:
    flag = 1
    for i in range(8, 1, -1):
        if i == arr[i - 1]:
            continue
        flag = 2
        break
else:
    flag = 2

if int(flag) == 0:
    print("ascending")
elif int(flag) == 1:
    print("descending")
if int(flag) == 2:
    print("mixed")

