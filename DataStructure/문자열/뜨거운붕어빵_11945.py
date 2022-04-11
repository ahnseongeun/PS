n, m = map(int, input().split(" "))
arr = [0] * n

for i in range(n):
    arr[i] = "".join(reversed(input()))
    print(arr[i])
