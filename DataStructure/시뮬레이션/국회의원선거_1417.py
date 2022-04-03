n = int(input())

arr = [int(input()) for i in range(n)]
cnt = 0

while len(arr) > 1:
    max_value = max(arr[1:])
    if max_value < arr[0]:
        break
    idx = arr.index(max_value, 1)
    arr[0] += 1
    arr[idx] -= 1
    cnt += 1
print(cnt)
