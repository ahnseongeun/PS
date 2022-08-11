n, m = map(int, input().split())
arr = [i for i in range(1, n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr = arr[:a - 1] + arr[a - 1:b][::-1] + arr[b:]
print(arr[2:4][::-1])
for i in arr:
    print(i , end = ' ')