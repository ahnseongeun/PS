n, x = map(int, input().split())
arr = []
inputValue = list(map(int, input().split()))
for i in range(n):
    value = inputValue[i]
    if value < x:
        arr.append(str(value))
print(' '.join(arr))

