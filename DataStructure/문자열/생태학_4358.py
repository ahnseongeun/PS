import sys

lines = sys.stdin.readline

arr = {}
count = 0
while True:
    line = lines().rstrip()
    if not line:
        break
    if line in arr:
        arr[line] += 1
    else:
        arr[line] = 1
    count += 1

sort_arr = sorted(arr.items(), key=lambda x:x[0])

for key, value in sort_arr:
    print("%s %.4f" % (key, (value / count) * 100))


