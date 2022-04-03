order = input()

arr = [1,0,0]
for ch in order:
    if ch == 'A':
        arr[0],arr[1] = arr[1], arr[0]
    elif ch == 'B':
        arr[1],arr[2] = arr[2], arr[1]
    else:
        arr[0],arr[2] = arr[2], arr[0]
print(arr.index(1) + 1)