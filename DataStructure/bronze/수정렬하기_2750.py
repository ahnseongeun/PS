n = int(input())
arr = [0] * n
for i in range(n):
    arr[i] = int(input())
arr = sorted(arr)
for i in range(n):
    print(arr[i])
