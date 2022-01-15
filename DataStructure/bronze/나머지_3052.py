arr = set()
for i in range(0, 10):
    value = int(input())
    arr.add(value % 42)
print(len(arr))
