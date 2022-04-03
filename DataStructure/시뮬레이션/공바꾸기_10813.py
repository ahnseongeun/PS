n, m = map(int, input().split())

arr = [str(i) for i in range(n + 1)]
result = ""
for i in range(m):
    a, b = map(int, input().split())
    temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
#print(*arr[1:])
result = " ".join(arr[1:])
print(result)